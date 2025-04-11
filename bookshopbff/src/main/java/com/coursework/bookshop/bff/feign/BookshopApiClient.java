package com.coursework.bookshop.bff.feign;

import com.coursework.bookshop.author.dto.AuthorDto;
import com.coursework.bookshop.author.dto.FullAuthorDto;
import com.coursework.bookshop.author.entity.Author;
import com.coursework.bookshop.author.request.CreateAuthorRequest;
import com.coursework.bookshop.author.request.DeleteAuthorRequest;
import com.coursework.bookshop.author.request.UpdateAuthorRequest;
import com.coursework.bookshop.book.dto.BookDto;
import com.coursework.bookshop.book.entity.Book;
import com.coursework.bookshop.book.request.CreateBookRequest;
import com.coursework.bookshop.book.request.DeleteBookRequest;
import com.coursework.bookshop.book.request.UpdateBookRequest;
import com.coursework.bookshop.user.entity.User;
import com.coursework.bookshop.user.request.RegisterUserRequest;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient("BOOKSHOP")
public interface BookshopApiClient {

    @GetMapping("${app.api.version.bookshop}${app.api.path.book.getBooks}")
    List<BookDto> getBooks();

    @GetMapping("${app.api.version.bookshop}${app.api.path.user.getUser}")
    User getUserByEmail(@RequestParam String email);

    @GetMapping("${app.api.version.bookshop}${app.api.path.author.getAuthors}")
    public List<FullAuthorDto> getAuthors();

    @GetMapping("${app.api.version.bookshop}${app.api.path.book.getBook}")
    public BookDto getBook(
            @RequestParam Integer id
    );

    @GetMapping("${app.api.version.bookshop}${app.api.path.author.getAuthor}")
    public FullAuthorDto getAuthor(
            @RequestParam Integer id
    );

    @GetMapping("${app.api.version.bookshop}${app.api.path.author.getAuthorNames}")
    public List<AuthorDto> getAuthorNames();

    @PostMapping("${app.api.version.bookshop}${app.api.path.book.createBook}")
    public BookDto createBook(
            @RequestBody CreateBookRequest createBookRequest
    );

    @PostMapping("${app.api.version.bookshop}${app.api.path.book.updateBook}")
    public BookDto updateBook(
            @RequestBody UpdateBookRequest updateBookRequest
    );

    @DeleteMapping("${app.api.version.bookshop}${app.api.path.book.deleteBook}")
    public Book deleteBook(
            @RequestBody DeleteBookRequest deleteBookRequest
    );

    @PostMapping("${app.api.version.bookshop}${app.api.path.author.createAuthor}")
    public AuthorDto createAuthor(
            @RequestBody CreateAuthorRequest createAuthorRequest
    );

    @PostMapping("${app.api.version.bookshop}${app.api.path.author.updateAuthor}")
    public AuthorDto updateAuthor(
            @RequestBody UpdateAuthorRequest updateAuthorRequest
    );

    @DeleteMapping("${app.api.version.bookshop}${app.api.path.author.deleteAuthor}")
    public Author deleteAuthor(
            @RequestBody DeleteAuthorRequest deleteAuthorRequest
    );

    @DeleteMapping("${app.api.version.bookshop}${app.api.path.book.deleteBooks}")
    public Book deleteBooks(
            @RequestBody DeleteAuthorRequest deleteAuthorRequest
    );

    @PostMapping("${app.api.version.bookshop}${app.api.path.user.createUser}")
    public Boolean createUser(
            @RequestBody RegisterUserRequest registerUserRequest
    );
}
