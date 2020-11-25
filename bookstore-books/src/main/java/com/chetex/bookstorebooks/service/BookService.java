package com.chetex.bookstorebooks.service;

import com.chetex.bookstorebooks.models.BookEntity;
import com.chetex.bookstorebooks.models.BookEntityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService implements IBookService {

    @Autowired
    private BookEntityRepository bookEntityRepository;

    @Override
    public List<BookEntity> findAll() {
        return (List<BookEntity>) bookEntityRepository.findAll();
    }

    @Override
    public Optional<BookEntity> findOne(Long id) {
        return bookEntityRepository.findById(id);
    }
}
