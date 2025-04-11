package com.coursework.bookshop.book.mapper;

import com.coursework.bookshop.author.mapper.AuthorDtoMapper;
import com.coursework.bookshop.book.dto.BookDto;
import com.coursework.bookshop.book.entity.Book;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;
@Component
@RequiredArgsConstructor
public class BookDtoMapper {
    public final AuthorDtoMapper authorDtoMapper;
    public BookDto mapBookToBookDto(Book b){
        BookDto dto=BookDto.builder()
                .id(b.getId())
                .author(authorDtoMapper.mapAuthorToAuthorDto(b.getAuthor()))
                .publishYear(b.getPublishYear())
                .genre(b.getGenre())
                .title(b.getTitle())
                .price(b.getPrice())
                .build();
        return dto;

    }

    public List<BookDto> mapBooksToBookDtos(List<Book> buildings) {
        return buildings.stream()
                .map(this::mapBookToBookDto)
                .collect(Collectors.toList());
    }
}
