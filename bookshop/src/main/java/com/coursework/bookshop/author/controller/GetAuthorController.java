package com.coursework.bookshop.author.controller;

import com.coursework.bookshop.author.dto.AuthorDto;
import com.coursework.bookshop.author.dto.FullAuthorDto;
import com.coursework.bookshop.author.service.AuthorService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Log4j2
@RestController
@RequestMapping("${app.api.path.version.v1}")
@RequiredArgsConstructor
public class GetAuthorController {
    private final AuthorService addressService;

    @GetMapping("${app.api.path.author.getAuthor}")
    public ResponseEntity<FullAuthorDto> getAuthor(
            @RequestParam Integer id
    ) {
        FullAuthorDto author = addressService.getAuthor(id);
        return new ResponseEntity<>(author, HttpStatus.OK);
    }
}
