package com.example.BookManagementSystem.controller;

import com.example.BookManagementSystem.entity.AuthorEntity;
import com.example.BookManagementSystem.entity.BookEntity;
import com.example.BookManagementSystem.entity.GenreEntity;
import com.example.BookManagementSystem.services.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/authors")
public class AuthorController {
    @Autowired
    private AuthorService authorService;

    @PostMapping
    public AuthorEntity createAuthor(@RequestBody AuthorEntity author){
        return authorService.createAuthor(author);
    }

    @GetMapping
    public ResponseEntity<List<AuthorEntity>> getAllAuthor() {
        return ResponseEntity.ok(authorService.getAllAuthor());
    }

    @GetMapping("/{id}")
    public ResponseEntity<AuthorEntity> getAuthorById(@PathVariable Long id) {
        AuthorEntity author = authorService.getAuthorById(id);
        if (author != null) {
            return ResponseEntity.ok(author);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<AuthorEntity> updateBook(@PathVariable Long id, @RequestBody AuthorEntity authorDetails) {
        AuthorEntity author = authorService.getAuthorById(id);
        if (author != null) {
            author.setName(authorDetails.getName());
            author.setBio(authorDetails.getBio());
            AuthorEntity updatedAuthor = authorService.createAuthor(author);
            return ResponseEntity.ok(updatedAuthor);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAuthor(@PathVariable Long id) {
        authorService.deleteAuthor(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/page")
    public Page<AuthorEntity> getAllAuthor(Pageable pageable) {
        return authorService.getAuthor(pageable);
    }

}
