package com.example.BookManagementSystem.services;

import com.example.BookManagementSystem.entity.BookEntity;
import com.example.BookManagementSystem.request.CreateBookRequest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookService {
    CreateBookRequest createBook(CreateBookRequest book);

    List<BookEntity> getAllBooks();

    BookEntity getBookById(Long id);

    void deleteBook(Long id);

    Page<BookEntity> getBooks(Pageable pageable);
}
