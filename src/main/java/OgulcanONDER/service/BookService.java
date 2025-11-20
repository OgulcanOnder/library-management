package OgulcanONDER.service;

import OgulcanONDER.model.Book;
import OgulcanONDER.repository.BookRepository;

import java.io.IOException;
import java.util.Comparator;
import java.util.List;

public class BookService {
    private final BookRepository bookRepository = new BookRepository();


    public void addBook(String bookName, String bookGenre, int pageNumber, String author, boolean borrowed) {
        List<Book> books = bookRepository.findAll();
        int newId = books.stream()
                .map(Book::getId)
                .max(Comparator.naturalOrder())
                .orElse(0) + 1;

        Book book = new Book(newId, bookName, bookGenre, pageNumber, author, borrowed);
        books.add(book);
        bookRepository.saveBook(books);

        System.out.println("Kitap Eklendi: " + book);
    }

    public String findAllBook() {
        List<Book> bookList = bookRepository.findAll();
        if (bookList == null) {
            System.out.println("Book is not found");
        }
        String response = bookList.toString().replaceAll(",", "")
                .replace('[', ' ')
                .replace(']', ' ');
        return response;

    }

    public String findByIdBook(int id) {
        try {
            Book book = bookRepository.findById(id);
            if (book == null) {
                return "Book with ID " + id + " not found";
            }
            String response = book.toString();
            return response;
        } catch (IOException e) {
            return "";

        }

    }

    public void deleteBook(int id) {
        List<Book> bookList = bookRepository.findAll();
        boolean removed = bookList.removeIf(book -> book.getId() == id);
        if (removed) {
            System.out.println(id + " Book Deleted");
            bookRepository.saveBook(bookList);
        } else {
            System.out.println("Book with ID " + id + " not found.");
        }
    }

    public void borrowedBook(int id) throws IOException {
        List<Book> bookList = bookRepository.findAll();
        boolean found = false;
        for (Book book : bookList) {
            if (book.getId() == id) {
                found = true;
                if (book.getBorrowed()) {
                    System.out.println("The book was borrowed before");
                    break;
                }
                book.setBorrowed(true);
                System.out.println("The book was borrowed successfully");
                break;
            }
        }
        if (!found) {
            System.out.println("Book with ID " + id + " not found");
        }
        bookRepository.saveBook(bookList);
    }

    public void returnBook(int id) {
        List<Book> bookList = bookRepository.findAll();
        boolean found = false;
        for (Book book : bookList) {
            if (book.getId() == id) {
                found = true;
                if (!book.getBorrowed()) {
                    System.out.println("Wrong Choice This Book Was Not Borrowed");
                    break;
                }
                book.setBorrowed(false);
                System.out.println("The book return successfully");
                break;
            }
        }
        if (!found) {
            System.out.println("Book with ID " + id + " not found");
        }
        bookRepository.saveBook(bookList);
    }
}