package com.klaszky.springQL.resolver;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.klaszky.springQL.model.Author;
import com.klaszky.springQL.model.Book;
import com.klaszky.springQL.repository.AuthorRepository;
import com.klaszky.springQL.repository.BookRepository;

public class Query implements GraphQLQueryResolver {
    private BookRepository bookRepository;
    private AuthorRepository authorRepository;

    public Query(AuthorRepository authorRepository, BookRepository bookRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
    }

    public Iterable<Book> findAllBooks() {
        return bookRepository.findAll();
    }

    public Iterable<Author> findAllAuthors() {
        return authorRepository.findAll();
    }

    public long countBooks() {
        return bookRepository.count();
    }

    public long countAuthors() {
        return authorRepository.count();
    }
}
