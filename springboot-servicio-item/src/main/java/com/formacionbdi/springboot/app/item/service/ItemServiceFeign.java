package com.formacionbdi.springboot.app.item.service;

import com.formacionbdi.springboot.app.item.api.IProductoClienteRest;
import com.formacionbdi.springboot.app.item.models.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service("serviceFeign")
public class ItemServiceFeign implements IItemService {

    @Autowired
    private IProductoClienteRest iProductoClienteRest;

    @Override
    public List<Item> findAll() {
        return iProductoClienteRest.listar().stream().map(producto -> new Item(producto, 1)).collect(Collectors.toList());
    }

    @Override
    public Item findById(Long id, Integer cantidad) {
        return new Item(iProductoClienteRest.detalleProducto(id), cantidad);
    }
}
