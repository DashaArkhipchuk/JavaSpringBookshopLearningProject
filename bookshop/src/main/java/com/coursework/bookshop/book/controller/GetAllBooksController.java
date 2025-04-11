package com.coursework.bookshop.book.controller;

import com.coursework.bookshop.book.dto.BookDto;
import com.coursework.bookshop.book.entity.Book;
import com.coursework.bookshop.book.service.BookService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Log4j2
@RestController
@RequestMapping("${app.api.path.version.v1}")
@RequiredArgsConstructor
public class GetAllBooksController {
    private final BookService bookService;
    @GetMapping("${app.api.path.book.getBooks}")
    public ResponseEntity<List<BookDto>> getBooks(
    ){
        List<BookDto> books = bookService.getAllBooks();
        return new ResponseEntity<>(books, HttpStatus.OK);
    }
}
