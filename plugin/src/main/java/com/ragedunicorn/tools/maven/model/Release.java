package com.ragedunicorn.tools.maven.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.Objects;

public class Release {
  @SerializedName("tag_name")
  @Expose
  private String tagName;

  @SerializedName("target_commitish")
  @Expose
  private String targetCommitish;

  @Expose
  private String name;

  @Expose
  private String body;

  private String releaseNotes;

  @Expose
  private Boolean draft;

  @Expose
  private Boolean prerelease;

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

  public String getBody() {
    return body;
  }

  public void setBody(String body) {
    this.body = body;
  }

  public String getReleaseNotes() {
    return releaseNotes;
  }

  public void setReleaseNotes(String releaseNotes) {
    this.releaseNotes = releaseNotes;
  }

  public Boolean getDraft() {
    return draft;
  }

  public void setDraft(Boolean draft) {
    this.draft = draft;
  }

  public Boolean getPrerelease() {
    return prerelease;
  }

  public void setPrerelease(Boolean prerelease) {
    this.prerelease = prerelease;
  }

  @Override
  public String toString() {
    return "Release{"
        + "tagName='" + tagName + '\''
        + ", targetCommitish='" + targetCommitish + '\''
        + ", name='" + name + '\''
        + ", body='" + body + '\''
        + ", releaseNotes='" + releaseNotes + '\''
        + ", draft=" + draft
        + ", prerelease=" + prerelease
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
    Release release = (Release) o;
    return Objects.equals(tagName, release.tagName)
        && Objects.equals(targetCommitish, release.targetCommitish)
        && Objects.equals(name, release.name)
        && Objects.equals(body, release.body)
        && Objects.equals(releaseNotes, release.releaseNotes)
        && Objects.equals(draft, release.draft)
        && Objects.equals(prerelease, release.prerelease);
  }

  @Override
  public int hashCode() {
    return Objects.hash(tagName, targetCommitish, name, body, releaseNotes, draft, prerelease);
  }
}
