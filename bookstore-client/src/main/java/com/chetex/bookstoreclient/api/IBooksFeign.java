package com.chetex.bookstoreclient.api;

import com.chetex.bookstoreclient.models.Book;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

@FeignClient(name = "bookstore-books")
public interface IBooksFeign {

    @GetMapping("/findAll")
    List<Book> findAll();

    @GetMapping("/findOne")
    Optional<Book> findOne(@RequestParam Long id);
}
