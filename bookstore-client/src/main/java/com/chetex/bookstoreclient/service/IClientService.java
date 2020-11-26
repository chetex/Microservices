package com.chetex.bookstoreclient.service;

import com.chetex.bookstoreclient.models.Book;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface IClientService {
    List<Book> findAll();
    Optional<Book> findOne(Long id);
}
