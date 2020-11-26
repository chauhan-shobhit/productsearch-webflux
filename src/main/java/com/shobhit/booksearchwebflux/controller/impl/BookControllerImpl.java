package com.shobhit.booksearchwebflux.controller.impl;

import com.shobhit.booksearchwebflux.controller.BookController;
import com.shobhit.booksearchwebflux.model.Book;
import com.shobhit.booksearchwebflux.repository.BookRepository;
import com.shobhit.booksearchwebflux.service.BookService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestBody;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/books")
public class BookControllerImpl implements BookController {

  @Autowired
  private BookService bookService;

  @Autowired
  private BookRepository repository;

  private static final org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(BookService.class);

  @Override
  @PostMapping("/publish")
  public Mono<Book> publishBook(@RequestBody Book book) {

    return bookService.publishBook(book);
  }

  @Override
  @GetMapping("/{Id}")
  public Mono<ResponseEntity<Book>> getBookById(@PathVariable String Id) {

    return bookService.getBookById(Id).map(book -> ResponseEntity.ok(book))
        .defaultIfEmpty(ResponseEntity.notFound().build());

  }

  @Override
  @GetMapping("/getAll")
  public Flux<Book> getAllBooks() {

    return bookService.getAllBooks();
  }

  @Override
  @PutMapping("/{Id}")
  public Mono<Book> updateBook(@PathVariable(value = "Id") String Id, @RequestBody Book book) {

    return bookService.updateBook(book);

  }

  @Override
  @DeleteMapping("/{Id}")
  public Mono<Void> deleteBookById(@PathVariable String Id) {

    return bookService.deleteBookById(Id);

  }

  @Override
  @DeleteMapping("/deleteAll")
  public Mono<Void> deleteAllBooks() {

    return bookService.deleteAllBooks();
  }

}
