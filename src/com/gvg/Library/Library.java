package com.gvg.Library;


import libraryassignment.Book;
import java.util.HashMap;
import java.util.Map;

import LibraryException.LibraryException;

public class Library {
    private Map<String, Book> books = new HashMap<>();

    public void addBook(Book book) {
        books.put(book.getIsbn(), book);
    }

    public void borrowBook(String isbn) throws LibraryException {
        Book book = books.get(isbn);
        if (book == null) {
            throw new LibraryException("Book not found.");
        }
        book.borrow();
    }

    public void returnBook(String isbn) throws LibraryException {
        Book book = books.get(isbn);
        if (book == null) {
            throw new LibraryException("Book not found.");
        }
        book.returnBook();
    }

    public void showBooks() {
        if (books.isEmpty()) {
            System.out.println("No books in the library.");
        } else {
            books.values().forEach(System.out::println);
        }
    }
}
