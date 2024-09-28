package org.example;
import java.util.Map;

public class BorrowBook {
    public void borrowBook(Library library, String isbn) {
        // Accessing the books collection from the library
        Map<String, Book> books = library.getBooks();

        // Check if the book exists in the library
        if (!books.containsKey(isbn)) {
            throw new IllegalArgumentException("Book with ISBN " + isbn + " does not exist you can't borrow.");
        }

        // Check if the book is available for borrowing
        if (!books.get(isbn).isAvailable()) {
            throw new IllegalArgumentException("Book with ISBN " + isbn + " is currently not available to borrow.");
        }

        // Mark the book as borrowed (not available anymore)
        Book book = books.get(isbn);
        books.put(isbn, new Book(book.isbn(), book.title(), book.author(), book.publicationYear(), false));
        System.out.println("You have borrowed: " + book.title());
    }
}
