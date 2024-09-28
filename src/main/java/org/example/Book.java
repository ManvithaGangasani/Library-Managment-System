package org.example;

public record Book(String isbn, String title, String author, int publicationYear, boolean isAvailable) {}
