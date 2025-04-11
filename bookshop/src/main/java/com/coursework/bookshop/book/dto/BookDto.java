package com.coursework.bookshop.book.dto;

import com.coursework.bookshop.author.dto.AuthorDto;
import com.coursework.bookshop.author.entity.Author;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
