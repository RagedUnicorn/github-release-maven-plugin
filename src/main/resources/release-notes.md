# github-release-maven-plugin 1.0.9

## Improvements

* Add maven-dependency-plugin dependency analysis to the verify phase to catch undeclared and unused dependencies

## Dependencies

* Replace maven-compat with maven-settings as the provided Maven dependency
* Replace httpmime with httpcore to match what the plugin actually uses
* Remove the unused slf4j-simple dependency
