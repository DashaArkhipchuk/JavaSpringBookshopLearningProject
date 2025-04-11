package com.coursework.bookshop.book.request;

import jakarta.validation.constraints.Min;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class DeleteBookRequest {
    @Min(value = 1, message = "Publish year must be greater than or equal to 1")
    private Integer id;

}
