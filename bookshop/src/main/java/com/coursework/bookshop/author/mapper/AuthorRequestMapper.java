package com.coursework.bookshop.author.mapper;

import com.coursework.bookshop.author.entity.Author;
import com.coursework.bookshop.author.request.CreateAuthorRequest;

public class AuthorRequestMapper {
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
