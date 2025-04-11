package com.coursework.bookshop.user.request;

import com.coursework.bookshop.user.entity.Role;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class RegisterUserRequest {
    private String email;
    private String password;
    private String confirmPassword;
    private Role role;

}