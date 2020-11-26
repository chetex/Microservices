package com.chetex.bookstoreclient.service;

import com.chetex.bookstoreclient.api.IBooksFeign;
import com.chetex.bookstoreclient.models.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service("ClientServiceFeign")
public class ClientServiceFeign implements IClientService {

    @Autowired
    private IBooksFeign iBooksFeign;

    @Override
    public List<Book> findAll() {
        return iBooksFeign.findAll();
    }

    @Override
    public Optional<Book> findOne(Long id) {
        return Optional.of(iBooksFeign.findOne(id).get());
    }
}
