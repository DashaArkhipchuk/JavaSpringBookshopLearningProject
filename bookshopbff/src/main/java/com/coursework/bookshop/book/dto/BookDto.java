package com.coursework.bookshop.book.dto;

import com.coursework.bookshop.author.dto.AuthorDto;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class BookDto {
    private Integer id;
    private String title;
    private int publishYear;
    private String genre;
    private Double price;
    private AuthorDto author;
}
