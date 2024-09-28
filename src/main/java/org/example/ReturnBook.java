package org.example;

import java.util.Map;

public class ReturnBook {
    public void returnBook(Library library, String isbn) {
        Map<String, Book> books = library.getBooks();
        if (!books.containsKey(isbn)) {
            System.out.println("Book with ISBN " + isbn + " not found.");
        } else if (books.get(isbn).isAvailable()) {
            System.out.println("Book is not borrowed.");
        } else {
            Book book = books.get(isbn);
            books.put(isbn, new Book(book.isbn(), book.title(), book.author(), book.publicationYear(), true));
            System.out.println("Book returned: " + book.title());
        }
    }
}

