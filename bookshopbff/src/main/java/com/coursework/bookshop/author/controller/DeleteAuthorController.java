package com.coursework.bookshop.author.controller;

import com.coursework.bookshop.author.entity.Author;
import com.coursework.bookshop.author.request.DeleteAuthorRequest;
import com.coursework.bookshop.author.service.AuthorService;
import com.coursework.bookshop.book.entity.Book;
import com.coursework.bookshop.book.request.DeleteBookRequest;
import com.coursework.bookshop.book.service.BookService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

@Log4j2
@Controller
@RequiredArgsConstructor
public class DeleteAuthorController {
    public final AuthorService authorService;
    @PostMapping("${app.api.path.author.deleteAuthor}")
    public ModelAndView deleteAuthor(@ModelAttribute @Validated DeleteAuthorRequest deleteauthorobj) {
        Author author = authorService.deleteAuthorByRequest(deleteauthorobj);

        RedirectView redirectView = new RedirectView("/authors", true);
        return new ModelAndView(redirectView);
    }
}
