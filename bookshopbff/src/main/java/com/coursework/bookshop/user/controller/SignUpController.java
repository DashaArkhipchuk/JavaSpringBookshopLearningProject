package com.coursework.bookshop.user.controller;

import com.coursework.bookshop.user.entity.Role;
import com.coursework.bookshop.user.request.RegisterUserRequest;
import com.coursework.bookshop.user.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

@Log4j2
@Controller
@RequiredArgsConstructor
public class SignUpController {
    private final UserService userService;
    @GetMapping("${app.api.path.user.signup}")
    public ModelAndView showRegistrationForm() {
        ModelAndView modelAndView = new ModelAndView("signup", HttpStatus.OK);
        modelAndView.addObject("user", RegisterUserRequest.builder().role(Role.USER).build());
        return modelAndView;
    }

    @PostMapping("${app.api.path.user.signup}")
    public ModelAndView processRegister(@ModelAttribute @Validated RegisterUserRequest user) {
        boolean success = userService.registerUser(user);
        if (success){
            RedirectView redirectView = new RedirectView("/signin", true);
            return new ModelAndView(redirectView);

        } else{
            return new ModelAndView();
        }
    }
}
