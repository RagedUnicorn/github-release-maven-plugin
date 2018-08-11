package com.ragedunicorn.tools.maven.model;

import com.google.gson.annotations.SerializedName;

import java.util.Objects;

public class GitHubApiAsset {
  private String url;

  private int id;

  @SerializedName("node_id")
  private String nodeId;

  private String name;

  private String label;

  @SerializedName("content_type")
  private String contentType;

  private String state;

  private int size;

  @SerializedName("download_count")
  private int downloadCount;

  @SerializedName("created_at")
  private String createdAt;

  @SerializedName("updated_at")
  private String updatedAt;

  @SerializedName("browser_download_url")
  private String browserDownloadUrl;

  private GitHubApiAuthor uploader;

  public String getUrl() {
    return url;
  }

  public void setUrl(String url) {
    this.url = url;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getNodeId() {
    return nodeId;
  }

  public void setNodeId(String nodeId) {
    this.nodeId = nodeId;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getLabel() {
    return label;
  }

  public void setLabel(String label) {
    this.label = label;
  }

  public String getContentType() {
    return contentType;
  }

  public void setContentType(String contentType) {
    this.contentType = contentType;
  }

  public String getState() {
    return state;
  }

  public void setState(String state) {
    this.state = state;
  }

  public int getSize() {
    return size;
  }

  public void setSize(int size) {
    this.size = size;
  }

  public int getDownloadCount() {
    return downloadCount;
  }

  public void setDownloadCount(int downloadCount) {
    this.downloadCount = downloadCount;
  }

  public String getCreatedAt() {
    return createdAt;
  }

  public void setCreatedAt(String createdAt) {
    this.createdAt = createdAt;
  }

  public String getUpdatedAt() {
    return updatedAt;
  }

  public void setUpdatedAt(String updatedAt) {
    this.updatedAt = updatedAt;
  }

  public String getBrowserDownloadUrl() {
    return browserDownloadUrl;
  }

  public void setBrowserDownloadUrl(String browserDownloadUrl) {
    this.browserDownloadUrl = browserDownloadUrl;
  }

  public GitHubApiAuthor getUploader() {
    return uploader;
  }

  public void setUploader(GitHubApiAuthor uploader) {
    this.uploader = uploader;
  }

  @Override
  public String toString() {
    return "GitHubApiAsset{"
        + "url='" + url + '\''
        + ", id=" + id
        + ", nodeId='" + nodeId + '\''
        + ", name='" + name + '\''
        + ", label='" + label + '\''
        + ", contentType='" + contentType + '\''
        + ", state='" + state + '\''
        + ", size=" + size
        + ", downloadCount=" + downloadCount
        + ", createdAt='" + createdAt + '\''
        + ", updatedAt='" + updatedAt + '\''
        + ", browserDownloadUrl='" + browserDownloadUrl + '\''
        + ", uploader=" + uploader
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
    GitHubApiAsset response = (GitHubApiAsset) o;
    return id == response.id
        && size == response.size
        && downloadCount == response.downloadCount
        && Objects.equals(url, response.url)
        && Objects.equals(nodeId, response.nodeId)
        && Objects.equals(name, response.name)
        && Objects.equals(label, response.label)
        && Objects.equals(contentType, response.contentType)
        && Objects.equals(state, response.state)
        && Objects.equals(createdAt, response.createdAt)
        && Objects.equals(updatedAt, response.updatedAt)
        && Objects.equals(browserDownloadUrl, response.browserDownloadUrl)
        && Objects.equals(uploader, response.uploader);
  }

  @Override
  public int hashCode() {
    return Objects.hash(url, id, nodeId, name, label, contentType, state, size, downloadCount,
        createdAt, updatedAt, browserDownloadUrl, uploader);
  }
}