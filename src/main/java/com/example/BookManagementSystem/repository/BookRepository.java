package com.example.BookManagementSystem.repository;


import com.example.BookManagementSystem.entity.BookEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<BookEntity>, Long> {

}
