package com.klaszky.springQL.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Book")
@NoArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class Book {
    @Id
    private String id;

    private String title;

    private String isbn;

    private int pageCount;

    private Author author;

    public Book(String title, String isbn, int pageCount, Author author) {

    }
}
