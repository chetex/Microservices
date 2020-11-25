package com.formacionbdi.springboot.app.item.service;

import com.formacionbdi.springboot.app.item.models.Item;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IItemService {
    List<Item> findAll();
    Item findById(Long id, Integer cantidad);
}
