package Main;
import java.util.Scanner;
import com.gvg.Library.Library;

import LibraryException.LibraryException;
import libraryassignment.Book;

public class Main {
    public static void main(String[] args) {
        Library library = new Library();
        Scanner scanner = new Scanner(System.in);

        // Add some sample books
        library.addBook(new Book("111", "Java Basics", "John Doe"));
        library.addBook(new Book("222", "Python 101", "Jane Smith"));

        while (true) {
            System.out.println("\n--- Library Menu ---");
            System.out.println("1. Show Books");
            System.out.println("2. Borrow Book");
            System.out.println("3. Return Book");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            try {
                switch (choice) {
                    case 1:
                        library.showBooks();
                        break;
                    case 2:
                        System.out.print("Enter ISBN to borrow: ");
                        String borrowIsbn = scanner.nextLine();
                        library.borrowBook(borrowIsbn);
                        System.out.println("Book borrowed successfully!");
                        break;
                    case 3:
                        System.out.print("Enter ISBN to return: ");
                        String returnIsbn = scanner.nextLine();
                        library.returnBook(returnIsbn);
                        System.out.println("Book returned successfully!");
                        break;
                    case 4:
                        System.out.println("Exiting...");
                        return;
                    default:
                        System.out.println("Invalid choice.");
                }
            } catch (LibraryException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }
}
