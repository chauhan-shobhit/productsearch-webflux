package com.shobhit.booksearchwebflux.model.exception;

public class BookNotFoundException extends RuntimeException {

  private static final long serialVersionUID = 1L;
  private String message;

  public BookNotFoundException(String message) {
    super(message);
    this.message = message;
  }

  public BookNotFoundException() {
    super();
  }

  public String getFieldName() {
    return message;
  }

  public void setFieldName(String message) {
    this.message = message;
  }
}
