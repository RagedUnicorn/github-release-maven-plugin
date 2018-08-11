package com.ragedunicorn.tools.maven;

import org.apache.maven.plugin.MojoExecutionException;
import org.junit.Assert;
import org.junit.Test;

import java.net.URI;
import java.util.Arrays;

public class GitHubReleaseGitHubClientTest {
  @Test
  public void testEndpointUriPreparation() {
    final String ENDPOINT = "/repos/:owner/:repo/releases";
    final String owner = "test-owner";
    final String repository = "test-repository";

    GitHubClient client = new GitHubClient();
    client.setOwner(owner);
    client.setRepository(repository);
    client.setOAuthToken("test-token");

    try {
      URI preparedUri = client.prepareEndpointUri(ENDPOINT);
      Assert.assertEquals(preparedUri.getPath(), "/repos/" + owner + "/" + repository + "/releases");
    } catch (MojoExecutionException e) {
      Assert.fail("MojoExecutionException: " + Arrays.toString(e.getStackTrace()));
    }
  }

  @Test(expected = IllegalStateException.class)
  public void testPrepareEndpointUriExpectedInvalidState() {
    GitHubClient client = new GitHubClient();
    try {
      client.prepareEndpointUri("/some/url");
    } catch (MojoExecutionException e) {
      Assert.fail("MojoExecutionException: " + Arrays.toString(e.getStackTrace()));
    }
  }

  @Test(expected = IllegalStateException.class)
  public void testGetClientUriExpectedInvalidState() {
    GitHubClient client = new GitHubClient();
    client.getHttpClient();
  }
}
