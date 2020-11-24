package com.formacionbdi.springboot.app.item.service;

import com.formacionbdi.springboot.app.item.models.Item;

import java.util.List;

public interface IItemService {

    List<Item> findAll();
    Item findById(Long id, Integer cantidad);
}
