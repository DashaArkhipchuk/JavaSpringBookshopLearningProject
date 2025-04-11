package com.coursework.bookshop.author.mapper;

import com.coursework.bookshop.author.dto.AuthorDto;
import com.coursework.bookshop.author.entity.Author;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class AuthorDtoMapper {
    public AuthorDto mapAuthorToAuthorDto(Author a) {
        return AuthorDto.builder()
                .id(a.getId())
                .firstName(a.getFirstName())
                .lastName(a.getLastName())
                .build();
    }

    public List<AuthorDto> maoAuthorsToAuthorDtos(List<Author> addresses) {
        return addresses.stream()
                .map(this::mapAuthorToAuthorDto)
                .collect(Collectors.toList());
    }
}
