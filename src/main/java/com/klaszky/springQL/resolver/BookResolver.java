package com.klaszky.springQL.resolver;

import com.coxautodev.graphql.tools.GraphQLResolver;
import com.klaszky.springQL.model.Author;
import com.klaszky.springQL.model.Book;
import com.klaszky.springQL.repository.AuthorRepository;

public class BookResolver implements GraphQLResolver<Book> {
    private AuthorRepository authorRepository;

    public BookResolver(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    public Author getAuthor(Book book){
        return authorRepository.findByLastNameAndFirstName(book.getAuthor().getFirstName(), book.getAuthor().getLastName());
    }
}
