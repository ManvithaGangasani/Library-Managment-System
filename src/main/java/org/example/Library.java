package org.example;

import java.util.HashMap;
import java.util.Map;

public class Library {
    private final Map<String, Book> books = new HashMap<>();

    public Map<String, Book> getBooks() {
        return books;
    }
}
