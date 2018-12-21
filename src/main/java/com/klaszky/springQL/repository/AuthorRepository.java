package com.klaszky.springQL.repository;

import com.klaszky.springQL.model.Author;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface AuthorRepository extends MongoRepository<Author, String> {
    public Author findByLastNameAndFirstName(String firstName, String lastName);
}
