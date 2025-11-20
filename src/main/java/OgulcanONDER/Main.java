package OgulcanONDER;

import OgulcanONDER.service.BookService;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        BookService bookService = new BookService();
        boolean running = true;
        while (running) {
            System.out.println("\n LIBRARY MANAGEMENT");
            System.out.println("1. Add Book");
            System.out.println("2. List Book");
            System.out.println("3. Delete Book");
            System.out.println("4. Borrow The Book");
            System.out.println("5. Return The Book");
            System.out.println("0. Exit");
            System.out.println("Selection: ");

            if (!scanner.hasNextInt()) {
                System.out.println("Please, enter a number! ");
                scanner.nextLine();
                continue;
            }
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1 -> {
                    System.out.println("Book Name:");
                    String bookName = scanner.nextLine();
                    System.out.println("Book Genre:");
                    String bookGenre = scanner.nextLine();
                    System.out.println("Page Number:");
                    int pageNumber = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("Author:");
                    String author = scanner.nextLine();
                    System.out.println("Borrowed (true/false):");
                    boolean borrowed = Boolean.parseBoolean(scanner.nextLine());
                    bookService.addBook(bookName, bookGenre, pageNumber, author, borrowed);

                }
                case 2 -> {
                    System.out.println(bookService.findAllBook());

                }
                case 3 -> {
                    System.out.println("Delete Book Id:");
                    int bookId = scanner.nextInt();
                    scanner.nextLine();
                    bookService.deleteBook(bookId);

                }
                case 4 -> {
                    System.out.println("----- Book List -----");
                    System.out.println(bookService.findAllBook());
                    System.out.println("Enter the book ID:");
                    int bookId = scanner.nextInt();
                    bookService.borrowedBook(bookId);

                }
                case 5 -> {
                    System.out.println("----- Book List -----");
                    System.out.println(bookService.findAllBook());
                    System.out.println("Return the book ID:");
                    int bookId = scanner.nextInt();
                    bookService.returnBook(bookId);

                }
                case 0 -> {
                    System.out.println("----- Program Exit -----");
                    running = false;
                }
            }
        }
        scanner.close();
        System.out.println("Program closed successfully");


    }
}