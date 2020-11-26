package com.shobhit.booksearchwebflux.controller;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import com.shobhit.booksearchwebflux.model.Book;

import org.springframework.http.ResponseEntity;

public interface BookController {

  public Mono<Book> publishBook(Book book);

  public Mono<ResponseEntity<Book>> getBookById(String Id);

  public Flux<Book> getAllBooks();

  public Mono<Book> updateBook(String Id, Book book);

  public Mono<Void> deleteBookById(String Id);

  public Mono<Void> deleteAllBooks();

}
