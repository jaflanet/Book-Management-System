package com.example.BookManagementSystem.services.Impl;

import com.example.BookManagementSystem.entity.AuthorEntity;
import com.example.BookManagementSystem.entity.GenreEntity;
import com.example.BookManagementSystem.repository.AuthorRepository;
import com.example.BookManagementSystem.repository.GenreRepository;
import com.example.BookManagementSystem.services.GenreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GenreServiceImpl implements GenreService {
    @Autowired
    private GenreRepository genreRepository;


    public GenreEntity createGenre(GenreEntity genre) {
        return genreRepository.save(genre);
    }


    public List<GenreEntity> getAllGenre() {
        return genreRepository.findAll();
    }


    public GenreEntity getGenreById(Long id) {
        return genreRepository.findById(id).orElse(null);
    }


    public void deleteGenre(Long id) {
        genreRepository.deleteById(id);
    }

    public Page<GenreEntity> getGenre(Pageable pageable) {
        return genreRepository.findAll(pageable);
    }
}
