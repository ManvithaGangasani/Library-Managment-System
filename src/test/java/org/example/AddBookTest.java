package org.example;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class AddBookTest {

    @Test
    public void testAddBook() {
        Library library = new Library();
        AddBook addBook = new AddBook();

        // First book should be added successfully
        addBook.addBook(library, "1234", "clean code", "Author One", 2000);
        assertTrue(library.getBooks().containsKey("1234"));

        // Trying to add the same book again should not add it
        addBook.addBook(library, "1234", "clean code", "Author One", 2000);
        assertEquals(1, library.getBooks().size()); // Size should still be 1
    }

    @Test
    public void testAddBookWithEmptyOrNullValues() {
        Library library = new Library();
        AddBook addBook = new AddBook();

        // Trying to add a book with an empty title should throw an exception
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            addBook.addBook(library, "1235", "", "Author Two", 2005);
        });
        assertEquals("Title cannot be empty or null.", exception.getMessage()); // Adjusted expected message

        // Trying to add a book with an empty author should throw an exception
        exception = assertThrows(IllegalArgumentException.class, () -> {
            addBook.addBook(library, "1236", "Book Two", null, 2005);
        });
        assertEquals("Author cannot be empty or null.", exception.getMessage()); // Adjusted expected message

        // Trying to add a book with an empty ISBN should throw an exception
        exception = assertThrows(IllegalArgumentException.class, () -> {
            addBook.addBook(library, "", "Book Three", "Author Three", 2005);
        });
        assertEquals("ISBN cannot be empty or null.", exception.getMessage()); // Adjusted expected message
    }
}