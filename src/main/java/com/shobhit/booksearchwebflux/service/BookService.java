package com.shobhit.booksearchwebflux.service;

import com.shobhit.booksearchwebflux.model.Book;
import com.shobhit.booksearchwebflux.repository.BookRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class BookService {

  @Autowired
  private BookRepository bookRepository;

  public Mono<Book> publishBook(Book book) {
    return bookRepository.save(book);

  }

  public Mono<Book> getBookById(String id) {
    return bookRepository.findById(id);
  }

  public Flux<Book> getAllBooks() {
    return bookRepository.findAll();
  }

  public Mono<Book> updateBook(Book book) {
    return bookRepository.updateBook(book);
  }

  public Mono<Void> deleteBookById(String id) {
    return bookRepository.deleteById(id);
  }

  public Mono<Void> deleteAllBooks() {
    return bookRepository.deleteAll();
  }

}
