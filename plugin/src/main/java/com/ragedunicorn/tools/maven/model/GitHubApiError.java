package com.ragedunicorn.tools.maven.model;

import java.util.Objects;

public class GitHubApiError {
  private String resource;

  private String code;

  private String field;

  public String getResource() {
    return resource;
  }

  public void setResource(String resource) {
    this.resource = resource;
  }

  public String getCode() {
    return code;
  }

  public void setCode(String code) {
    this.code = code;
  }

  public String getField() {
    return field;
  }

  public void setField(String field) {
    this.field = field;
  }

  @Override
  public String toString() {
    return "GitHubApiError{"
        + "resource='" + resource + '\''
        + ", code='" + code + '\''
        + ", field='" + field + '\''
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
    GitHubApiError that = (GitHubApiError) o;
    return Objects.equals(resource, that.resource)
        && Objects.equals(code, that.code)
        && Objects.equals(field, that.field);
  }

  @Override
  public int hashCode() {
    return Objects.hash(resource, code, field);
  }
}
