package com.shobhit.booksearchwebflux.advice;

import com.shobhit.booksearchwebflux.model.CustomErrorResponse;
import com.shobhit.booksearchwebflux.model.exception.BookAlreadyExistException;
import com.shobhit.booksearchwebflux.model.exception.BookNotFoundException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class APIExceptionHandlerAdvice {

  @ExceptionHandler({ BookAlreadyExistException.class })
  public ResponseEntity<CustomErrorResponse> handleProductAlreadyExistException(Throwable e) {
    CustomErrorResponse response = new CustomErrorResponse("100", "Book Already Exists");
    return new ResponseEntity<>(response, HttpStatus.CONFLICT);
  }

  @ExceptionHandler({ BookNotFoundException.class })
  public ResponseEntity<CustomErrorResponse> handleProductNotFoundException(Throwable e) {
    CustomErrorResponse response = new CustomErrorResponse("404", "Book Not Found");
    return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
  }

}
