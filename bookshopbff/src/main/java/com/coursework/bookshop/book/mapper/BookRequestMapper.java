package com.coursework.bookshop.book.mapper;

import com.coursework.bookshop.author.entity.Author;
import com.coursework.bookshop.author.mapper.AuthorRequestMapper;
import com.coursework.bookshop.book.entity.Book;
import com.coursework.bookshop.book.request.CreateBookRequest;
import com.coursework.bookshop.book.request.CreateBookRequestWithAuthorId;
import com.coursework.bookshop.book.request.UpdateBookRequest;

public class BookRequestMapper {

    public static UpdateBookRequest mapBooktoUpdateBookRequest(Book b){
        UpdateBookRequest book= UpdateBookRequest.builder()
                .id(b.getId())
                .title(b.getTitle())
                .authorId(b.getAuthor().getId())
                .genre(b.getGenre())
                .publishYear(b.getPublishYear())
                .price(b.getPrice())
                .build();
        return  book;
    }
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

    public static Book mapCreateBookRequestWithAuthorIdToBook(CreateBookRequestWithAuthorId request, Author author){
        Book b= Book.builder()
                .author(author)
                .title(request.getTitle())
                .genre(request.getGenre())
                .price(request.getPrice())
                .publishYear(request.getPublishYear())
                .build();
        return b;
    }
}
