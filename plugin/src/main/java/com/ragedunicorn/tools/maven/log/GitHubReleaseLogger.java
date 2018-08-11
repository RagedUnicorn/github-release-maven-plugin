package com.ragedunicorn.tools.maven.log;

public interface GitHubReleaseLogger {
  void debug(String content);

  void debug(String content, Throwable error);

  void debug(Throwable error);

  void info(String content);

  void info(String content, Throwable error);

  void info(Throwable error);

  void warn(String content);

  void warn(String content, Throwable error);

  void warn(Throwable error);

  void error(String content);

  void error(String content, Throwable error);

  void error(Throwable error);
}
