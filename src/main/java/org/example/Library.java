package org.example;

import java.util.HashMap;
import java.util.Map;

public class Library {

    // A map to store books, where the key is the ISBN (a unique identifier for books)
    private final Map<String, Book> books = new HashMap<>();

    // Getter method to retrieve the map of books
    public Map<String, Book> getBooks() {
        return books;
    }
}
