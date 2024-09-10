package com.example.BookManagementSystem.request;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Data
@Builder
@Getter
@Setter
public class CreateBookRequest {
    @JsonProperty("title")
    private String title;

    @JsonProperty("isbn")
    private String isbn;

    @JsonProperty("author_id")
    private int author_id;

    @JsonProperty("genre_id")
    private int genre_id;

    @JsonProperty("published_date")
    private LocalDate published_date;
}
