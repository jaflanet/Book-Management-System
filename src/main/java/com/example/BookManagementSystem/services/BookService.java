package com.example.BookManagementSystem.services;

import com.example.BookManagementSystem.entity.BookEntity;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BookService {
    BookEntity saveBook(BookEntity book);

    List<BookEntity> getAllBooks();

    Optional<BookEntity> getBookById(Long id);

    void deleteBook(Long id);

    List<BookEntity> searchBooks(String title, String authorName, String genreName);
}
