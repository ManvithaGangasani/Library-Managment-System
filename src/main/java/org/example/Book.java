package org.example;

// The 'Book' record is a simple, immutable data structure to store information about a book
public record Book(String isbn, String title, String author, int publicationYear, boolean isAvailable) {}
