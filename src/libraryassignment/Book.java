package libraryassignment;

import LibraryException.LibraryException;

public class Book {
    private String isbn;
    private String title;
    private String author;
    private boolean isBorrowed;

    public Book(String isbn, String title, String author) {
        this.isbn = isbn;
        this.title = title;
        this.author = author;
        this.isBorrowed = false;
    }

    public String getIsbn() {
        return isbn;
    }

    public String getTitle() {
        return title;
    }

    public boolean isBorrowed() {
        return isBorrowed;
    }

    public void borrow() throws LibraryException {
        if (isBorrowed) {
            throw new LibraryException("Book is already borrowed.");
        }
        isBorrowed = true;
    }

    public void returnBook() throws LibraryException {
        if (!isBorrowed) {
            throw new LibraryException("Book was not borrowed.");
        }
        isBorrowed = false;
    }

    @Override
    public String toString() {
        return String.format("%s - %s by %s [%s]", isbn, title, author, isBorrowed ? "Borrowed" : "Available");
    }
}
