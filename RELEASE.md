# Release

> This document explains how a new release is created for github-release-maven-plugin

* Remove snapshot from version and commit
* Create a new git tag and push it
  * `git tag vx.x.x`
  * `git push origin --tags`
* Draft new Github release with description
  * Title should be the version e.g. vx.x.x
  * Short description of what changed
* Deploy release artifact to OSSRH
  * mvn clean deploy -P deploy
  * mvn nexus-staging:release when autoReleaseAfterClose is set to false
  * Increase project version and add SNAPSHOT then commit (after a release the version should always be a snapshot version)

**Note:** Snapshot versions can be deployed with the same command `mvn clean deploy -P deploy`
