package com.example.BookManagementSystem.controller;


import com.example.BookManagementSystem.entity.BookEntity;
import com.example.BookManagementSystem.request.CreateBookRequest;
import com.example.BookManagementSystem.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/books")
public class BookController {
    @Autowired
    private BookService bookService;

    @PostMapping
    public ResponseEntity<BookEntity> createBook(@RequestBody CreateBookRequest book) {
        BookEntity savedBook = bookService.createBook(book);
        return ResponseEntity.ok(savedBook);
    }

    @GetMapping
    public ResponseEntity<List<BookEntity>> getAllBooks() {
        return ResponseEntity.ok(bookService.getAllBooks());
    }

    @GetMapping("/{id}")
    public ResponseEntity<BookEntity> getBookById(@PathVariable Long id) {
        BookEntity book = bookService.getBookById(id);
        if (book != null) {
            return ResponseEntity.ok(book);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<BookEntity> updateBook(@PathVariable Long id, @RequestBody CreateBookRequest book) {
        BookEntity savedBook = bookService.updateBook(id,book);
        return ResponseEntity.ok(savedBook);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBook(@PathVariable Long id) {
        bookService.deleteBook(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/page")
    public Page<BookEntity> getAllBooks(Pageable pageable) {
        return bookService.getBooks(pageable);
    }


}


