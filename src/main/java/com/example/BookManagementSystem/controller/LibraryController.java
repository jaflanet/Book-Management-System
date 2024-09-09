package com.example.BookManagementSystem.controller;


import com.example.BookManagementSystem.entity.BookEntity;
import com.example.BookManagementSystem.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/books")
public class LibraryController {
    @Autowired
    private BookService bookService;

    @PostMapping
    public ResponseEntity<BookEntity> createBook(@RequestBody BookEntity book) {
        return ResponseEntity.ok(bookService.saveBook(book));
    }

    @GetMapping
    public ResponseEntity<List<BookEntity>> getAllBooks() {
        return ResponseEntity.ok(bookService.getAllBooks());
    }

    @GetMapping("/{id}")
    public ResponseEntity<BookEntity> getBookById(@PathVariable Long id) {
        return ResponseEntity.ok(bookService.getBookById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<BookEntity> updateBook(@PathVariable Long id, @RequestBody BookEntity book) {
        book.setId(id);
        return ResponseEntity.ok(bookService.saveBook(book));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBook(@PathVariable Long id) {
        bookService.deleteBook(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/search")
    public ResponseEntity<List<BookEntity>> searchBooks(
            @RequestParam(required = false) String title,
            @RequestParam(required = false) String author,
            @RequestParam(required = false) String genre) {
        return ResponseEntity.ok(bookService.searchBooks(title, author, genre));
    }
}


