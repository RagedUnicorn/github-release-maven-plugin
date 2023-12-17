/*
 * Copyright (c) 2023 Michael Wiesendanger
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
