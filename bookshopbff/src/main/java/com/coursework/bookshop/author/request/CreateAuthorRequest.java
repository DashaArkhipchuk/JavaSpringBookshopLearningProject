package com.coursework.bookshop.author.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CreateAuthorRequest {
    @NotBlank(message = "First name cannot be blank")
    private String firstName;

    @NotBlank(message = "Last name cannot be blank")
    private String lastName;

    private String biography;

    @Pattern(regexp = "^\\d{4}\\s*-\\s*\\d{4}$", message = "Activity years must be in the format YYYY-YYYY")
    private String activityYears;
}
