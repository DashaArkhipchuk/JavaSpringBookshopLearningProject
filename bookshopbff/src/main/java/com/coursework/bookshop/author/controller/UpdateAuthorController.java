package com.coursework.bookshop.author.controller;

import com.coursework.bookshop.author.dto.AuthorDto;
import com.coursework.bookshop.author.dto.FullAuthorDto;
import com.coursework.bookshop.author.mapper.AuthorRequestMapper;
import com.coursework.bookshop.author.mapper.FullAuthorDtoMapper;
import com.coursework.bookshop.author.request.UpdateAuthorRequest;
import com.coursework.bookshop.author.service.AuthorService;
import com.coursework.bookshop.book.dto.BookDto;
import com.coursework.bookshop.book.dto.BookWithAuthorIdDto;
import com.coursework.bookshop.book.mapper.BookRequestMapper;
import com.coursework.bookshop.book.mapper.BookWithAuthorIdDtoMapper;
import com.coursework.bookshop.book.request.UpdateBookRequest;
import com.coursework.bookshop.book.service.BookService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Log4j2
@Controller
@RequiredArgsConstructor
public class UpdateAuthorController {
    private final AuthorService authorService;
    private final BookWithAuthorIdDtoMapper bookWithAuthorIdDtoMapper;
    private final FullAuthorDtoMapper fullAuthorDtoMapper;
    @GetMapping("${app.api.path.author.updateAuthor}")
    public ModelAndView getUpdateForm(
            @RequestParam Integer id
    ){

        FullAuthorDto a = authorService.getAuthor(id);
        ModelAndView modelAndView = new ModelAndView("updateauthor", new HashMap<>(), HttpStatus.OK);
        modelAndView.addObject("a", a);
        modelAndView.addObject("author", UpdateAuthorRequest.builder().build());

        return modelAndView;
    }

    @PostMapping("${app.api.path.author.updateAuthor}")
    public ModelAndView updateAuthor(@ModelAttribute @Validated UpdateAuthorRequest author) throws Exception {
            log.info(author);
            AuthorDto authorDto = authorService.updateAuthor(author);
            RedirectView redirectView = new RedirectView("/author?id=" + authorDto.getId(), true);
            return new ModelAndView(redirectView);
    }
}
