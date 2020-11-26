package com.shobhit.booksearchwebflux.model.exception;

public class BookAlreadyExistException extends RuntimeException {

  private static final long serialVersionUID = 1L;
  private String message;

  public BookAlreadyExistException(String message) {
    super(message);
    this.message = message;
  }

  public BookAlreadyExistException() {
    super();
  }

  public String getFieldName() {
    return message;
  }

  public void setFieldName(String message) {
    this.message = message;
  }

}
