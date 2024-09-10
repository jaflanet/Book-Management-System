package com.example.BookManagementSystem.services;

import com.example.BookManagementSystem.entity.AuthorEntity;
import com.example.BookManagementSystem.entity.BookEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AuthorService {
    BookEntity createAuthor(AuthorEntity author);

    List<BookEntity> getAllAuthor();

    BookEntity getAuthorById(Long id);

    void deleteAuthor(Long id);

    Page<AuthorEntity> getAuthor(Pageable pageable);
}
