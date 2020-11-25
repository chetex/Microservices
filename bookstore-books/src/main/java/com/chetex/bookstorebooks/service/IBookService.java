package com.chetex.bookstorebooks.service;

import com.chetex.bookstorebooks.models.BookEntity;

import java.util.List;
import java.util.Optional;

public interface IBookService {
    public List<BookEntity> findAll();
    public Optional<BookEntity> findOne(Long id);
}
