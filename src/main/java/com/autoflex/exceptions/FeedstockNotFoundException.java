package com.autoflex.exceptions;

public class FeedstockNotFoundException extends RuntimeException {
  public FeedstockNotFoundException(String message) {
    super(message);
  }
}
