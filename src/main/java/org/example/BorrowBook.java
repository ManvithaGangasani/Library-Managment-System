package org.example;

import java.util.Map;

public class BorrowBook {
    public void borrowBook(Library library, String isbn) {
        Map<String, Book> books = library.getBooks();
        if (!books.containsKey(isbn)) {
            System.out.println("Book with ISBN " + isbn + " does not exist.");
        } else if (!books.get(isbn).isAvailable()) {
            System.out.println("Book with ISBN " + isbn + " is currently not available.");
        } else {
            Book book = books.get(isbn);
            books.put(isbn, new Book(book.isbn(), book.title(), book.author(), book.publicationYear(), false));
            System.out.println("You have borrowed: " + book.title());
        }
    }
}
