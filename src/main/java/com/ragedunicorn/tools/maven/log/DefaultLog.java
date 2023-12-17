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

package com.ragedunicorn.tools.maven.log;

@SuppressWarnings("PMD")
public class DefaultLog implements GitHubReleaseLogger {
  /**
   * Define default logLevel.
   * logLevels:
   * 1 - Error
   * 2 - Info
   * 3 - Warning
   * 4 - Debug
   */
  private int logLevel = 3;

  public static final int LOG_LEVEL_ERROR = 1;
  public static final int LOG_LEVEL_WARNING = 2;
  public static final int LOG_LEVEL_INFO = 3;
  public static final int LOG_LEVEL_DEBUG = 4;

  public DefaultLog() {
    // no op
  }

  public DefaultLog(int logLevel) {
    this.logLevel = logLevel;
  }

  /**
   * Log a debug message.
   *
   * @param content The content to log
   */
  public void debug(String content) {
    if (this.logLevel >= LOG_LEVEL_DEBUG) {
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
    if (this.logLevel >= LOG_LEVEL_DEBUG) {
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
    if (this.logLevel >= LOG_LEVEL_DEBUG) {
      error.printStackTrace();
    }
  }

  /**
   * Returns whether the debug logLevel is enabled or not.
   *
   * @return whether the logLevel is enabled or not
   */
  public boolean isDebugEnabled() {
    return this.logLevel >= LOG_LEVEL_DEBUG;
  }

  /**
   * Log a info message.
   *
   * @param content The content to log
   */
  public void info(String content) {
    if (this.logLevel >= LOG_LEVEL_INFO) {
      System.out.println("[INFO] " + content);
    }
  }

  /**
   * Log a info message.
   *
   * @param content The content to log
   * @param error   An error object
   */
  public void info(String content, Throwable error) {
    if (this.logLevel >= LOG_LEVEL_INFO) {
      System.out.println("[INFO] " + content);
      error.printStackTrace();
    }
  }

  /**
   * Log a info message.
   *
   * @param error An error object
   */
  public void info(Throwable error) {
    if (this.logLevel >= LOG_LEVEL_INFO) {
      error.printStackTrace();
    }
  }

  /**
   * Returns whether the info logLevel is enabled or not.
   *
   * @return whether the logLevel is enabled or not
   */
  public boolean isInfoEnabled() {
    return this.logLevel >= LOG_LEVEL_INFO;
  }

  /**
   * Log a warn message.
   *
   * @param content The content to log
   */
  public void warn(String content) {
    if (this.logLevel >= LOG_LEVEL_WARNING) {
      System.out.println("[WARNING] " + content);
    }
  }

  /**
   * Log a warn message.
   *
   * @param content The content to log
   * @param error   An error object
   */
  public void warn(String content, Throwable error) {
    if (this.logLevel >= LOG_LEVEL_WARNING) {
      System.out.println("[WARNING] " + content);
      error.printStackTrace();
    }
  }

  /**
   * Log a warn message.
   *
   * @param error An error object
   */
  public void warn(Throwable error) {
    if (this.logLevel >= LOG_LEVEL_WARNING) {
      error.printStackTrace();
    }
  }

  /**
   * Returns whether the warn logLevel is enabled or not.
   *
   * @return whether the logLevel is enabled or not
   */
  public boolean isWarnEnabled() {
    return this.logLevel >= LOG_LEVEL_WARNING;
  }

  /**
   * Log a error message.
   *
   * @param content The content to log
   */
  public void error(String content) {
    if (this.logLevel >= LOG_LEVEL_ERROR) {
      System.out.println("[ERROR] " + content);
    }
  }

  /**
   * Log a error message.
   *
   * @param content The content to log
   * @param error   An error object
   */
  public void error(String content, Throwable error) {
    if (this.logLevel >= LOG_LEVEL_ERROR) {
      System.out.println("[ERROR] " + content);
      error.printStackTrace();
    }
  }

  /**
   * Log a error message.
   *
   * @param error An error object
   */
  public void error(Throwable error) {
    if (this.logLevel >= LOG_LEVEL_ERROR) {
      error.printStackTrace();
    }
  }

  /**
   * Returns whether the error logLevel is enabled or not.
   *
   * @return whether the logLevel is enabled or not
   */
  public boolean isErrorEnabled() {
    return this.logLevel >= LOG_LEVEL_ERROR;
  }
}
