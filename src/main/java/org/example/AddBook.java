package org.example;

import java.util.Map;

public class AddBook {
    public void addBook(Library library, String isbn, String title, String author, int publicationYear) {
        Map<String, Book> books = library.getBooks();
        if (books.containsKey(isbn)) {
            System.out.println("Book with ISBN " + isbn + " already exists.");
        } else {
            books.put(isbn, new Book(isbn, title, author, publicationYear, true));
            System.out.println("Book added: " + title);
        }
    }
}
