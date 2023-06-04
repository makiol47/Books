package org.example;

import java.util.List;

public interface BookInterface {
    void addBook(Book book);

    void addBook(java.awt.print.Book book);

    List<Book> getBooks();
    List<Book> sortBooksByTitle();
    List<Book> sortBooksByPublicationDate();
}
