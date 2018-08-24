/*
 * Copyright (c) 2018 Michael Wiesendanger
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
