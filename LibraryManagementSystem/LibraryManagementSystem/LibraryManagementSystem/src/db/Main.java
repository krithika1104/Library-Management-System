package db;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n==== Library Management System ====");
            System.out.println("1. Add Book");
            System.out.println("2. Issue Book");
            System.out.println("3. Return Book");
            System.out.println("4. Delete Book");
            System.out.println("5. Exit");

            System.out.print("Enter choice: ");
            int choice = sc.nextInt();
            sc.nextLine(); // buffer clear

            switch (choice) {

                case 1:
                    System.out.print("Enter Book Title: ");
                    String title = sc.nextLine();
                    System.out.print("Enter Author Name: ");
                    String author = sc.nextLine();
                    AddBook.addBook(title, author);
                    break;

                case 2:
                    System.out.print("Enter Book ID to Issue: ");
                    int issueId = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Issued To: ");
                    String name = sc.nextLine();
                    IssueBook.issueBook(issueId, name);
                    break;

                case 3:
                    System.out.print("Enter Book ID to Return: ");
                    int returnId = sc.nextInt();
                    ReturnBook.returnBook(returnId);
                    break;

                case 4:
                    System.out.print("Enter Book ID to Delete: ");
                    int deleteId = sc.nextInt();
                    DeleteBook.deleteBook(deleteId);
                    break;

                case 5:
                    System.out.println("Exiting...");
                    System.exit(0);

                default:
                    System.out.println("Invalid choice!");
            }
        }
    }
}

