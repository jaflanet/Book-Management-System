package com.example.BookManagementSystem.repository;


import com.example.BookManagementSystem.entity.BookEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


import java.util.List;
import java.util.Optional;


@Repository
public interface BookRepository extends JpaRepository<BookEntity, Long> {
    @Query(value = "SELECT b.* FROM books b " +
            "JOIN authors a ON b.author_id = a.id " +
            "JOIN genres g ON b.genre_id = g.id " +
            "WHERE b.title LIKE %:title% " +
            "AND a.name LIKE %:author% " +
            "AND g.name LIKE %:genre%", nativeQuery = true)

    List<BookEntity> findByTitleContainingOrAuthor_NameContainingOrGenre_NameContaining(@Param("title") String title,
                                 @Param("author") String author,
                                 @Param("genre") String genre);

    Page<BookEntity> findAll(Pageable pageable);
}




