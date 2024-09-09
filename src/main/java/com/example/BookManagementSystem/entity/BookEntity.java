package com.example.BookManagementSystem.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@Table(name = "book")

public class BookEntity {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    @JsonProperty("title")
    private String title;

    @Column(nullable = false)
    @JsonProperty("isbn")
    private String isbn;

    @ManyToOne
    @JoinColumn(name = "author_id")
    @JsonProperty("author")
    private AuthorEntity author;

    @ManyToOne
    @JoinColumn(name = "genre_id")
    @JsonProperty("genre")
    private GenreEntity genre;

    @Column(name = "published_date" ,nullable = false)
    @JsonProperty("published_date")
    private LocalDate publishedDate;

}
