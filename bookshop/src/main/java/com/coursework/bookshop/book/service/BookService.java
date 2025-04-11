package com.coursework.bookshop.book.service;

import com.coursework.bookshop.author.dto.AuthorDto;
import com.coursework.bookshop.author.entity.Author;
import com.coursework.bookshop.author.mapper.AuthorRequestMapper;
import com.coursework.bookshop.author.mapper.FullAuthorDtoMapper;
import com.coursework.bookshop.author.persistence.AuthorRepository;
import com.coursework.bookshop.author.request.DeleteAuthorRequest;
import com.coursework.bookshop.author.service.AuthorService;
import com.coursework.bookshop.book.dto.BookDto;
import com.coursework.bookshop.book.entity.Book;
import com.coursework.bookshop.book.mapper.BookDtoMapper;
import com.coursework.bookshop.book.mapper.BookRequestMapper;
import com.coursework.bookshop.book.persistence.BookRepository;
import com.coursework.bookshop.book.request.CreateBookRequest;
import com.coursework.bookshop.book.request.DeleteBookRequest;
import com.coursework.bookshop.book.request.UpdateBookRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.security.InvalidParameterException;
import java.util.List;
import java.util.Optional;

@Log4j2
@Service
@RequiredArgsConstructor
public class BookService {
    private final BookRepository bookRepository;
    private final AuthorService authorService;
    private final BookDtoMapper bookDtoMapper;
    private final FullAuthorDtoMapper fullAuthorDtoMapper;


    public BookDto getBook(Integer id){
        log.info("Book service Invoked");
        Optional<Book> book = bookRepository.findById(id);
        return bookDtoMapper.mapBookToBookDto(book.orElseGet(() -> Book.builder().build()));
    }

    public List<BookDto> getAllBooks(){
        List<Book> b= bookRepository.findAll();
        return bookDtoMapper.mapBooksToBookDtos(b);
    }

    public boolean deleteBooksByAuthorsId(DeleteAuthorRequest request){
        try{
            List<Book> booksByAuthorsId = bookRepository.getBooksByAuthorsId(request.getId());
            for(Book book:booksByAuthorsId){
                deleteBookByRequest(DeleteBookRequest.builder().id(book.getId()).build());
            }
        } catch(Exception exception) {
            return false;
        }
        return true;
    }

    public BookDto createBook(CreateBookRequest createBookRequest){
//        Author build = AuthorRequestMapper.mapAuthorRequestToAuthor(createBookRequest.getAuthor());
////        List<Author> byFirstNameAndLastName = authorRepository.findByFirstNameAndLastName(createBookRequest.getAuthor().getFirstName(), createBookRequest.getAuthor().getLastName());
//        AuthorDto existing = authorService.findExisting(build);
//
//
//        log.info(createBookRequest);

//        Book book = Book.builder()
//                .title(createBookRequest.getTitle())
//                .author(existing).publishYear(createBookRequest.getPublishYear())
//                .genre(createBookRequest.getGenre())
//                .price(createBookRequest.getPrice())
//                .build();
//        return bookDtoMapper.mapBookToBookDto(bookRepository.save(book));

        log.info(createBookRequest);

        Author author = AuthorRequestMapper
                .mapAuthorRequestToAuthor(createBookRequest.getAuthor());
        author = authorService.findExisting(author);
        Book newBook =
                BookRequestMapper.mapCreateBookRequestToBook(createBookRequest, author);
        log.info(newBook.getPublishYear());
        Book savedBook = bookRepository.save(newBook);
        return bookDtoMapper.mapBookToBookDto(savedBook);


    }
    public void deleteBookByRequest(DeleteBookRequest request){
        bookRepository.deleteById(request.getId());
    }


    public BookDto updateBook(UpdateBookRequest updateBookRequest) {
        Integer bookId = updateBookRequest.getId();
        Optional<Book> optBook = bookRepository.findById(bookId);

        if (optBook.isEmpty())
            throw new InvalidParameterException(String.format("Couldn't find book by ID [%d]", bookId));
        Author author = fullAuthorDtoMapper.mapFullAuthorDtoToAuthor(authorService.getAuthor(updateBookRequest.getAuthorId()));
        if (author.getId()==null)
            throw new InvalidParameterException(String.format("Couldn't find author by ID [%d]", updateBookRequest.getAuthorId()));
        Book book = optBook.get();
        book.setAuthor(author);
        book.setTitle(updateBookRequest.getTitle());
        book.setGenre(updateBookRequest.getGenre());
        book.setPublishYear(updateBookRequest.getPublishYear());
        book.setPrice(updateBookRequest.getPrice());
        return bookDtoMapper.mapBookToBookDto(bookRepository.save(book));

    }
}
