package org.example;

import java.util.Map;

public class ReturnBook {
    // Method to return a book to the library based on its ISBN
    public void returnBook(Library library, String isbn) {
        // Retrieve the map of books from the library
        Map<String, Book> books = library.getBooks();

        // Check if the book with the given ISBN exists in the library
        if (!books.containsKey(isbn)) {
            throw new IllegalArgumentException("Book with ISBN " + isbn + " does not exist to return.");
        }

        // Check if the book is already available (i.e., not borrowed)
        if (books.get(isbn).isAvailable()) {
            throw new IllegalArgumentException("Book with ISBN " + isbn + " is not borrowed to return.");
        }

        // Create a new Book object with the same attributes, but mark it as available (true)
        Book book = books.get(isbn);
        books.put(isbn, new Book(book.isbn(), book.title(), book.author(), book.publicationYear(), true));
        System.out.println("Book returned: " + book.title());
    }
}

