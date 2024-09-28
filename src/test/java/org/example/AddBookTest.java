package org.example;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class AddBookTest {

    @Test
    public void testAddBook() {
        Library library = new Library();
        AddBook addBook = new AddBook();

        // First book should be added successfully
        addBook.addBook(library, "1234", "Book One", "Author One", 2000);
        assertTrue(library.getBooks().containsKey("1234"));

        // Trying to add the same book again should not add it
        addBook.addBook(library, "1234", "Book One", "Author One", 2000);
        assertEquals(1, library.getBooks().size()); // Size should still be 1
    }
}
