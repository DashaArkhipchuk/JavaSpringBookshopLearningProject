package com.coursework.bookshop.user.mapper;

import com.coursework.bookshop.author.entity.Author;
import com.coursework.bookshop.author.mapper.AuthorRequestMapper;
import com.coursework.bookshop.book.entity.Book;
import com.coursework.bookshop.book.request.CreateBookRequest;
import com.coursework.bookshop.user.entity.User;
import com.coursework.bookshop.user.request.RegisterUserRequest;

public class UserRequestMapper {
    public static User mapRegisterUserRequestToUser(RegisterUserRequest registerUserRequest){
        User build = User.builder().role(registerUserRequest.getRole())
                .email(registerUserRequest.getEmail())
                .password(registerUserRequest.getPassword())
                .build();

        return build;
    }
}
