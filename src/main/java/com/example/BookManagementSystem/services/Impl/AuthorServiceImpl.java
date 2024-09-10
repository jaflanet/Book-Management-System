package com.example.BookManagementSystem.services.Impl;

import com.example.BookManagementSystem.entity.AuthorEntity;
import com.example.BookManagementSystem.entity.BookEntity;
import com.example.BookManagementSystem.repository.AuthorRepository;
import com.example.BookManagementSystem.services.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class AuthorServiceImpl implements AuthorService {
    @Autowired
    private AuthorRepository authorRepository;


    public AuthorEntity createAuthor(AuthorEntity author) {
        return authorRepository.save(author);
    }


    public List<AuthorEntity> getAllAuthors() {
        return authorRepository.findAll();
    }

    public AuthorEntity getAuthorById(Long id) {
        return authorRepository.findById(id).orElse(null);
    }

    public void deleteAuthor(Long id) {
        authorRepository.deleteById(id);
    }

    @Override
    public Page<AuthorEntity> getAuthor(Pageable pageable) {
        return null;
    }
}