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
            System.out.println("Enter the ISBN:");
            String isbn = scanner.nextLine();
            System.out.println("Enter the title:");
            String title = scanner.nextLine();
            System.out.println("Enter the author:");
            String author = scanner.nextLine();
            System.out.println("Enter the publication year:");
            int publicationYear = scanner.nextInt();
            scanner.nextLine(); // Consume the newline

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
        borrowBook.borrowBook(library, borrowIsbn);

        availableBooks.showAvailableBooks(library);

        // Return a book
        System.out.println("Enter the ISBN of the book to return:");
        String returnIsbn = scanner.nextLine();
        returnBook.returnBook(library, returnIsbn);

        availableBooks.showAvailableBooks(library);

        scanner.close();
    }
}
