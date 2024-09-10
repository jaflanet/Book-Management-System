package com.example.BookManagementSystem.services;

import com.example.BookManagementSystem.entity.AuthorEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AuthorService {
    AuthorEntity createAuthor(AuthorEntity author);

    List<AuthorEntity> getAllAuthors();

    AuthorEntity getAuthorById(Long id);

    void deleteAuthor(Long id);

    Page<AuthorEntity> getAuthor(Pageable pageable);
}
