# Release

> This document explains how a new release is created for github-release-maven-plugin

* Remove snapshot from version for plugin and example then commit
* Update `src/main/resources/release-notes.md` with changes
* Invoke GitHub Action `GitHub Release`
* Invoke GitHub Action `GitHub Package Release`
  * This can also be used to deploy snapshot versions
* Invoke GitHub Action `OSSRH Package Release`
  * This can also be used to deploy snapshot versions
* Increase project version and add SNAPSHOT for plugin and example then commit (after a release the version should always be a snapshot version)
