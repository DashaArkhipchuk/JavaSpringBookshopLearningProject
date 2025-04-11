package com.coursework.bookshop.user.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

public enum Role {
    USER,
    ADMIN,
    MANAGER,
    UNKNOWN;

    @Data
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    @Entity
    @Table(name = "users")
    public static class User {

        @Id
        private Integer id;
        private String email;
        private String password;
        @Enumerated(EnumType.STRING)
        private Role role;

    }
}