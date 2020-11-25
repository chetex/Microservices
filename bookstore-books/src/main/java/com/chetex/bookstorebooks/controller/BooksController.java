package com.chetex.bookstorebooks.controller;

import com.chetex.bookstorebooks.models.BookEntity;
import com.chetex.bookstorebooks.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class BooksController {

    @Autowired
    private IBookService iBookService;

    @GetMapping("/findAll")
    public List<BookEntity> findAll() {
        return iBookService.findAll();
    }

    @GetMapping("/findOne")
    public Optional<BookEntity> findOne(@RequestParam Long id) {
        return iBookService.findOne(id);
    }

}
