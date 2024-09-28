package org.example;
import java.util.Map;

public class AddBook {
    public void addBook(Library library, String isbn, String title, String author, int publicationYear) {

        // Validate ISBN
        if(isbn==null||isbn.trim().isEmpty()){
            throw new IllegalArgumentException("ISBN cannot be empty or null.");
        }

        // Validate title
        else if(title==null||title.trim().isEmpty()){
            throw new IllegalArgumentException("Title cannot be empty or null.");
        }
        //Validate author
        else if(author==null||author.trim().isEmpty()){
            throw new IllegalArgumentException("Author cannot be empty or null.");
        }

        //Validate publication year
        if(publicationYear<0){
            throw new IllegalArgumentException("Publication year cannot be negative.");
        }

        // Get the current list of books from the library
        Map<String, Book> books = library.getBooks();

        // Check if the book with the given ISBN already exists
        if (books.containsKey(isbn)) {
            System.out.println("Book with ISBN " + isbn + " already exists.");
        }
        else {
            // Add the book to the library
            books.put(isbn, new Book(isbn, title, author, publicationYear, true));
            System.out.println("Book added: " + title);
        }
    }
}
