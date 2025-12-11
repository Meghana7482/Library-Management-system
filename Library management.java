import java.util.ArrayList;
import java.util.Scanner;

class Book {
    String title;
    boolean isIssued;

    Book(String title) {
        this.title = title;
        this.isIssued = false;
    }
}

public class LibraryManagement {

    static ArrayList<Book> books = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        // Sample books
        books.add(new Book("Data Structures"));
        books.add(new Book("Operating Systems"));
        books.add(new Book("Java Programming"));

        int choice;
        do {
            System.out.println("\n--- Library Management System ---");
            System.out.println("1. List Books");
            System.out.println("2. Add Book");
            System.out.println("3. Issue Book");
            System.out.println("4. Return Book");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch(choice) {
                case 1: listBooks(); break;
                case 2: addBook(); break;
                case 3: issueBook(); break;
                case 4: returnBook(); break;
                case 5: System.out.println("Exiting system..."); break;
                default: System.out.println("Invalid choice. Try again!");
            }

        } while(choice != 5);
    }

    // List all books
    static void listBooks() {
        System.out.println("\nTitle - Status");
        for(Book b : books) {
            System.out.println(b.title + " - " + (b.isIssued ? "Issued" : "Available"));
        }
    }

    // Add a new book
    static void addBook() {
        System.out.print("Enter book title to add: ");
        String title = sc.nextLine();
        books.add(new Book(title));
        System.out.println("Book added successfully!");
    }

    // Issue a book
    static void issueBook() {
        System.out.print("Enter book title to issue: ");
        String title = sc.nextLine();
        for(Book b : books) {
            if(b.title.equalsIgnoreCase(title) && !b.isIssued) {
                b.isIssued = true;
                System.out.println("Book issued successfully!");
                return;
            }
        }
        System.out.println("Book not available or already issued.");
    }

    // Return a book
    static void returnBook() {
        System.out.print("Enter book title to return: ");
        String title = sc.nextLine();
        for(Book b : books) {
            if(b.title.equalsIgnoreCase(title) && b.isIssued) {
                b.isIssued = false;
                System.out.println("Book returned successfully!");
                return;
            }
        }
        System.out.println("Book not found or not issued.");
    }
                  }
