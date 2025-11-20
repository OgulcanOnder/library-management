package OgulcanONDER.repository;

import OgulcanONDER.model.Book;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;


import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class BookRepository {
    private static final String FILE_PATH = "LibraryManagement\\src\\main\\java\\OgulcanONDER\\repository\\books.json";
    private static final Gson gson = new Gson();

    public void saveBook(List<Book> book) {
        try {
            FileWriter writer = new FileWriter(FILE_PATH);
            gson.toJson(book, writer);
            writer.close();
        } catch (IOException e) {
            throw new RuntimeException("Error saving books" + e.getMessage());
        }
    }

    public List<Book> findAll() {
        try {
            FileReader reader = new FileReader(FILE_PATH);
            Type listType = new TypeToken<List<Book>>() {
            }.getType();
            List<Book> newBooks = gson.fromJson(reader, listType);
            reader.close();
            return newBooks != null ? newBooks : new ArrayList<>();
        } catch (IOException e) {
            throw new RuntimeException("Not Found Books" + e.getMessage());
        }

    }

    public Book findById(int id) throws IOException {
        try {
            FileReader reader = new FileReader(FILE_PATH);
            Type listType = new TypeToken<List<Book>>() {
            }.getType();
            List<Book> allBooks = gson.fromJson(reader, listType);
            reader.close();
            if (allBooks == null) {
                return null;
            }
            for (Book book : allBooks) {
                if (book.getId() == id) {
                    return book;
                }
            }
            return null;

        } catch (IOException e) {
            throw new IOException();
        }
    }
}
