package com.shobhit.booksearchwebflux.controller.impl;

import com.shobhit.booksearchwebflux.controller.BookController;
import com.shobhit.booksearchwebflux.model.Book;
import com.shobhit.booksearchwebflux.service.BookService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.parameters.RequestBody;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/book")
public class BookControllerImpl implements BookController {

  @Autowired
  private BookService bookService;

  @Override
  @PostMapping
  public Mono<Book> publishBook(@RequestBody Book book) {
    return bookService.publishBook(book);
  }

  @Override
  @GetMapping("{Id}")
  public Mono<ResponseEntity<Book>> getBookById(@PathVariable String Id) {

    return bookService.getBookById(Id).map(book -> ResponseEntity.ok(book))
        .defaultIfEmpty(ResponseEntity.notFound().build());

  }

  @Override
  @GetMapping
  public Flux<ResponseEntity<Book>> getAllBooks() {

    return bookService.getAllBooks();
  }

  @Override
  @PutMapping("Id")
  public Mono<ResponseEntity<Book>> updateBook(@PathVariable(value = "id") String Id, @RequestBody Book book) {

    return bookService.updateBook(book);
    ;
  }

  @Override
  public Mono<ResponseEntity<Void>> deleteBookById(@PathVariable String Id) {

    return bookService.deleteBookById(Id);

  }

  @Override
  public Mono<Void> deleteAllBooks() {

    return bookService.deleteAllBooks();
  }

  @Override
  public Mono<ResponseEntity<Book>> updateBook(Book book) {

    return null;
  }

}
