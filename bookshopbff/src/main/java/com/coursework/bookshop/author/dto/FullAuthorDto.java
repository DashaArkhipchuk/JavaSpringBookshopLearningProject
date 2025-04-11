package com.coursework.bookshop.author.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
public class FullAuthorDto {
    private Integer id;
    private String firstName;
    private String lastName;
    private String biography;
    private String activityYears;
}
