package com.example.BookManagementSystem.services.Impl;


import com.example.BookManagementSystem.entity.BookEntity;
import com.example.BookManagementSystem.repository.BookRepository;
import com.example.BookManagementSystem.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookRepository bookRepository;


    public BookEntity createBook(BookEntity book) {
        return bookRepository.save(book);
    }


    public List<BookEntity> getAllBooks() {
        return bookRepository.findAll();
    }


    public BookEntity getBookById(Long id) {
        return bookRepository.findById(id).orElse(null);
    }


    public void deleteBook(Long id) {
        bookRepository.deleteById(id);
    }

    @Override
    public Page<BookEntity> getBooks(Pageable pageable) {
        return bookRepository.findAll(pageable);
    }


}


