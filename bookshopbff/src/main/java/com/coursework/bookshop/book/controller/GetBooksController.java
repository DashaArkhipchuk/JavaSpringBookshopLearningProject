package com.coursework.bookshop.book.controller;

import com.coursework.bookshop.book.dto.BookDto;
import com.coursework.bookshop.book.request.DeleteBookRequest;
import com.coursework.bookshop.book.service.BookService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Log4j2
@Controller
@RequiredArgsConstructor
public class GetBooksController {
    public final BookService bookService;

    @GetMapping("${app.api.path.book.getBooks}")
    public ModelAndView getAllBooks(Authentication authentication) {

        List<BookDto> allBooks = bookService.getAllBooks();
        log.info(bookService.getAllBooks());

        Map<String, List<BookDto>> result = new HashMap<>();
        result.put("books", allBooks);

        if (authentication != null && authentication.isAuthenticated()) {
            // Get the user's authorities (roles)
            Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();

            // Check if the user has the required role
            boolean hasRoleAdmin = authorities.stream()
                    .map(GrantedAuthority::getAuthority)
                    .anyMatch(role -> role.equals("ADMIN"));
            boolean hasRoleManager = authorities.stream()
                    .map(GrantedAuthority::getAuthority)
                    .anyMatch(role -> role.equals("MANAGER"));

            if (hasRoleAdmin) {
                ModelAndView modelandview = new ModelAndView("books", result, HttpStatus.OK);
                modelandview.addObject("deletebookobj", DeleteBookRequest.builder().build());
                return modelandview;
            } else if (hasRoleManager) {
                ModelAndView modelandview = new ModelAndView("booksmanager", result, HttpStatus.OK);
                return modelandview;
            } else {
                ModelAndView modelandview = new ModelAndView("booksuser", result, HttpStatus.OK);
                return modelandview;
            }

        } else {
            ModelAndView modelandview = new ModelAndView("booksuser", result, HttpStatus.OK);
            return modelandview;
        }
    }
}