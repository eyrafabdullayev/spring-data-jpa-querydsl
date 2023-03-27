package com.example.springdatajpaquerydsl.repository;

import com.example.springdatajpaquerydsl.dto.AuthorStatistic;
import com.example.springdatajpaquerydsl.entity.Author;

import java.util.List;
import java.util.Optional;

public interface AuthorRepository extends BaseRepository<Author, Long> {

    Optional<Author> findAuthorByEmail(String email);
    List<AuthorStatistic> getAuthorStatistic();
    List<Author> getAuthors();
}
