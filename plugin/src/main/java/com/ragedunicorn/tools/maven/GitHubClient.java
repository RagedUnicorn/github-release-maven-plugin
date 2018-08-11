package com.ragedunicorn.tools.maven;

import com.google.common.collect.Lists;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import org.apache.http.Header;
import org.apache.http.HttpHeaders;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicHeader;
import org.apache.maven.plugin.MojoExecutionException;

public class GitHubClient {
  public static final String USER_AGENT = "github-release-plugin";
  // custom github accept header - lock api v3
  public static final String GITHUB_MEDIA_TYPE = "application/vnd.github.v3+json";

  // github api base url
  private static final String baseUri = "https://api.github.com";
  // targeted repository
  private String repository;
  // owner of the repository
  private String owner;
  // oauth token
  private String token;

  public GitHubClient() {
    //no op
  }

  public static String getBaseUri() {
    return baseUri;
  }

  public String getRepository() {
    return repository;
  }

  public void setRepository(String repository) {
    this.repository = repository;
  }

  public String getOwner() {
    return owner;
  }

  public void setOwner(String owner) {
    this.owner = owner;
  }

  public String getOAuthToken() {
    return token;
  }

  /**
   * Set OAuth2 token.
   *
   * @param token The Oauth2 token
   */
  public void setOAuthToken(String token) {
    this.token = "token" + ' ' + token;
  }

  /**
   * Create an http client.
   *
   * @return The created http client
   */
  public CloseableHttpClient getHttpClient() {
    if (token == null || token.isEmpty() || owner == null || owner.isEmpty() || repository == null
      || repository.isEmpty()) {
      throw new IllegalStateException("GitHub client is in invalid state. Make sure to set owner, "
          + "repository and credentials");
    }

    return HttpClientBuilder
        .create()
        .useSystemProperties()
        .setDefaultHeaders(getDefaultHeaders())
        .build();
  }

  private List<Header> getDefaultHeaders() {
    return Lists.newArrayList(
        new BasicHeader(HttpHeaders.USER_AGENT, USER_AGENT),
        new BasicHeader(HttpHeaders.ACCEPT, GITHUB_MEDIA_TYPE),
        new BasicHeader(HttpHeaders.AUTHORIZATION, token)
    );
  }

  /**
   * Prepare an endpoint url by replacing placeholders with real values.
   *
   * @param path The path to prepare
   * @return The prepared URI
   * @throws MojoExecutionException If failing to prepare the URI properly
   */
  public URI prepareEndpointUri(final String path) throws MojoExecutionException {
    if (token == null || token.isEmpty() || owner == null || owner.isEmpty() || repository == null
        || repository.isEmpty()) {
      throw new IllegalStateException("GitHub client is in invalid state. Make sure to set owner, "
          + "repository and credentials");
    }

    String processedPath = "";

    processedPath = path.replace(":repo", repository);
    processedPath = processedPath.replace(":owner", owner);

    try {
      return new URI(baseUri + processedPath);
    } catch (URISyntaxException e) {
      throw new MojoExecutionException("Failed to prepare endpoint URI", e);
    }
  }
}
