package com.example.BookManagementSystem.services;

import com.example.BookManagementSystem.entity.GenreEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface GenreService {
    GenreEntity createGenre(GenreEntity genre);

    List<GenreEntity> getAllGenre();

    GenreEntity getGenreById(Long id);

    void deleteGenre(Long id);

    Page<GenreEntity> getGenre(Pageable pageable);
}
