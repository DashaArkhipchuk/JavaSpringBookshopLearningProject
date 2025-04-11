package com.coursework.bookshop.author.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class FullAuthorDto {
    private Integer id;
    private String firstName;
    private String lastName;
    private String biography;
    private String activityYears;
}
