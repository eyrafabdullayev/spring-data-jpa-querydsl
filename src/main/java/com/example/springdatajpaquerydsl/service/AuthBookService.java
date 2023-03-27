package com.example.springdatajpaquerydsl.service;

import com.example.springdatajpaquerydsl.dto.AuthorStatistic;
import com.example.springdatajpaquerydsl.entity.Author;
import com.example.springdatajpaquerydsl.entity.Book;
import com.example.springdatajpaquerydsl.repository.AuthorRepository;
import com.example.springdatajpaquerydsl.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AuthBookService {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;

    public List<Author> saveAuthorsWithBooks(List<Author> authors){
        return authorRepository.saveAll(authors);
    }

    public List<Book> getBooks(){
        return bookRepository.findAll();
    }

    public Optional<Author> findAuthorByEmail(String email){
        return authorRepository.findAuthorByEmail(email);
    }

    public List<AuthorStatistic> getAuthorStatistic(){
        return authorRepository.getAuthorStatistic();
    }

    public List<Author> getAuthors(){
        return authorRepository.getAuthors();
    }

}