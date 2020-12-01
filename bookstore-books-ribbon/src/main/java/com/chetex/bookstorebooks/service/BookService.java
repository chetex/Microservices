package com.chetex.bookstorebooks.service;

import com.chetex.bookstorebooks.models.BookEntity;
import com.chetex.bookstorebooks.models.BookEntityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.awt.print.Book;
import java.util.List;
import java.util.Optional;

@Service
public class BookService implements IBookService {

    @Value("${server.port}")
    private Integer port;

    @Autowired
    private BookEntityRepository bookEntityRepository;

    @Override
    public List<BookEntity> findAll() {
        List<BookEntity> bookEntityList = (List<BookEntity>) bookEntityRepository.findAll();
        BookEntity bookEntity = new BookEntity();
        bookEntity.setPrice(port.toString());
        bookEntityList.add(bookEntity);
        return bookEntityList;
    }

    @Override
    public Optional<BookEntity> findOne(Long id) {
        return bookEntityRepository.findById(id);
    }
}
