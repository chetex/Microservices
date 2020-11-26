package com.chetex.bookstoreclient.controller;

import com.chetex.bookstoreclient.models.Book;
import com.chetex.bookstoreclient.service.IClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class ClientController {

    @Autowired
    @Qualifier("ClientServiceRestTemplate")
    private IClientService iClientService;

    @GetMapping("/findAll")
    public List<Book> findAll() {
        return iClientService.findAll();
    }

    @GetMapping("/findOne")
    public Optional<Book> findOne(@RequestParam Long id) {
        return iClientService.findOne(id);
    }

}
