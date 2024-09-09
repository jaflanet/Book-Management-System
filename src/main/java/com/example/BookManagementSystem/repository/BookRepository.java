package com.example.BookManagementSystem.repository;


import com.example.BookManagementSystem.entity.AuthorEntity;
import com.example.BookManagementSystem.entity.BookEntity;
import com.example.BookManagementSystem.entity.GenreEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.awt.print.Book;
import java.util.List;

public interface BookRepository extends JpaRepository<BookEntity, Long> {
    List<BookEntity> findByTitleContainingOrAuthor_NameContainingOrGenre_NameContaining(
            String title, String authorName, String genreName);
}

public interface AuthorRepository extends JpaRepository<AuthorEntity, Long> {
    List
}

public interface GenreRepository extends JpaRepository<GenreEntity, Long> {

}


