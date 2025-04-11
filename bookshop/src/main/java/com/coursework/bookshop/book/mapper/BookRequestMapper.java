package com.coursework.bookshop.book.mapper;

import com.coursework.bookshop.author.dto.AuthorDto;
import com.coursework.bookshop.author.entity.Author;
import com.coursework.bookshop.author.mapper.AuthorRequestMapper;
import com.coursework.bookshop.book.entity.Book;
import com.coursework.bookshop.book.request.CreateBookRequest;
import lombok.extern.log4j.Log4j2;

public class BookRequestMapper {
    public static Book mapCreateBookRequestToBook(CreateBookRequest createAuthorRequest, Author author){
        Book book = Book.builder()
                .title(createAuthorRequest.getTitle())
                .author(author)
                .genre(createAuthorRequest.getGenre()).publishYear(createAuthorRequest.getPublishYear())
                .price(createAuthorRequest.getPrice())
                .publishYear(createAuthorRequest.getPublishYear())
                .build();

        return book;
    }

    public static CreateBookRequest mapBookToCreateBookRequest(Book book){
        CreateBookRequest request = CreateBookRequest.builder()
                .author(AuthorRequestMapper.mapAuthorToAuthorRequest(book.getAuthor()))
                .title(book.getTitle())
                .genre(book.getGenre())
                .price(book.getPrice())
                .publishYear(book.getPublishYear())
                .build();
        return request;
    }
}
