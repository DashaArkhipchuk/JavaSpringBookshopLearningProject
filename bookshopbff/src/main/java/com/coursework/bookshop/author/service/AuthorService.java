package com.coursework.bookshop.author.service;

import com.coursework.bookshop.author.dto.AuthorDto;
import com.coursework.bookshop.author.dto.FullAuthorDto;
import com.coursework.bookshop.author.entity.Author;
import com.coursework.bookshop.author.request.CreateAuthorRequest;
import com.coursework.bookshop.author.request.DeleteAuthorRequest;
import com.coursework.bookshop.author.request.UpdateAuthorRequest;
import com.coursework.bookshop.bff.feign.BookshopApiClient;
import com.coursework.bookshop.book.dto.BookDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.List;

@Log4j2
@Service
@RequiredArgsConstructor
public class AuthorService {
    private final BookshopApiClient bookshopApiClient;
    public List<FullAuthorDto> getAllAuthors(){
        return bookshopApiClient.getAuthors();
    }

    public FullAuthorDto getAuthor(Integer id) {
        return bookshopApiClient.getAuthor(id);
    }

    public List<AuthorDto> getAllAuthorNames() {
        return bookshopApiClient.getAuthorNames();
    }

    public AuthorDto createAuthor(CreateAuthorRequest createAuthorRequest) { return bookshopApiClient.createAuthor(createAuthorRequest); }

    public AuthorDto updateAuthor(UpdateAuthorRequest updateAuthorRequest) { log.info(updateAuthorRequest); return bookshopApiClient.updateAuthor(updateAuthorRequest); }

    public Author deleteAuthorByRequest(DeleteAuthorRequest deleteAuthorRequest) { bookshopApiClient.deleteBooks(deleteAuthorRequest); return bookshopApiClient.deleteAuthor(deleteAuthorRequest); }
}
