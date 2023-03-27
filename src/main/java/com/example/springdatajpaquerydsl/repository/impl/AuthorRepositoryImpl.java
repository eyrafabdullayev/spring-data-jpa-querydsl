package com.example.springdatajpaquerydsl.repository.impl;

import com.example.springdatajpaquerydsl.dto.AuthorStatistic;
import com.example.springdatajpaquerydsl.entity.Author;
import com.example.springdatajpaquerydsl.repository.AuthorRepository;
import com.querydsl.core.types.Projections;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;

public class AuthorRepositoryImpl extends BaseRepositoryImpl<Author, Long> implements AuthorRepository {

    public AuthorRepositoryImpl(EntityManager em) {
        super(Author.class, em);
    }

    @Override
    public Optional<Author> findAuthorByEmail(String email) {
        return Optional.ofNullable(
                jpaQueryFactory.select(author)
                        .from(author)
                        .where(author.email.isNotNull().and(author.email.equalsIgnoreCase(email)))
                        .fetchFirst());
    }

    @Override
    public List<AuthorStatistic> getAuthorStatistic() {
        return jpaQueryFactory.select(Projections.constructor(AuthorStatistic.class, author.name, book.count()))
                .from(author)
                .innerJoin(author.books, book)
                .groupBy(author.name)
                .fetch();

    }

    @Override
    public List<Author> getAuthors() {
        return jpaQueryFactory.select(author)
                .distinct()
                .from(author)
                .innerJoin(author.books, book)
                .fetchJoin()
                .fetch();
    }
}
