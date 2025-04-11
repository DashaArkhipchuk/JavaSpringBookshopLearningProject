package com.coursework.bookshop.book.controller;

import com.coursework.bookshop.author.dto.AuthorDto;
import com.coursework.bookshop.author.dto.FullAuthorDto;
import com.coursework.bookshop.author.entity.Author;
import com.coursework.bookshop.author.mapper.FullAuthorDtoMapper;
import com.coursework.bookshop.author.request.CreateAuthorRequest;
import com.coursework.bookshop.author.service.AuthorService;
import com.coursework.bookshop.book.dto.BookDto;
import com.coursework.bookshop.book.dto.BookWithAuthorIdDto;
import com.coursework.bookshop.book.entity.Book;
import com.coursework.bookshop.book.mapper.BookRequestMapper;
import com.coursework.bookshop.book.mapper.BookWithAuthorIdDtoMapper;
import com.coursework.bookshop.book.request.CreateBookRequest;
import com.coursework.bookshop.book.request.CreateBookRequestWithAuthorId;
import com.coursework.bookshop.book.service.BookService;
import com.coursework.bookshop.user.entity.User;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Log4j2
@Controller
@RequiredArgsConstructor
public class CreateBookController {
    public final BookService bookService;
    public final AuthorService authorService;
    public final FullAuthorDtoMapper fullAuthorDtoMapper;
    @GetMapping("${app.api.path.book.createBook}")
    public ModelAndView getCreateForm(
    ){
        List<AuthorDto> getAuthors= authorService.getAllAuthorNames();
        Map<String, List<AuthorDto>> result= new HashMap<>();
        result.put("authors",getAuthors);
        ModelAndView modelAndView = new ModelAndView("createbook", result, HttpStatus.OK);
        modelAndView.addObject("book", CreateBookRequestWithAuthorId.builder().build());

        return modelAndView;
    }

    @PostMapping("${app.api.path.book.createBook}")
    public ModelAndView createBook(@ModelAttribute @Validated CreateBookRequestWithAuthorId book) throws Exception {
        FullAuthorDto author = authorService.getAuthor(book.getAuthorId());
        if (author!=null){

            CreateBookRequest createBookRequest = BookRequestMapper.mapBookToCreateBookRequest(BookRequestMapper.mapCreateBookRequestWithAuthorIdToBook(book, fullAuthorDtoMapper.mapFullAuthorDtoToAuthor(author)));
            BookDto savedBook = bookService.createBook(createBookRequest);
            RedirectView redirectView = new RedirectView("/book?id=" + savedBook.getId(), true);
            return new ModelAndView(redirectView);
        } else{
            throw new Exception("Cant create a book without an author");
        }
    }
}
