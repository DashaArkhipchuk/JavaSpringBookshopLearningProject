package com.coursework.bookshop.user.controller;


import com.coursework.bookshop.user.entity.User;
import com.coursework.bookshop.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("${app.api.path.version.v1}")
public class GetUserController {

    private final UserService userService;

    @GetMapping("${app.api.path.user.getUser}")
    public ResponseEntity<User> getUserByEmail(
            @RequestParam String email
    ) {

        User user = userService.getUser(email);

        return new ResponseEntity<>(user, HttpStatus.OK);
    }

}