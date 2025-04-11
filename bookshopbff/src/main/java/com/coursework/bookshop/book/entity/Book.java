package com.coursework.bookshop.book.entity;

import com.coursework.bookshop.author.entity.Author;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Book {
    private Integer id;
    private String title;
    private int publishYear;
    private String genre;
    private Double price;

    private Author author;
}
