package OgulcanONDER.model;

public class Book {
    private int id;
    private String bookName;
    private String bookGenre;
    private int pageNumber;
    private String author;
    private boolean borrowed;

    public Book(int id, String bookName, String bookGenre, int pageNumber, String author, boolean borrowed) {
        this.id = id;
        this.bookName = bookName;
        this.bookGenre = bookGenre;
        this.pageNumber = pageNumber;
        this.author = author;
        this.borrowed = borrowed;
    }

    public Book() {

    }


    // GETTER - SETTER
    public int getId() {
        return id;
    }

    public String getBookName() {
        return bookName;
    }

    public String getBookGenre() {
        return bookGenre;
    }

    public int getPageNumber() {
        return pageNumber;
    }

    public String getAuthor() {
        return author;
    }

    public boolean getBorrowed() {
        return borrowed;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public void setBookGenre(String bookGenre) {
        this.bookGenre = bookGenre;
    }

    public void setPageNumber(int pageNumber) {
        this.pageNumber = pageNumber;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setBorrowed(boolean borrowed) {
        this.borrowed = borrowed;
    }

    @Override
    public String toString() {
        return "\nBook Id:" + id + "\n Book Name: "
                + bookName + "\n Book Genre: " +
                bookGenre + "\n Page Numbers: " +
                pageNumber + "\n Author: " +
                author + "\n Borrowed: " +
                borrowed + "\n";
    }
}
