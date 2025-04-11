package com.coursework.bookshop.book.mapper;

import com.coursework.bookshop.author.mapper.AuthorDtoMapper;
import com.coursework.bookshop.author.mapper.FullAuthorDtoMapper;
import com.coursework.bookshop.author.service.AuthorService;
import com.coursework.bookshop.book.dto.BookDto;
import com.coursework.bookshop.book.dto.BookWithAuthorIdDto;
import com.coursework.bookshop.book.entity.Book;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;
@Component
@RequiredArgsConstructor
public class BookWithAuthorIdDtoMapper {
    public final AuthorService authorService;
    public final FullAuthorDtoMapper fullAuthorDtoMapper;

    public Book mapBookBookWithAuthorIdDtoToBook(BookWithAuthorIdDto b){
        Book dto=Book.builder()
                .id(b.getId())
                .author(fullAuthorDtoMapper.mapFullAuthorDtoToAuthor(authorService.getAuthor(b.getAuthorId())))
                .publishYear(b.getPublishYear())
                .genre(b.getGenre())
                .title(b.getTitle())
                .price(b.getPrice())
                .build();
        return dto;

    }
    public BookWithAuthorIdDto mapBookToBookWithAuthorIdDto(Book b){
        BookWithAuthorIdDto dto=BookWithAuthorIdDto.builder()
                .id(b.getId())
                .authorId(b.getAuthor().getId())
                .publishYear(b.getPublishYear())
                .genre(b.getGenre())
                .title(b.getTitle())
                .price(b.getPrice())
                .build();
        return dto;

    }
}
