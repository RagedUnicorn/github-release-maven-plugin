package com.ragedunicorn.tools.maven.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;
import java.util.Objects;

public class GitHubApiClientError {
  private String message;

  private List<GitHubApiError> errors;

  @SerializedName("documentation_url")
  private String documentationUrl;

  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }

  public List<GitHubApiError> getErrors() {
    return errors;
  }

  public void setErrors(List<GitHubApiError> errors) {
    this.errors = errors;
  }

  public String getDocumentationUrl() {
    return documentationUrl;
  }

  public void setDocumentationUrl(String documentationUrl) {
    this.documentationUrl = documentationUrl;
  }

  @Override
  public String toString() {
    return "GitHubApiClientError{"
        + "message='" + message + '\''
        + ", errors=" + errors
        + ", documentationUrl='" + documentationUrl + '\''
        + '}';
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    GitHubApiClientError that = (GitHubApiClientError) o;
    return Objects.equals(message, that.message)
        && Objects.equals(errors, that.errors)
        && Objects.equals(documentationUrl, that.documentationUrl);
  }

  @Override
  public int hashCode() {
    return Objects.hash(message, errors, documentationUrl);
  }
}
