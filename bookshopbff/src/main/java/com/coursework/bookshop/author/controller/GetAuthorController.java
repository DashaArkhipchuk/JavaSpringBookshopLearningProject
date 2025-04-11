package com.coursework.bookshop.author.controller;

import com.coursework.bookshop.author.dto.AuthorDto;
import com.coursework.bookshop.author.dto.FullAuthorDto;
import com.coursework.bookshop.author.service.AuthorService;
import com.coursework.bookshop.book.dto.BookDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Log4j2
@Controller
@RequiredArgsConstructor
public class GetAuthorController {
    private final AuthorService authorService;
    @SuppressWarnings("unused")
    @GetMapping("${app.api.path.author.getAuthor}")
    public ModelAndView getAuthor(@RequestParam Integer id) {
        FullAuthorDto author = authorService.getAuthor(id);
        Map<String, FullAuthorDto> arguments = new HashMap<>();
        arguments.put("author", author);
        return new ModelAndView("author", arguments, HttpStatus.OK);
    }

}