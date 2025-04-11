package com.coursework.bookshop.book.controller;

import com.coursework.bookshop.author.request.DeleteAuthorRequest;
import com.coursework.bookshop.book.entity.Book;
import com.coursework.bookshop.book.request.DeleteBookRequest;
import com.coursework.bookshop.book.service.BookService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Log4j2
@RestController
@RequestMapping("${app.api.path.version.v1}")
@RequiredArgsConstructor
public class DeleteBooksOfAuthorController {
    private final BookService bookService;
    @DeleteMapping("${app.api.path.book.deleteBooks}")
    public ResponseEntity<Book> deleteBooks(
            @RequestBody DeleteAuthorRequest deleteAuthorRequest
    ){

        bookService.deleteBooksByAuthorsId(deleteAuthorRequest);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
