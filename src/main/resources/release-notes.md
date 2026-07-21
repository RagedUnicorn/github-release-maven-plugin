# github-release-maven-plugin 1.0.8

## Improvements

* Add CI workflow running build, tests, Checkstyle and PMD checks
* Add integration test executing the github-release goal
* Add Docker Compose configuration for quality checks and tests
* Add Renovate configuration for automated dependency updates
* Migrate Maven Central publishing to the Sonatype Central Portal
* Migrate code quality toolchain to PMD 7 and resolve newly reported violations

## Dependencies

* Update Maven plugin dependencies to 3.9.16 (maven-core, maven-plugin-api, maven-compat)
* Update Gson to 2.14.0, HttpClient/HttpMime to 4.5.14, SLF4J to 2.x
* Update Checkstyle to 13.8.0 and maven-code-quality to 2.1.0
* Update numerous Maven build plugins to their latest versions
