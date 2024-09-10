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
    List<BookEntity> findByTitleContainingOrAuthor_NameContainingOrGenre_NameContaining(
            String title, String authorName, String genreName);
    Page<BookEntity> findAll(Pageable pageable);
}




