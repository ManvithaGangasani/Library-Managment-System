package org.example;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class BorrowBookTest {

    @Test
    public void testBorrowBook() {
        Library library = new Library();
        AddBook addBook = new AddBook();
        BorrowBook borrowBook = new BorrowBook();

        // Add a book to borrow
        addBook.addBook(library, "1234", "Book One", "Author One", 2000);
        borrowBook.borrowBook(library, "1234");

        // Try to borrow book which does not exist
        borrowBook.borrowBook(library, "1235");

        // Test if the book is marked as not available after borrowing
        assertFalse(library.getBooks().get("1234").isAvailable());

        // Try to borrow an unavailable book
        borrowBook.borrowBook(library, "1234"); // Should not allow borrowing

    }
}
