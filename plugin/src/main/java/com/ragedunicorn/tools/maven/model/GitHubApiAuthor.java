package com.ragedunicorn.tools.maven.model;

import com.google.gson.annotations.SerializedName;

import java.util.Objects;

public class GitHubApiAuthor {
  private String login;

  private Integer id;

  @SerializedName("node_id")
  private String nodeId;

  @SerializedName("avatar_url")
  private String avatarUrl;

  @SerializedName("gravatar_id")
  private String gravatarId;

  private String url;

  @SerializedName("html_url")
  private String htmlUrl;

  @SerializedName("followers_url")
  private String followersUrl;

  @SerializedName("following_url")
  private String followingUrl;

  @SerializedName("gists_url")
  private String gistsUrl;

  @SerializedName("starred_url")
  private String starredUrl;

  @SerializedName("subscriptions_url")
  private String subscriptionsUrl;

  @SerializedName("organizations_url")
  private String organizationsUrl;

  @SerializedName("repos_url")
  private String reposUrl;

  @SerializedName("events_url")
  private String eventsUrl;

  @SerializedName("received_events_url")
  private String receivedEventsUrl;

  private String type;

  @SerializedName("site_admin")
  private Boolean siteAdmin;

  public String getLogin() {
    return login;
  }

  public void setLogin(String login) {
    this.login = login;
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

  public String getAvatarUrl() {
    return avatarUrl;
  }

  public void setAvatarUrl(String avatarUrl) {
    this.avatarUrl = avatarUrl;
  }

  public String getGravatarId() {
    return gravatarId;
  }

  public void setGravatarId(String gravatarId) {
    this.gravatarId = gravatarId;
  }

  public String getUrl() {
    return url;
  }

  public void setUrl(String url) {
    this.url = url;
  }

  public String getHtmlUrl() {
    return htmlUrl;
  }

  public void setHtmlUrl(String htmlUrl) {
    this.htmlUrl = htmlUrl;
  }

  public String getFollowersUrl() {
    return followersUrl;
  }

  public void setFollowersUrl(String followersUrl) {
    this.followersUrl = followersUrl;
  }

  public String getFollowingUrl() {
    return followingUrl;
  }

  public void setFollowingUrl(String followingUrl) {
    this.followingUrl = followingUrl;
  }

  public String getGistsUrl() {
    return gistsUrl;
  }

  public void setGistsUrl(String gistsUrl) {
    this.gistsUrl = gistsUrl;
  }

  public String getStarredUrl() {
    return starredUrl;
  }

  public void setStarredUrl(String starredUrl) {
    this.starredUrl = starredUrl;
  }

  public String getSubscriptionsUrl() {
    return subscriptionsUrl;
  }

  public void setSubscriptionsUrl(String subscriptionsUrl) {
    this.subscriptionsUrl = subscriptionsUrl;
  }

  public String getOrganizationsUrl() {
    return organizationsUrl;
  }

  public void setOrganizationsUrl(String organizationsUrl) {
    this.organizationsUrl = organizationsUrl;
  }

  public String getReposUrl() {
    return reposUrl;
  }

  public void setReposUrl(String reposUrl) {
    this.reposUrl = reposUrl;
  }

  public String getEventsUrl() {
    return eventsUrl;
  }

  public void setEventsUrl(String eventsUrl) {
    this.eventsUrl = eventsUrl;
  }

  public String getReceivedEventsUrl() {
    return receivedEventsUrl;
  }

  public void setReceivedEventsUrl(String receivedEventsUrl) {
    this.receivedEventsUrl = receivedEventsUrl;
  }

  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public Boolean getSiteAdmin() {
    return siteAdmin;
  }

  public void setSiteAdmin(Boolean siteAdmin) {
    this.siteAdmin = siteAdmin;
  }

  @Override
  public String toString() {
    return "GitHubApiAuthor{"
        + "login='" + login + '\''
        + ", id=" + id
        + ", nodeId='" + nodeId + '\''
        + ", avatarUrl='" + avatarUrl + '\''
        + ", gravatarId='" + gravatarId + '\''
        + ", url='" + url + '\''
        + ", htmlUrl='" + htmlUrl + '\''
        + ", followersUrl='" + followersUrl + '\''
        + ", followingUrl='" + followingUrl + '\''
        + ", gistsUrl='" + gistsUrl + '\''
        + ", starredUrl='" + starredUrl + '\''
        + ", subscriptionsUrl='" + subscriptionsUrl + '\''
        + ", organizationsUrl='" + organizationsUrl + '\''
        + ", reposUrl='" + reposUrl + '\''
        + ", eventsUrl='" + eventsUrl + '\''
        + ", receivedEventsUrl='" + receivedEventsUrl + '\''
        + ", type='" + type + '\''
        + ", siteAdmin=" + siteAdmin
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
    GitHubApiAuthor that = (GitHubApiAuthor) o;
    return Objects.equals(login, that.login)
        && Objects.equals(id, that.id)
        && Objects.equals(nodeId, that.nodeId)
        && Objects.equals(avatarUrl, that.avatarUrl)
        && Objects.equals(gravatarId, that.gravatarId)
        && Objects.equals(url, that.url)
        && Objects.equals(htmlUrl, that.htmlUrl)
        && Objects.equals(followersUrl, that.followersUrl)
        && Objects.equals(followingUrl, that.followingUrl)
        && Objects.equals(gistsUrl, that.gistsUrl)
        && Objects.equals(starredUrl, that.starredUrl)
        && Objects.equals(subscriptionsUrl, that.subscriptionsUrl)
        && Objects.equals(organizationsUrl, that.organizationsUrl)
        && Objects.equals(reposUrl, that.reposUrl)
        && Objects.equals(eventsUrl, that.eventsUrl)
        && Objects.equals(receivedEventsUrl, that.receivedEventsUrl)
        && Objects.equals(type, that.type)
        && Objects.equals(siteAdmin, that.siteAdmin);
  }

  @Override
  public int hashCode() {
    return Objects.hash(login, id, nodeId, avatarUrl, gravatarId, url, htmlUrl, followersUrl,
        followingUrl, gistsUrl, starredUrl, subscriptionsUrl, organizationsUrl, reposUrl, eventsUrl,
        receivedEventsUrl, type, siteAdmin);
  }
}
