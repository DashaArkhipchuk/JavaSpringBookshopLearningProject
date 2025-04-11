package com.coursework.bookshop.author.mapper;

import com.coursework.bookshop.author.entity.Author;
import com.coursework.bookshop.author.request.CreateAuthorRequest;
import com.coursework.bookshop.author.request.UpdateAuthorRequest;
import com.coursework.bookshop.book.entity.Book;
import com.coursework.bookshop.book.request.UpdateBookRequest;

public class AuthorRequestMapper {
    public static UpdateAuthorRequest mapAuthortoUpdateAuthorRequest(Author b){
        UpdateAuthorRequest request= UpdateAuthorRequest.builder()
                .id(b.getId())
                .firstName(b.getFirstName())
                .lastName(b.getLastName())
                .biography(b.getBiography())
                .activityYears(b.getActivityYears())
                .build();
        return  request;
    }
    public static Author mapAuthorRequestToAuthor(CreateAuthorRequest createAuthorRequest){
        Author author = Author.builder().firstName(createAuthorRequest.getFirstName())
                .lastName(createAuthorRequest.getLastName())
                .biography(createAuthorRequest.getBiography())
                .activityYears(createAuthorRequest.getActivityYears())
                .build();
        return author;
    }

    public static CreateAuthorRequest mapAuthorToAuthorRequest(Author author){
        CreateAuthorRequest request = CreateAuthorRequest.builder().firstName(author.getFirstName())
                .lastName(author.getLastName())
                .biography(author.getBiography())
                .activityYears(author.getActivityYears())
                .build();
        return request;
    }
}
