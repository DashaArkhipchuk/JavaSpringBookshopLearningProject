package com.coursework.bookshop.user.controller;

import com.coursework.bookshop.user.entity.User;
import com.coursework.bookshop.user.request.RegisterUserRequest;
import com.coursework.bookshop.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("${app.api.path.version.v1}")
public class RegisterUserController {

    private final UserService userService;

    @PostMapping("${app.api.path.user.createUser}")
    public ResponseEntity<Boolean> createUser(
            @RequestBody RegisterUserRequest registerUserRequest
            ) {

        User b=userService.createUser(registerUserRequest);

        if (b.getId()!=null) {
            return new ResponseEntity<>(true, HttpStatus.OK);
        } else{
            return new ResponseEntity<>(false, HttpStatus.OK);
        }
    }

}
