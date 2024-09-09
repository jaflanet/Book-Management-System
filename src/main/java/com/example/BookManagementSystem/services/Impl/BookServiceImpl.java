package com.example.BookManagementSystem.services.Impl;


import com.example.BookManagementSystem.entity.BookEntity;
import com.example.BookManagementSystem.repository.BookRepository;
import com.example.BookManagementSystem.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookRepository bookRepository;

    @Override
    public BookEntity saveBook(BookEntity book) {
        return bookRepository.save(book);
    }

    @Override
    public List<BookEntity> getAllBooks() {
        return bookRepository.findAll();
    }

    @Override
    public Optional<BookEntity> getBookById(Long id) {
        return bookRepository.findById(id);
    }

    @Override
    public void deleteBook(Long id) {
        bookRepository.deleteById(id);
    }

    @Override
    public List<BookEntity> searchBooks(String title, String authorName, String genreName) {
        return bookRepository.findByTitleContainingOrAuthor_NameContainingOrGenre_NameContaining(
                title, authorName, genreName);
    }
}


