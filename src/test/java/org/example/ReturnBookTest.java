package org.example;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class ReturnBookTest {

    Library library = new Library();
    AddBook addBook = new AddBook();
    BorrowBook borrowBook = new BorrowBook();
    ReturnBook returnBook = new ReturnBook();

    @Test
    public void testReturnBorrowedBook() {
        // Add and borrow a book
        addBook.addBook(library, "1234", "Book One", "Author One", 2000);
        borrowBook.borrowBook(library, "1234");
        assertFalse(library.getBooks().get("1234").isAvailable());

        // Return the book
        returnBook.returnBook(library, "1234");
        assertTrue(library.getBooks().get("1234").isAvailable());
    }

    @Test
    public void testReturnBookThatDoesNotExist() {
        // Try to return a book that does not exist
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            returnBook.returnBook(library, "1235");
        });
        assertEquals("Book with ISBN 1235 does not exist to return.", exception.getMessage());
    }

    @Test
    public void testReturnAlreadyReturnedBook() {
        // Add and borrow a book
        addBook.addBook(library, "1234", "Book two", "Author One", 2000);
        borrowBook.borrowBook(library, "1234");
        returnBook.returnBook(library, "1234");

        // Try to return the same book again
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            returnBook.returnBook(library, "1234");
        });
        assertEquals("Book with ISBN 1234 is not borrowed to return.", exception.getMessage());
    }
}
