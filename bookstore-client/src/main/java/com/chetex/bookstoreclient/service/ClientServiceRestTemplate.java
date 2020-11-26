package com.chetex.bookstoreclient.service;

import com.chetex.bookstoreclient.models.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service("ClientServiceRestTemplate")
public class ClientServiceRestTemplate implements IClientService {

    @Autowired
    private RestTemplate restTemplate;

    /**
     * Using getForObject method in restTemplate.
     *
     * @return List<Book>
     */
    @Override
    public List<Book> findAll() {
        return Arrays.asList(restTemplate.getForObject("http://bookstore-books/findAll", Book[].class));
    }

    /**
     * Using getForObject method in restTemplate.
     *
     * @param id Long Id to search in books microservices.
     * @return List<Book>
     */
    @Override
    public Optional<Book> findOne(Long id) {
        return Optional.of(restTemplate.getForObject("http://bookstore-books/findOne?id=" + id, Book.class));
    }
}
