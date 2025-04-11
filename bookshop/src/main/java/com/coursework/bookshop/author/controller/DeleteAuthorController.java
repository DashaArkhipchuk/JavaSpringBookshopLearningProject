package com.coursework.bookshop.author.controller;

import com.coursework.bookshop.author.entity.Author;
import com.coursework.bookshop.author.request.DeleteAuthorRequest;
import com.coursework.bookshop.author.service.AuthorService;
import com.coursework.bookshop.book.entity.Book;
import com.coursework.bookshop.book.request.DeleteBookRequest;
import com.coursework.bookshop.book.service.BookService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Log4j2
@RestController
@RequestMapping("${app.api.path.version.v1}")
@RequiredArgsConstructor
public class DeleteAuthorController {
    private final AuthorService bookService;
    @DeleteMapping("${app.api.path.author.deleteAuthor}")
    public ResponseEntity<Author> deleteAuthor(
            @RequestBody @Validated DeleteAuthorRequest deleteAuthorRequest
    ){

        bookService.deleteAuthorByRequest(deleteAuthorRequest);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
