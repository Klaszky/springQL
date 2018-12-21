package com.klaszky.springQL.repository;

import com.klaszky.springQL.model.Book;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface BookRepository extends MongoRepository<Book, String> {
    public Book findByTitle(String title);
}
