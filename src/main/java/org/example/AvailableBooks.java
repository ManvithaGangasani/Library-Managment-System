package org.example;

import java.util.Map;

public class AvailableBooks {
    public void showAvailableBooks(Library library) {
        Map<String, Book> books = library.getBooks();
        System.out.println("Available books:");
        books.values().stream()
                .filter(Book::isAvailable)
                .forEach(book -> System.out.println(book.title() + " by " + book.author()));
    }
}
