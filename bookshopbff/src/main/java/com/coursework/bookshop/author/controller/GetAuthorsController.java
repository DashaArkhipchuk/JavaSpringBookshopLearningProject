package com.coursework.bookshop.author.controller;

import com.coursework.bookshop.author.dto.AuthorDto;
import com.coursework.bookshop.author.dto.FullAuthorDto;
import com.coursework.bookshop.author.service.AuthorService;
import com.coursework.bookshop.book.dto.BookDto;
import com.coursework.bookshop.book.request.DeleteBookRequest;
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
public class GetAuthorsController {
    private final AuthorService authorService;
    @SuppressWarnings("unused")
    @GetMapping("${app.api.path.author.getAuthors}")
    public ModelAndView getAuthors(Authentication authentication) {
        List<FullAuthorDto> allAuthors = authorService.getAllAuthors();
        Map<String, List<FullAuthorDto>> arguments = new HashMap<>();
        arguments.put("authors", allAuthors);
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
                return new ModelAndView("authors", arguments, HttpStatus.OK);
            } else if (hasRoleManager) {
                return new ModelAndView("authorsmanager", arguments, HttpStatus.OK);
            } else {
                return new ModelAndView("authorsuser", arguments, HttpStatus.OK);
            }

        } else {
            return new ModelAndView("authorsuser", arguments, HttpStatus.OK);
        }
    }

}