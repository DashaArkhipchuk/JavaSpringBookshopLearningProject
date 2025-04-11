package com.coursework.bookshop.home.controller;

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
public class HomeController {

    @GetMapping("${app.api.path.home}")
    public ModelAndView getHomePage(Authentication authentication) {

        if (authentication != null && authentication.isAuthenticated()) {
            ModelAndView modelAndView=new ModelAndView("homeauthenticated", HttpStatus.OK);
            return modelAndView;

        } else {
            ModelAndView modelandview = new ModelAndView("home", HttpStatus.OK);
            return modelandview;
        }
    }
}
