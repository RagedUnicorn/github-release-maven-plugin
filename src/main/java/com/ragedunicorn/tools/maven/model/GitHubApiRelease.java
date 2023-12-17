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
import java.util.Objects;

@SuppressWarnings("PMD.TooManyFields")
public class GitHubApiRelease {
  private String url;

  @SerializedName("assets_url")
  private String assetsUrl;

  @SerializedName("upload_url")
  private String uploadUrl;

  @SerializedName("html_url")
  private String htmlUrl;

  private Integer id;

  @SerializedName("node_id")
  private String nodeId;

  @SerializedName("tag_name")
  private String tagName;

  @SerializedName("target_commitish")
  private String targetCommitish;

  private String name;

  private Boolean draft;

  private GitHubApiAuthor author;

  private Boolean prerelease;

  @SerializedName("created_at")
  private String createdAt;

  @SerializedName("published_at")
  private String publishedAt;

  @SerializedName("tarball_url")
  private String tarballUrl;

  @SerializedName("zipball_url")
  private String zipballUrl;

  private String body;

  public String getUrl() {
    return url;
  }

  public void setUrl(String url) {
    this.url = url;
  }

  public String getAssetsUrl() {
    return assetsUrl;
  }

  public void setAssetsUrl(String assetsUrl) {
    this.assetsUrl = assetsUrl;
  }

  public String getUploadUrl() {
    return uploadUrl;
  }

  public void setUploadUrl(String uploadUrl) {
    this.uploadUrl = uploadUrl;
  }

  public String getHtmlUrl() {
    return htmlUrl;
  }

  public void setHtmlUrl(String htmlUrl) {
    this.htmlUrl = htmlUrl;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getNodeId() {
    return nodeId;
  }

  public void setNodeId(String nodeId) {
    this.nodeId = nodeId;
  }

  public String getTagName() {
    return tagName;
  }

  public void setTagName(String tagName) {
    this.tagName = tagName;
  }

  public String getTargetCommitish() {
    return targetCommitish;
  }

  public void setTargetCommitish(String targetCommitish) {
    this.targetCommitish = targetCommitish;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Boolean getDraft() {
    return draft;
  }

  public void setDraft(Boolean draft) {
    this.draft = draft;
  }

  public GitHubApiAuthor getAuthor() {
    return author;
  }

  public void setAuthor(GitHubApiAuthor author) {
    this.author = author;
  }

  public Boolean getPrerelease() {
    return prerelease;
  }

  public void setPrerelease(Boolean prerelease) {
    this.prerelease = prerelease;
  }

  public String getCreatedAt() {
    return createdAt;
  }

  public void setCreatedAt(String createdAt) {
    this.createdAt = createdAt;
  }

  public String getPublishedAt() {
    return publishedAt;
  }

  public void setPublishedAt(String publishedAt) {
    this.publishedAt = publishedAt;
  }

  public String getTarballUrl() {
    return tarballUrl;
  }

  public void setTarballUrl(String tarballUrl) {
    this.tarballUrl = tarballUrl;
  }

  public String getZipballUrl() {
    return zipballUrl;
  }

  public void setZipballUrl(String zipballUrl) {
    this.zipballUrl = zipballUrl;
  }

  public String getBody() {
    return body;
  }

  public void setBody(String body) {
    this.body = body;
  }

  @Override
  public String toString() {
    return "GitHubApiRelease{"
        + "url='" + url + '\''
        + ", assetsUrl='" + assetsUrl + '\''
        + ", uploadUrl='" + uploadUrl + '\''
        + ", htmlUrl='" + htmlUrl + '\''
        + ", id=" + id
        + ", nodeId='" + nodeId + '\''
        + ", tagName='" + tagName + '\''
        + ", targetCommitish='" + targetCommitish + '\''
        + ", name='" + name + '\''
        + ", draft=" + draft
        + ", author=" + author
        + ", prerelease=" + prerelease
        + ", createdAt='" + createdAt + '\''
        + ", publishedAt='" + publishedAt + '\''
        + ", tarballUrl='" + tarballUrl + '\''
        + ", zipballUrl='" + zipballUrl + '\''
        + ", body='" + body + '\''
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
    GitHubApiRelease that = (GitHubApiRelease) o;
    return Objects.equals(url, that.url)
        && Objects.equals(assetsUrl, that.assetsUrl)
        && Objects.equals(uploadUrl, that.uploadUrl)
        && Objects.equals(htmlUrl, that.htmlUrl)
        && Objects.equals(id, that.id)
        && Objects.equals(nodeId, that.nodeId)
        && Objects.equals(tagName, that.tagName)
        && Objects.equals(targetCommitish, that.targetCommitish)
        && Objects.equals(name, that.name)
        && Objects.equals(draft, that.draft)
        && Objects.equals(author, that.author)
        && Objects.equals(prerelease, that.prerelease)
        && Objects.equals(createdAt, that.createdAt)
        && Objects.equals(publishedAt, that.publishedAt)
        && Objects.equals(tarballUrl, that.tarballUrl)
        && Objects.equals(zipballUrl, that.zipballUrl)
        && Objects.equals(body, that.body);
  }

  @Override
  public int hashCode() {
    return Objects.hash(url, assetsUrl, uploadUrl, htmlUrl, id, nodeId, tagName, targetCommitish,
        name, draft, author, prerelease, createdAt, publishedAt, tarballUrl, zipballUrl, body);
  }
}
