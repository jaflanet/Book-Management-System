package com.example.BookManagementSystem.repository;


import com.example.BookManagementSystem.entity.BookEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import java.util.List;
import java.util.Optional;


@Repository
public interface BookRepository extends JpaRepository<BookEntity, Long> {
    Optional<BookEntity> findByTitleContainingIgnoreCase(String title);
    Optional<BookEntity> findByAuthor_NameContainingIgnoreCase(String authorName);
    Optional<BookEntity> findByGenre_NameContainingIgnoreCase(String genreName);
    Page<BookEntity> findAll(Pageable pageable);
}



//
//public interface AuthorRepository extends JpaRepository<AuthorEntity, Long> {
//}
//
//public interface GenreRepository extends JpaRepository<GenreEntity, Long> {
//
//}


