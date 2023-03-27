package com.example.springdatajpaquerydsl.controller;

import com.example.springdatajpaquerydsl.dto.AuthorStatistic;
import com.example.springdatajpaquerydsl.entity.Author;
import com.example.springdatajpaquerydsl.entity.Book;
import com.example.springdatajpaquerydsl.service.AuthBookService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/authors")
@RequiredArgsConstructor
public class AuthBookController {

    private final AuthBookService authBookService;


    @PostMapping
    public List<Author> saveAuthorsWithBooks(@RequestBody List<Author> authors) {
        return authBookService.saveAuthorsWithBooks(authors);
    }

    @GetMapping
    public List<Author> getAllAuthors() {
        return authBookService.getAuthors();
    }

    @GetMapping("/books")
    public List<Book> getAllBooks() {
        return authBookService.getBooks();
    }

    @GetMapping("/author/{email}")
    public Optional<Author> findAuthorByEmail(@PathVariable String email) {
        return authBookService.findAuthorByEmail(email);
    }

    @GetMapping("/authorStatistic")
    public List<AuthorStatistic> getAuthorStatistic() {
        return authBookService.getAuthorStatistic();
    }
}