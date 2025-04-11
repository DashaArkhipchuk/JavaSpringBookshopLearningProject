package com.coursework.bookshop.book.service;

import com.coursework.bookshop.author.request.DeleteAuthorRequest;
import com.coursework.bookshop.bff.feign.BookshopApiClient;
import com.coursework.bookshop.book.dto.BookDto;
import com.coursework.bookshop.book.entity.Book;
import com.coursework.bookshop.book.request.CreateBookRequest;
import com.coursework.bookshop.book.request.DeleteBookRequest;
import com.coursework.bookshop.book.request.UpdateBookRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.List;

@Log4j2
@Service
@RequiredArgsConstructor
public class BookService {
    private final BookshopApiClient bookshopApiClient;
    public List<BookDto> getAllBooks(){
        return bookshopApiClient.getBooks();
    }

    public BookDto getBook(Integer id) {
        return bookshopApiClient.getBook(id);
    }

    public BookDto createBook(CreateBookRequest createBookRequest) {
        return bookshopApiClient.createBook(createBookRequest);
    }

    public BookDto updateBook(UpdateBookRequest updateBookRequest) {
        return bookshopApiClient.updateBook(updateBookRequest);
    }

    public Book deleteBookByRequest(DeleteBookRequest request) {
        return bookshopApiClient.deleteBook(request);
    }

    public Book deleteBooksByAuthorId(DeleteAuthorRequest request){
        return bookshopApiClient.deleteBooks(request);
    }
}
