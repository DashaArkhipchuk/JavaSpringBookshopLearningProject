package com.coursework.bookshop.author.request;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UpdateAuthorRequest {
    @NotNull(message = "Id is required")
    @Min(value = 1, message = "Id must be greater than or equal to 1")
    private Integer id;
    @NotBlank(message = "First name cannot be blank")
    private String firstName;

    @NotBlank(message = "Last name cannot be blank")
    private String lastName;

    private String biography;

    @Pattern(regexp = "^\\d{4}\\s*-\\s*\\d{4}$", message = "Activity years must be in the format YYYY-YYYY")
    private String activityYears;
}
