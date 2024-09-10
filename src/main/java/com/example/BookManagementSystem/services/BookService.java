package com.example.BookManagementSystem.services;

import com.example.BookManagementSystem.entity.BookEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BookService {
    BookEntity createBook(BookEntity book);

    List<BookEntity> getAllBooks();

    BookEntity getBookById(Long id);

    void deleteBook(Long id);

    Page<BookEntity> getBooks(Pageable pageable);
}
