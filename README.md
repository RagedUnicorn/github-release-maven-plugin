# github-release-maven-plugin

> A maven plugin for creating GitHub releases including the attachment of assets and release notes

[![Maven Central](https://img.shields.io/maven-central/v/com.ragedunicorn.tools.maven/github-release-maven-plugin.svg?label=Maven%20Central)](https://search.maven.org/search?q=g:%22com.ragedunicorn.tools.maven%22%20AND%20a:%22github-release-maven-plugin%22)

## Usage

Setup pom.xml in project

```xml
<project>
  [...]
  <build>
    <plugins>
      <plugin>
        <groupId>com.ragedunicorn.tools.maven</groupId>
        <artifactId>github-release-maven-plugin</artifactId>
        <version>[version]</version>
        <executions>
          <execution>
            <id>default-cli</id>
            <configuration>
              <owner>ragedunicorn</owner>
              <repository>github-release-test</repository>
              <server>github-oauth</server>
              <tagName>v0.0.1</tagName>
              <name>example-release</name>
              <targetCommitish>master</targetCommitish>
              <draft>true</draft>
              <body>release description overwritten by release notes</body>
              <releaseNotes>src/main/resources/release-notes-example.md</releaseNotes>
              <assets>
                <asset>src/main/resources/asset-plain-text-example.txt</asset>
                <asset>src/main/resources/asset-zip-example.zip</asset>
              </assets>
            </configuration>
          </execution>
        </executions>
      </plugin>
    </plugins>
  </build>
  [...]
</project>
```

| Parameter       | Required | Default Value                | Description                                                                                                                       |
|-----------------|----------|------------------------------|-----------------------------------------------------------------------------------------------------------------------------------|
| owner           | true     | <>                           | The name of the owner of the targeted repository                                                                                  |
| repository      | true     | <>                           | The name of the targeted repository                                                                                               |
| server          | false    | <>                           | References a server configuration in your .m2 settings.xml. This is the preferred way for using the GitHub Api token              |
| tagName         | true     | <>                           | The full name of the tag that should get used to create the release                                                               |
| name            | false    | [tagname]                    | The title of the release                                                                                                          |
| targetCommitish | false    | master                       | Determines where the tag is created from if the tag does not already exist. It is usually better to create a tag first            |
| body            | false    | [commit message last commit] | The body of the release. Essentially the release notes. Text is taken as is. For easier formatting use the releaseNotes parameter |
| releaseNotes    | false    | <>                           | Overwrite body parameter. A file containing the text for the release notes                                                        |
| assets          | false    | <>                           | A list of files that are being uploaded and attached to the release                                                               |
| draft         | false    | false                          | True for creating a draft, false for creating a published one                                                           |

### Execute Plugin

```
mvn github-release:github-release
```


## Setup Api Token

Before the plugin can be used a GitHub personal access token needs to be generated.

See GitHubs [documentation](https://help.github.com/articles/creating-a-personal-access-token-for-the-command-line/) for how to create such a token.

**Note:** It is recommended to limit the token to only the permissions that are absolutely needed.

The following permissions are required:

* repo  Full control of private repositories
  * repo:status  Access commit status
  * repo_deployment  Access deployment status
  * public_repo  Access public repositories
   
Once the Api token is generated it can be stored inside the maven `.m2/settings.xml`.
 
 ```xml
<server>
  <id>github-oauth</id>
  <passphrase>token</passphrase>
</server>
```

Make sure to use `passphrase` instead of `username`and `password` otherwise the plugin will not be able to recognize the token.

It is also possible to set the token with the parameter `token` directly inside the plugin configuration. This is however not recommended because those pom files are usually getting commited into source control and potentially leaking the token.

## Test

Basic tests can be executed with:

```
mvn test
```

Tests are kept basic because for most of the functionality the GitHub backend is required.

## Development

##### IntelliJ Run Configurations

The project contains IntelliJ run configurations that can be used for most tasks. Create a folder `runConfigurations` inside the `.idea` folder and copy over all run configurations. 


##### Build Project

github-release-maven-plugin

```
clean install
```

#### Create a Release

In maven `settings.xml` configure the ossrh account

```
<server>
  <id>ossrh</id>
  <username></username>
  <password></password>
</server>
```

#### Build and Release 

```
mvn clean deploy -P deploy
```

#### Move Staging to Release

If `autoReleaseAfterClose` is set to false in the `nexus-staging-maven-plugin` plugin an additional step is required to move the deployment from staging to release.

```
mvn nexus-staging:release
```

Or if the deployment didn't workout you can drop the artifact from the staging repository.

```
mvn nexus-staging:drop
```

**Note:** On MacOS the error `gpg: signing failed: Inappropriate ioctl for device` can be solved by setting the tty export variable for gpg.

```
export GPG_TTY=$(tty)
```

If you are using the IntelliJ console this might need to be set directly in that console.

##### Run Example

The example can be used for testing of the plugin during development. It requires some manual setup on GitHub before it can be run.

* Create repository
* Update repository owner
* Setup oauth token

github-release-maven-plugin/example

```
clean install
```

Executing the plugin from a different folder won't work without also fixing the path to the release notes and any additional assets configured.

**Note:** The example module is deliberately not included as default module otherwise it would execute each time the project is built.
Instead the module can be considered separate and independent. It is an example of how to use the plugin and it is helpful in testing the plugin during development.


##### Checkstyle

github-release-maven-plugin/plugin

```
mvn checkstyle:checkstyle
```

##### PMD

github-release-maven-plugin/plugin

```
mvn pmd:pmd
```

## Help

#### Delete a Release

A release can be deleted manually on the github.com website. Navigate to the release tab of the repository that you want to delete the release of.

`https://github.com/[owner]/[repository]/releases`

Click the title of the release that you want to delete. On the top right is a delete button.

#### Delete a Tag

A tag can be deleted manually or on the command line.

##### CLI delete

```
# delete tag locally
git tag -d [tagname]
# delete tag remotelly
git push origin :[tagname]
```

##### Manual delete

Navigate to the tags tab on github.com.

`https://github.com/[owner]/[repository]/tags`

Click the name of the tag. On the top right is a delete button.

**Note**: The tag will still be available locally on your machine. The next time you push the tag will show up again. If this is not desired you have to also delete the tag locally.

`git tag -d [tagname]`

## License

Copyright (c) 2020 Michael Wiesendanger

Permission is hereby granted, free of charge, to any person obtaining
a copy of this software and associated documentation files (the
"Software"), to deal in the Software without restriction, including
without limitation the rights to use, copy, modify, merge, publish,
distribute, sublicense, and/or sell copies of the Software, and to
permit persons to whom the Software is furnished to do so, subject to
the following conditions:

The above copyright notice and this permission notice shall be
included in all copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND,
EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF
MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND
NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE
LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION
OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION
WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
