/*
 * Copyright (c) 2019 Michael Wiesendanger
 * Permission is hereby granted, free of charge, to any person obtaining
 * a copy of this software and associated documentation files (the
 * "Software"), to deal in the Software without restriction, including
 * without limitation the rights to use, copy, modify, merge, publish,
 * distribute, sublicense, and/or sell copies of the Software, and to
 * permit persons to whom the Software is furnished to do so, subject to
 * the following conditions:

 * The above copyright notice and this permission notice shall be
 * included in all copies or substantial portions of the Software.

 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND,
 * EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF
 * MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND
 * NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE
 * LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION
 * OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION
 * WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */

package com.ragedunicorn.tools.maven.service;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.ragedunicorn.tools.maven.GitHubClient;
import com.ragedunicorn.tools.maven.log.DefaultLog;
import com.ragedunicorn.tools.maven.model.GitHubApiClientError;
import com.ragedunicorn.tools.maven.model.GitHubApiError;
import com.ragedunicorn.tools.maven.model.GitHubApiRelease;
import com.ragedunicorn.tools.maven.model.Release;

import java.io.IOException;
import java.net.URI;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import javax.ws.rs.core.MediaType;

import org.apache.http.HttpEntity;
import org.apache.http.HttpHeaders;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.util.EntityUtils;
import org.apache.maven.plugin.MojoExecutionException;

public class ReleaseService {
  private static final String ENDPOINT = "/repos/:owner/:repo/releases";

  private final DefaultLog logger = new DefaultLog();

  private final GitHubClient gitHubClient;

  public ReleaseService(GitHubClient gitHubClient) {
    this.gitHubClient = gitHubClient;
  }

  /**
   * Create a new release.
   *
   * @param release The release object containing all relevant data for the release to create
   * @return The received response from Github after creating the release
   * @throws MojoExecutionException If the request to the Github Api failed
   */
  public GitHubApiRelease createReleaseOperation(Release release) throws MojoExecutionException {
    Release preparedRelease = prepareRelease(release);
    GitHubApiRelease githubApiRelease;
    final Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();
    final String createReleaseJson = gson.toJson(preparedRelease);
    final StringEntity entity = new StringEntity(createReleaseJson, StandardCharsets.UTF_8);
    CloseableHttpClient httpClient = gitHubClient.getHttpClient();

    HttpPost httpPost = new HttpPost();
    URI preparedEndpointUrl = gitHubClient.prepareEndpointUri(ENDPOINT);
    if (logger.isDebugEnabled()) {
      logger.debug("Endpoint Uri: " + preparedEndpointUrl.getPath());
    }
    httpPost.setURI(preparedEndpointUrl);

    httpPost.setHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON);
    httpPost.setEntity(entity);

    try {
      CloseableHttpResponse response = httpClient.execute(httpPost);
      githubApiRelease = responseHandler(response);

      if (logger.isInfoEnabled()) {
        logger.info("Created a new release:");
        logger.info("Tag name: " + githubApiRelease.getTagName());
        logger.info("Name: " + githubApiRelease.getName());
        logger.info("Url: " + githubApiRelease.getUrl());
      }

    } catch (IOException e) {
      throw new MojoExecutionException("Create release request to Github Api failed", e);
    }

    try {
      httpClient.close();
    } catch (IOException e) {
      throw new MojoExecutionException("Failed to close http client", e);
    }

    return githubApiRelease;
  }

  /**
   * Check if the release request was successful and handle both failure and success.
   *
   * @param response The response from the Github Api
   * @return The response from the Github Api as POJO
   * @throws IOException            If entity cannot be converted to a string
   * @throws MojoExecutionException If creation of release failed
   */
  private GitHubApiRelease responseHandler(CloseableHttpResponse response)
      throws IOException, MojoExecutionException {
    final Gson gson = new Gson();
    final HttpEntity entity = response.getEntity();
    final String responseString = EntityUtils.toString(entity, StandardCharsets.UTF_8);
    final int statusCode = response.getStatusLine().getStatusCode();

    if (statusCode / 100 != 2) {
      GitHubApiClientError clientError = gson.fromJson(responseString, GitHubApiClientError.class);
      List<GitHubApiError> errors = clientError.getErrors();

      for (GitHubApiError error : errors) {
        logger.error(error.toString());
      }

      throw new MojoExecutionException("Failed to create release - reason: "
          + clientError.getMessage());
    } else {
      return gson.fromJson(responseString, GitHubApiRelease.class);
    }
  }

  /**
   * Prepare a release with default values.
   *
   * @param release A release object that should get prepared
   * @return The prepared release
   * @throws MojoExecutionException If a required property is missing
   */
  private Release prepareRelease(Release release) throws MojoExecutionException {
    if (release.getTagName() == null || release.getTagName().isEmpty()) {
      throw new MojoExecutionException("Property tagName is required");
    }

    if (release.getTargetCommitish() == null || release.getTargetCommitish().isEmpty()) {
      release.setTargetCommitish("master");
    }

    if (release.getName() == null || release.getName().isEmpty()) {
      release.setName("");
    }

    if (release.getBody() == null || release.getBody().isEmpty()) {
      release.setBody("");
    }

    if (release.getDraft() == null) {
      release.setDraft(false);
    }

    if (release.getPrerelease() == null) {
      release.setPrerelease(false);
    }

    if (release.getReleaseNotes() != null) {
      logger.debug("Overwriting body with release notes file content");
      release.setBody(loadReleaseNotes(release.getReleaseNotes()));
    }

    return release;
  }

  /**
   * Load release notes from a file.
   *
   * @param releaseNotes The path to a release notes file.
   * @return The loaded release notes
   * @throws MojoExecutionException An exception occurring during the execution of a plugin
   */
  private String loadReleaseNotes(String releaseNotes) throws MojoExecutionException {
    byte[] releaseNotesContent;

    try {
      Path releaseNotesPath = Paths.get(releaseNotes);
      if (logger.isDebugEnabled()) {
        logger.debug("Release notes path: " + releaseNotes);
      }
      releaseNotesContent = Files.readAllBytes(releaseNotesPath);

      return new String(releaseNotesContent, StandardCharsets.UTF_8);
    } catch (IOException e) {
      throw new MojoExecutionException("Failed to read release notes", e);
    }
  }
}
