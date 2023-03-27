package com.example.springdatajpaquerydsl.repository.impl;

import com.example.springdatajpaquerydsl.entity.QAuthor;
import com.example.springdatajpaquerydsl.entity.QBook;
import com.example.springdatajpaquerydsl.repository.BaseRepository;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;

import javax.persistence.EntityManager;

public class BaseRepositoryImpl<T, ID> extends SimpleJpaRepository<T, ID> implements BaseRepository<T, ID> {

    EntityManager em;
    protected final JPAQueryFactory jpaQueryFactory;

    protected final QAuthor author = QAuthor.author;
    protected final QBook book = QBook.book;


    public BaseRepositoryImpl(Class<T> domainClass, EntityManager em) {
        super(domainClass, em);
        this.em = em;
        jpaQueryFactory = new JPAQueryFactory(em);
    }

    @Override
    public T findByIdMandatory(ID id) throws IllegalArgumentException {
        return findById(id).orElseThrow(()->new IllegalArgumentException("entity not found with id "+id));
    }
}
