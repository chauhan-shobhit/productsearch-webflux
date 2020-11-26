package com.shobhit.booksearchwebflux.repository;

import com.shobhit.booksearchwebflux.model.Book;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

public interface BookRepository extends ReactiveMongoRepository<Book, String> {

}
