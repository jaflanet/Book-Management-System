package com.example.BookManagementSystem.controller;


import com.example.BookManagementSystem.entity.BookEntity;
import com.example.BookManagementSystem.entity.GenreEntity;
import com.example.BookManagementSystem.services.BookService;
import com.example.BookManagementSystem.services.GenreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/genres")
public class GenreController {
    @Autowired
    private GenreService genreService;

    @PostMapping
    public GenreEntity createBook(@RequestBody GenreEntity genre) {
        return genreService.createGenre(genre);
    }

    @GetMapping
    public ResponseEntity<List<GenreEntity>> getAllGenre() {
        return ResponseEntity.ok(genreService.getAllGenre());
    }

    @GetMapping("/{id}")
    public ResponseEntity<GenreEntity> getBookById(@PathVariable Long id) {
        GenreEntity genre = genreService.getGenreById(id);
        if (genre != null) {
            return ResponseEntity.ok(genre);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<GenreEntity> updateBook(@PathVariable Long id, @RequestBody GenreEntity genreDetails) {
        GenreEntity genre = genreService.getGenreById(id);
        if (genre != null) {
            genre.setName(genreDetails.getName());
            GenreEntity updatedGenres = genreService.createGenre(genre);
            return ResponseEntity.ok(updatedGenres);
        } else {
            return ResponseEntity.notFound().build();
        }
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteGenre(@PathVariable Long id) {
        genreService.deleteGenre(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/page")
    public Page<GenreEntity> getAllGenre(Pageable pageable) {
        return genreService.getGenre(pageable);
    }
}
