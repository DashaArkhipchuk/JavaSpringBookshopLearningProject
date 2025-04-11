package com.coursework.bookshop.user.service;

import com.coursework.bookshop.bff.feign.BookshopApiClient;
import com.coursework.bookshop.user.entity.User;
import com.coursework.bookshop.user.request.RegisterUserRequest;
import lombok.RequiredArgsConstructor;
import org.jasypt.encryption.pbe.StandardPBEStringEncryptor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {
    private final BookshopApiClient bookshopApiClient;

    @Value("${security.app.authentication.cookie}")
    private String USER_COOKIE_CREDENTIALS;


    public User getUser(String username) {
        return bookshopApiClient.getUserByEmail(username);
    }

    public boolean registerUser(RegisterUserRequest user) {
        if (getUser(user.getEmail()).getId()==null){
            if (user.getPassword().equals(user.getConfirmPassword())){
                StandardPBEStringEncryptor encryptor = new StandardPBEStringEncryptor();
                encryptor.setPassword(USER_COOKIE_CREDENTIALS);
                user.setPassword(encryptor.encrypt(user.getPassword()));
                return bookshopApiClient.createUser(user);
            }
        }
        return false;
    }
}
