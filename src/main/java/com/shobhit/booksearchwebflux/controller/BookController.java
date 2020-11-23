package com.shobhit.booksearchwebflux.controller;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import com.shobhit.booksearchwebflux.model.Book;

import org.springframework.http.ResponseEntity;

public interface BookController {

  public Mono<Book> publishBook(Book book);

  public Mono<ResponseEntity<Book>> getBookById(String Id);

  public Flux<ResponseEntity<Book>> getAllBooks();

  public Mono<ResponseEntity<Book>> updateBook(Book book);

  public Mono<ResponseEntity<Void>> deleteBookById(String Id);

  public Flux<ResponseEntity<Void>> deleteAllBooks();

}
