package com.coursework.bookshop.user.service;

import com.coursework.bookshop.user.entity.Role;
import com.coursework.bookshop.user.entity.User;
import com.coursework.bookshop.user.mapper.UserRequestMapper;
import com.coursework.bookshop.user.persistence.UserRepository;
import com.coursework.bookshop.user.request.RegisterUserRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.jasypt.encryption.pbe.StandardPBEStringEncryptor;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
@Log4j2
@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public User getUser(String email) {
        User u= userRepository.findByEmail(email)
                .orElse(
                        User.builder()
                                .role(Role.UNKNOWN)
                                .build()
                );
        if (u.getRole().equals(Role.UNKNOWN)){
            return u;
        }
        StandardPBEStringEncryptor encryptor = new StandardPBEStringEncryptor();
        encryptor.setPassword(u.getEmail());
        log.info(encryptor.decrypt(u.getPassword()));
        u.setPassword(encryptor.decrypt(u.getPassword()));
        return u;
    }


    public User createUser(RegisterUserRequest user) {
        if (getUser(user.getEmail()).getId()==null) {
            if (user.getPassword().equals(user.getConfirmPassword())) {
                StandardPBEStringEncryptor encryptor = new StandardPBEStringEncryptor();
                encryptor.setPassword(user.getEmail());
                user.setPassword(encryptor.encrypt(user.getPassword()));
                return userRepository.save(UserRequestMapper.mapRegisterUserRequestToUser(user));
            }
        }
        return User.builder().build();
    }

}