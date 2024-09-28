package org.example;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class AvailableBooksTest {

    @Test
    public void testShowAvailableBooks() {
        Library library = new Library();
        AddBook addBook = new AddBook();
        BorrowBook borrowBook = new BorrowBook();
        AvailableBooks availableBooks = new AvailableBooks();

        // Add two books
        addBook.addBook(library, "1234", "Book One", "Author One", 2000);
        addBook.addBook(library, "5678", "Book Two", "Author Two", 2010);

        // Borrow one book
        borrowBook.borrowBook(library, "1234");
        assertFalse(library.getBooks().get("1234").isAvailable());
        availableBooks.showAvailableBooks(library);


    }
}




