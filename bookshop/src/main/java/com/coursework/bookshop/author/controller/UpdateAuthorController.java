package com.coursework.bookshop.author.controller;

import com.coursework.bookshop.author.dto.AuthorDto;
import com.coursework.bookshop.author.request.UpdateAuthorRequest;
import com.coursework.bookshop.author.service.AuthorService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Log4j2
@RestController
@RequestMapping("${app.api.path.version.v1}")
@RequiredArgsConstructor
public class UpdateAuthorController {
    private final AuthorService authorService;
    @PostMapping("${app.api.path.author.updateAuthor}")
    public ResponseEntity<AuthorDto> updateAuthor(
            @RequestBody @Validated  UpdateAuthorRequest updateAuthorRequest
    ){
        log.info(updateAuthorRequest);
        AuthorDto book = authorService.updateAuthor(updateAuthorRequest);
        return new ResponseEntity<>(book,HttpStatus.OK);
    }
}
