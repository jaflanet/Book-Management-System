package com.example.BookManagementSystem.services.Impl;


import com.example.BookManagementSystem.entity.AuthorEntity;
import com.example.BookManagementSystem.entity.BookEntity;
import com.example.BookManagementSystem.entity.GenreEntity;
import com.example.BookManagementSystem.repository.AuthorRepository;
import com.example.BookManagementSystem.repository.BookRepository;
import com.example.BookManagementSystem.repository.GenreRepository;
import com.example.BookManagementSystem.request.CreateBookRequest;
import com.example.BookManagementSystem.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.awt.print.Book;
import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private AuthorRepository authorRepository;

    @Autowired
    private GenreRepository genreRepository;

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

    @Override
    public BookEntity createBook(CreateBookRequest createBookDTO) {
        AuthorEntity author = authorRepository.findById((long) createBookDTO.getAuthor_id())
                .orElseThrow(() -> new RuntimeException("Author not found"));

        // Fetch the genre by ID using the injected instance
        GenreEntity genre = genreRepository.findById((long) createBookDTO.getGenre_id())
                .orElseThrow(() -> new RuntimeException("Genre not found"));

        // Create a new book entity
        BookEntity book = new BookEntity();
        book.setTitle(createBookDTO.getTitle());
        book.setIsbn(createBookDTO.getIsbn());
        book.setAuthor(author);
        book.setGenre(genre);
        book.setPublished_date(createBookDTO.getPublished_date());

        return bookRepository.save(book);
    }

//    @Override
//    public BookEntity updateBook(Long id, CreateBookRequest createBookDTO) {
//        AuthorEntity author = authorRepository.findById((long) createBookDTO.getAuthor_id())
//                .orElseThrow(() -> new RuntimeException("Author not found"));
//
//        // Fetch the genre by ID using the injected instance
//        GenreEntity genre = genreRepository.findById((long) createBookDTO.getGenre_id())
//                .orElseThrow(() -> new RuntimeException("Genre not found"));
//
//        // Create a new book entity
//        BookEntity book = new BookEntity();
//        book.setTitle(createBookDTO.getTitle());
//        book.setIsbn(createBookDTO.getIsbn());
//        book.setAuthor(author);
//        book.setGenre(genre);
//        book.setPublished_date(createBookDTO.getPublished_date());
//
//        return bookRepository.save(book);
//    }

}


