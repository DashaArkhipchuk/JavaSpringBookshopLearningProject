package com.coursework.bookshop.author.mapper;

import com.coursework.bookshop.author.dto.AuthorDto;
import com.coursework.bookshop.author.dto.FullAuthorDto;
import com.coursework.bookshop.author.entity.Author;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class FullAuthorDtoMapper {
    public Author mapFullAuthorDtoToAuthor(FullAuthorDto a) {
        return Author.builder()
                .id(a.getId())
                .firstName(a.getFirstName())
                .lastName(a.getLastName())
                .biography(a.getBiography())
                .activityYears(a.getActivityYears())
                .build();
    }
    public FullAuthorDto mapAuthorToFullAuthorDto(Author a) {
        return FullAuthorDto.builder()
                .id(a.getId())
                .firstName(a.getFirstName())
                .lastName(a.getLastName())
                .biography(a.getBiography())
                .activityYears(a.getActivityYears())
                .build();
    }

    public List<FullAuthorDto> mapAuthorsToFullAuthorDtos(List<Author> addresses) {
        return addresses.stream()
                .map(this::mapAuthorToFullAuthorDto)
                .collect(Collectors.toList());
    }
}
