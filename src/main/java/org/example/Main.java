package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Library library = new Library();
        AddBook addBook = new AddBook();
        BorrowBook borrowBook = new BorrowBook();
        ReturnBook returnBook = new ReturnBook();
        AvailableBooks availableBooks = new AvailableBooks();

        Scanner scanner = new Scanner(System.in);
        boolean addingBooks = true;

        // Add multiple books
        while (addingBooks) {
            String isbn = "";
            String title = "";
            String author = "";
            int publicationYear = 0;

            // Prompt for ISBN and validate
            while (true) {
                System.out.println("Enter the ISBN:");
                isbn = scanner.nextLine().trim();
                if (isbn.isEmpty()) {
                    System.out.println("ISBN cannot be empty. Please try again.");
                    continue; // Ask for ISBN again
                }
                break; // Break if valid ISBN is provided
            }

            // Prompt for title and validate
            while (true) {
                System.out.println("Enter the title:");
                title = scanner.nextLine().trim();
                if (title.isEmpty()) {
                    System.out.println("Title cannot be empty. Please try again.");
                    continue; // Ask for title again
                }
                break; // Break if valid title is provided
            }

            // Prompt for author and validate
            while (true) {
                System.out.println("Enter the author:");
                author = scanner.nextLine().trim();
                if (author.isEmpty()) {
                    System.out.println("Author cannot be empty. Please try again.");
                    continue; // Ask for author again
                }
                break; // Break if valid author is provided
            }

            // Prompt for publication year and validate
            while (true) {
                System.out.println("Enter the publication year (greater than 0):");
                String input = scanner.nextLine().trim(); // Read input as string

                if (input.isEmpty()) {
                    System.out.println("Publication year cannot be empty. Please try again.");
                    continue; // Ask for publication year again
                }

                try {
                    publicationYear = Integer.parseInt(input); // Convert to integer
                    if (publicationYear <= 0) {
                        System.out.println("Publication year must be greater than 0. Please try again.");
                        continue; // Check if the year is greater than 0
                    }
                    break; // Break if valid input is provided
                } catch (NumberFormatException e) {
                    System.out.println("Please enter a valid integer for the publication year.");
                }
            }

            // Add the book to the library
            addBook.addBook(library, isbn, title, author, publicationYear);

            System.out.println("Do you want to add another book? (yes/no):");
            String response = scanner.nextLine();
            if (response.equalsIgnoreCase("no")) {
                addingBooks = false;
            }
        }

        // Borrow a book
        System.out.println("Enter the ISBN of the book to borrow:");
        String borrowIsbn = scanner.nextLine();
        try {
            borrowBook.borrowBook(library, borrowIsbn);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage()); // Display the error message
        }

        availableBooks.showAvailableBooks(library);

        // Return a book
        System.out.println("Enter the ISBN of the book to return:");
        String returnIsbn = scanner.nextLine();
        try {
            returnBook.returnBook(library, returnIsbn);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage()); // Display the error message
        }

        availableBooks.showAvailableBooks(library);

        scanner.close();
    }
}
