package com.coursework.bookshop.book.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class BookWithAuthorIdDto {
    private Integer id;
    private String title;
    private int publishYear;
    private String genre;
    private Double price;
    private Integer authorId;
}

