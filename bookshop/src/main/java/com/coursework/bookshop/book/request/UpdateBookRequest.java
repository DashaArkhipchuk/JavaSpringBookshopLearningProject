package com.coursework.bookshop.book.request;

import jakarta.validation.constraints.*;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@Builder
public class UpdateBookRequest {
    @Min(value = 1, message = "Publish year must be greater than or equal to 1")
    private Integer id;

    @NotBlank(message = "Title cannot be blank")
    private String title;

    @NotNull(message = "Author ID cannot be null")
    private Integer authorId;

    @Min(value = 1000, message = "Publish year must be greater than or equal to 1000")
    @Max(value = 2024, message = "Publish year must be less than or equal to 2024")
    private int publishYear;

    @NotBlank(message = "Genre cannot be blank")
    private String genre;

    @DecimalMin(value = "0.0", message = "Price must be greater than or equal to 0.0")
    private Double price;
}
