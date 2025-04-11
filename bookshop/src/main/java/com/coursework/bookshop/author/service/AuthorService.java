package com.coursework.bookshop.author.service;

import com.coursework.bookshop.author.dto.AuthorDto;
import com.coursework.bookshop.author.dto.FullAuthorDto;
import com.coursework.bookshop.author.entity.Author;
import com.coursework.bookshop.author.mapper.AuthorDtoMapper;
import com.coursework.bookshop.author.mapper.AuthorRequestMapper;
import com.coursework.bookshop.author.mapper.FullAuthorDtoMapper;
import com.coursework.bookshop.author.persistence.AuthorRepository;
import com.coursework.bookshop.author.request.CreateAuthorRequest;
import com.coursework.bookshop.author.request.DeleteAuthorRequest;
import com.coursework.bookshop.author.request.UpdateAuthorRequest;
import com.coursework.bookshop.book.dto.BookDto;
import com.coursework.bookshop.book.entity.Book;
import com.coursework.bookshop.book.mapper.BookRequestMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.security.InvalidParameterException;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AuthorService {
    private final AuthorRepository authorRepository;
    private final AuthorDtoMapper authorDtoMapper;
    private final FullAuthorDtoMapper fullAuthorDtoMapper;

    public Author addAuthor(CreateAuthorRequest createAuthorRequest){
        Author author = AuthorRequestMapper.mapAuthorRequestToAuthor(createAuthorRequest);

        return authorRepository.save(author);
    }

    public FullAuthorDto getAuthor(Integer id){
        Optional<Author> byId = authorRepository.findById(id);
        return fullAuthorDtoMapper.mapAuthorToFullAuthorDto(byId.orElseGet(()->Author.builder().build()));

    }

    public List<AuthorDto> getAllAuthorNames(){
        List<Author> b= authorRepository.findAll();
        return authorDtoMapper.maoAuthorsToAuthorDtos(b);
    }


    public Author findExisting(Author build) {
        List<Author> byFirstNameAndLastName = authorRepository.findByFirstNameAndLastName(build.getFirstName(), build.getLastName());
        return byFirstNameAndLastName.stream().findFirst().orElse(build);
    }

    public List<FullAuthorDto> getAllAuthors() {
        List<Author> b= authorRepository.findAll();
        return fullAuthorDtoMapper.mapAuthorsToFullAuthorDtos(b);
    }

    public AuthorDto createAuthor(CreateAuthorRequest createAuthorRequest) {
        Author newAuthor =
                AuthorRequestMapper.mapAuthorRequestToAuthor(createAuthorRequest);
        Author savedBook = authorRepository.save(newAuthor);
        return authorDtoMapper.mapAuthorToAuthorDto(savedBook);
    }

    public AuthorDto updateAuthor(UpdateAuthorRequest updateAuthorRequest) {
        Integer authorId = updateAuthorRequest.getId();
        Optional<Author> optionalAuthor = authorRepository.findById(authorId);

        if (optionalAuthor.isEmpty())
            throw new InvalidParameterException(String.format("Couldn't find author by ID [%d]", authorId));
        Author author = optionalAuthor.get();
        author.setFirstName(updateAuthorRequest.getFirstName());
        author.setLastName(updateAuthorRequest.getLastName());
        author.setBiography(updateAuthorRequest.getBiography());
        author.setActivityYears(updateAuthorRequest.getActivityYears());
        return authorDtoMapper.mapAuthorToAuthorDto(authorRepository.save(author));
    }

    public void deleteAuthorByRequest(DeleteAuthorRequest deleteAuthorRequest) {
        authorRepository.deleteById(deleteAuthorRequest.getId());

    }
}
