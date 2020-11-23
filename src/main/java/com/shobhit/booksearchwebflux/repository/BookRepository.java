package com.shobhit.booksearchwebflux.repository;

import com.shobhit.booksearchwebflux.model.Book;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface BookRepository extends ReactiveMongoRepository<Book, String> {

}
