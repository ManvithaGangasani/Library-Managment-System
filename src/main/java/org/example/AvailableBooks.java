package org.example;
import java.util.Map;

public class AvailableBooks {
    // Method to display the titles and authors of all available books
    public void showAvailableBooks(Library library) {
        // Get the map of books from the library
        Map<String, Book> books = library.getBooks();
        // Filter the available books
        long availableBooksCount = books.values().stream()
                .filter(Book::isAvailable)
                .count();

        // If no books are available, print a message
        if (availableBooksCount == 0) {
            System.out.println("No books are currently available.");
        }
        else {
            System.out.println("Available books:");
            books.values().stream()
                    .filter(Book::isAvailable)
                    .forEach(book -> System.out.println("Title: " + book.title() + ", Author: " + book.author()));
        }
    }
}
