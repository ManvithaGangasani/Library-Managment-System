package org.example;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class BorrowBookTest {
    Library library = new Library();
    AddBook addBook = new AddBook();
    BorrowBook borrowBook = new BorrowBook();

    @Test
    public void testBorrowAvailableBook() {
        // Add a book to borrow
        addBook.addBook(library, "1234", "Book One", "Author One", 2000);
        borrowBook.borrowBook(library, "1234");

        // Test if the book is marked as not available after borrowing
        assertFalse(library.getBooks().get("1234").isAvailable());
    }

    @Test
    public void testBorrowBookThatDoesNotExist() {
        // Try to borrow a book that does not exist
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            borrowBook.borrowBook(library, "1235");
        });
        assertEquals("Book with ISBN 1235 does not exist you can't borrow.", exception.getMessage());
    }

    @Test
    public void testBorrowUnavailableBook() {
        // Add a book and borrow it
        addBook.addBook(library, "1234", "Book two", "Author two", 2000);
        borrowBook.borrowBook(library, "1234"); // Borrow it first

        // Try to borrow the same book again
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            borrowBook.borrowBook(library, "1234");
        });
        assertEquals("Book with ISBN 1234 is currently not available to borrow.", exception.getMessage());
    }
}
