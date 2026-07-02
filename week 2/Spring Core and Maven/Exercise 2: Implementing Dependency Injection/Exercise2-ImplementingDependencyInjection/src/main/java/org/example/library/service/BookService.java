package org.example.library.service;

import org.example.library.repository.BookRepository;

public class BookService {

    private BookRepository bookRepository;

    public BookService() {
    }

    public BookRepository getBookRepository() {
        return bookRepository;
    }

    public void setBookRepository(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public void displayBooks() {
        bookRepository.displayBooks();
    }
}