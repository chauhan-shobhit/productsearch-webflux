package com.shobhit.booksearchwebflux.service;

import com.shobhit.booksearchwebflux.model.Book;
import com.shobhit.booksearchwebflux.repository.BookRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Slf4j
@Service
public class BookService {

  @Autowired
  private BookRepository bookRepository;
  private static final org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(BookService.class);

  public Mono<Book> publishBook(Book book) {

    log.info("Book details  {}", book.getTitle());

    return bookRepository.save(book);

  }

  public Mono<Book> getBookById(String id) {
    return bookRepository.findById(id);
  }

  public Flux<Book> getAllBooks() {

    return bookRepository.findAll();
  }

  public Mono<Book> updateBook(Book book) {
    return bookRepository.save(book);
  }

  public Mono<Void> deleteBookById(String id) {
    return bookRepository.deleteById(id);
  }

  public Mono<Void> deleteAllBooks() {
    return bookRepository.deleteAll();
  }

}
