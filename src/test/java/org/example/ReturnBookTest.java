package org.example;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class ReturnBookTest {

    @Test
    public void testReturnBook() {
        Library library = new Library();
        AddBook addBook = new AddBook();
        BorrowBook borrowBook = new BorrowBook();
        ReturnBook returnBook = new ReturnBook();

        // Add and borrow a book
        addBook.addBook(library, "1234", "Book One", "Author One", 2000);
        borrowBook.borrowBook(library, "1234");
        assertFalse(library.getBooks().get("1234").isAvailable());

        // Return the book
        returnBook.returnBook(library, "1234");
        assertTrue(library.getBooks().get("1234").isAvailable());

        // Return the book which does not found
        returnBook.returnBook(library, "1235");

        // Try to return a book that is already returned (not borrowed)
        returnBook.returnBook(library, "1234");
        assertTrue(library.getBooks().get("1234").isAvailable());
    }
}
