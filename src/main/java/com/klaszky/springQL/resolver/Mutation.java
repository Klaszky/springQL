package com.klaszky.springQL.resolver;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.klaszky.springQL.exception.BookNotFoundException;
import com.klaszky.springQL.model.Author;
import com.klaszky.springQL.model.Book;
import com.klaszky.springQL.repository.AuthorRepository;
import com.klaszky.springQL.repository.BookRepository;

public class Mutation implements GraphQLMutationResolver {
    private BookRepository bookRepository;
    private AuthorRepository authorRepository;

    public Mutation(AuthorRepository authorRepository, BookRepository bookRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
    }

    public Author newAuthor(String firstName, String lastName) {
        Author author = new Author();
        author.setFirstName(firstName);
        author.setLastName(lastName);

        authorRepository.save(author);

        return author;
    }

    public Book newBook(String title, String isbn, Integer pageCount, String authorFirstName, String authorLastName) {
        Book book = new Book();
        book.setAuthor(new Author(authorFirstName, authorLastName));
        book.setTitle(title);
        book.setIsbn(isbn);
        book.setPageCount(pageCount != null ? pageCount : 0);

        bookRepository.save(book);

        return book;
    }

    public boolean deleteBook(String title){
        Book book = bookRepository.findByTitle(title);
        bookRepository.delete(book);
        return true;
    }

    public Book updateBookPageCount(Integer pageCount, String title){
        Book book = bookRepository.findByTitle(title);
        if(book == null) {
            throw new BookNotFoundException("The book to be updated was not found", title);
        }
        book.setPageCount(pageCount);

        bookRepository.save(book);

        return book;
    }
}
