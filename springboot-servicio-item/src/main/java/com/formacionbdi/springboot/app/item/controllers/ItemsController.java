package com.formacionbdi.springboot.app.item.controllers;

import com.formacionbdi.springboot.app.item.models.Item;
import com.formacionbdi.springboot.app.item.service.IItemService;
import com.formacionbdi.springboot.app.item.service.ItemServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ItemsController {

    @Autowired
    @Qualifier("serviceFeign")
    private IItemService itemServiceImpl;

    @GetMapping("/listItems")
    public List<Item> listItems() {
        return itemServiceImpl.findAll();
    }

    @GetMapping("/detalle")
    public Item detalle(@RequestParam Long id, @RequestParam Integer cantidad) {
        return itemServiceImpl.findById(id, cantidad);
    }
}
