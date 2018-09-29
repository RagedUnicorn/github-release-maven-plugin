/*
 * Copyright (c) 2018 Michael Wiesendanger
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

import com.ragedunicorn.tools.maven.GitHubClient;
import com.ragedunicorn.tools.maven.log.DefaultLog;
import com.ragedunicorn.tools.maven.model.GitHubApiAsset;
import com.ragedunicorn.tools.maven.model.GitHubApiClientError;
import com.ragedunicorn.tools.maven.model.GitHubApiError;

import java.io.IOException;
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
import org.apache.http.entity.ByteArrayEntity;
import org.apache.http.entity.ContentType;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.util.EntityUtils;
import org.apache.maven.plugin.MojoExecutionException;


public class AssetService {
  private final DefaultLog logger = new DefaultLog();

  private final GitHubClient gitHubClient;

  public AssetService(GitHubClient gitHubClient) {
    this.gitHubClient = gitHubClient;
  }

  /**
   * Upload all assets defined to the previously created release.
   *
   * @param uploadUrl The url to upload the assets
   * @param assets    An list of paths to assets that should get uploaded
   *
   * @throws MojoExecutionException If the httpclient cannot be properly closed
   */
  public void uploadAssetsOperation(String uploadUrl, String[] assets)
      throws MojoExecutionException {
    CloseableHttpClient httpClient = gitHubClient.getHttpClient();

    for (String asset : assets) {
      GitHubApiAsset response = uploadAsset(httpClient, uploadUrl, asset);

      if (logger.isInfoEnabled()) {
        logger.info("Uploaded new asset:");
        logger.info("Name: " + response.getName());
      }
    }

    try {
      httpClient.close();
    } catch (IOException e) {
      logger.warn("Failed to close http client", e);
    }
  }

  /**
   * Upload a single asset.
   *
   * @param client    The httpclient used to execute the http post call
   * @param uploadUrl The url to upload the assets
   * @param assetPath A path to a single asset that should get uploaded
   *
   * @return The received response from Github after uploading the asset
   *
   * @throws MojoExecutionException If the request to the Github Api fails
   */
  private GitHubApiAsset uploadAsset(CloseableHttpClient client, String uploadUrl,
                                     String assetPath) throws MojoExecutionException {
    Path path = Paths.get(assetPath);
    Path fileName = path.getFileName();

    if (fileName == null) {
      throw new MojoExecutionException("Failed to retrieve filename for asset - " + assetPath);
    }

    String endpointUrl = prepareEndpointUrl(uploadUrl, fileName.toString());

    HttpPost httpPost = new HttpPost(endpointUrl);
    httpPost.setHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_OCTET_STREAM);

    try {
      byte[] fileContents = Files.readAllBytes(path);
      ByteArrayEntity entityTest = new ByteArrayEntity(fileContents,
          ContentType.APPLICATION_OCTET_STREAM);
      httpPost.setEntity(entityTest);
      CloseableHttpResponse response = client.execute(httpPost);

      return responseHandler(response);
    } catch (IOException e) {
      throw new MojoExecutionException("Upload asset request to Github Api failed", e);
    }
  }

  /**
   * Check if uploading the asset was successful and handle both failure and success.
   *
   * @param response The response from the Github Api
   *
   * @return The response from the Github Api as POJO
   *
   * @throws IOException            If entity cannot be converted to a string
   * @throws MojoExecutionException If upload of the asset fails
   */
  private GitHubApiAsset responseHandler(CloseableHttpResponse response)
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

      throw new MojoExecutionException("Failed to upload asset - reason: "
          + clientError.getMessage());
    } else {
      return gson.fromJson(responseString, GitHubApiAsset.class);
    }
  }

  /**
   * Prepare the upload url with the expected filename.
   *
   * @param uploadUrl The url to upload the assets
   * @param filename  The name of the file to upload
   *
   * @return The prepared url
   */
  private String prepareEndpointUrl(String uploadUrl, String filename) {
    String preparedEndpointUrl = uploadUrl;
    preparedEndpointUrl = preparedEndpointUrl.replace("{?name,label}", "?name="
        + filename);

    return preparedEndpointUrl;
  }
}
