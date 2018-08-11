package com.ragedunicorn.tools.maven.log;

public class DefaultLog implements GitHubReleaseLogger {

  private boolean debug = false;

  public DefaultLog() {
    // no op
  }

  public DefaultLog(boolean debug) {
    this.debug = debug;
  }

  /**
   * Log a debug message.
   *
   * @param content The content to log
   */
  public void debug(String content) {
    if (this.debug) {
      System.out.println("[DEBUG] " + content);
    }
  }

  /**
   * Log a debug message.
   *
   * @param content The content to log
   * @param error   An error object
   */
  public void debug(String content, Throwable error) {
    if (this.debug) {
      System.out.println("[DEBUG] " + content);
      error.printStackTrace();
    }
  }

  /**
   * Log a debug message.
   *
   * @param error An error object
   */
  public void debug(Throwable error) {
    if (this.debug) {
      error.printStackTrace();
    }
  }

  /**
   * Log a info message.
   *
   * @param content The content to log
   */
  public void info(String content) {
    System.out.println("[INFO] " + content);
  }

  /**
   * Log a info message.
   *
   * @param content The content to log
   * @param error   An error object
   */
  public void info(String content, Throwable error) {
    System.out.println("[INFO] " + content);
    error.printStackTrace();
  }

  /**
   * Log a info message.
   *
   * @param error An error object
   */
  public void info(Throwable error) {
    error.printStackTrace();
  }

  /**
   * Log a warn message.
   *
   * @param content The content to log
   */
  public void warn(String content) {
    System.out.println("[WARNING] " + content);
  }

  /**
   * Log a warn message.
   *
   * @param content The content to log
   * @param error   An error object
   */
  public void warn(String content, Throwable error) {
    System.out.println("[WARNING] " + content);
    error.printStackTrace();
  }

  /**
   * Log a warn message.
   *
   * @param error An error object
   */
  public void warn(Throwable error) {
    error.printStackTrace();
  }

  /**
   * Log a error message.
   *
   * @param content The content to log
   */
  public void error(String content) {
    System.out.println("[ERROR] " + content);
  }

  /**
   * Log a error message.
   *
   * @param content The content to log
   * @param error   An error object
   */
  public void error(String content, Throwable error) {
    System.out.println("[ERROR] " + content);
    error.printStackTrace();
  }

  /**
   * Log a error message.
   *
   * @param error An error object
   */
  public void error(Throwable error) {
    error.printStackTrace();
  }
}
