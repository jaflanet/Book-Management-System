package com.example.BookManagementSystem.services;

import com.example.BookManagementSystem.entity.BookEntity;
import com.example.BookManagementSystem.request.CreateBookRequest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.awt.print.Book;
import java.util.List;

@Repository
public interface BookService {
    BookEntity createBook(CreateBookRequest book);

    List<BookEntity> getAllBooks();

    BookEntity getBookById(Long id);

    void deleteBook(Long id);

    Page<BookEntity> getBooks(Pageable pageable);

    BookEntity updateBook (Long id, CreateBookRequest bookRequest);

    List<BookEntity> searchBooks(String title, String authorName, String genreName);
}
