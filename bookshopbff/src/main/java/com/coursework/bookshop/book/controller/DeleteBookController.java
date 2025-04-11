package com.coursework.bookshop.book.controller;

import com.coursework.bookshop.book.dto.BookWithAuthorIdDto;
import com.coursework.bookshop.book.entity.Book;
import com.coursework.bookshop.book.request.DeleteBookRequest;
import com.coursework.bookshop.book.service.BookService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

@Log4j2
@Controller
@RequiredArgsConstructor
public class DeleteBookController {
    public final BookService bookService;
    @PostMapping("${app.api.path.book.deleteBook}")
    public ModelAndView deleteBook(@ModelAttribute @Validated DeleteBookRequest deletebookobj) {
        Book book = bookService.deleteBookByRequest(deletebookobj);

        RedirectView redirectView = new RedirectView("/books", true);
        return new ModelAndView(redirectView);
    }
}
