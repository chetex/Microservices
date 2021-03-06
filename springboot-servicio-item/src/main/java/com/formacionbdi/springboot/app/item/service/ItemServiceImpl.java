package com.formacionbdi.springboot.app.item.service;

import com.formacionbdi.springboot.app.item.models.Item;
import com.formacionbdi.springboot.app.item.models.Producto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service("serviceRestTemplate")
@Primary // With it we said that now we are using Feign clients
public class ItemServiceImpl implements IItemService {

    @Autowired
    public RestTemplate restTemplate;

    @Override
    public List<Item> findAll() {
        // List<Producto> productoList = Arrays.asList(restTemplate.getForObject("http://localhost:8001/listProduct", Producto[].class));
        List<Producto> productoList = Arrays.asList(restTemplate.getForObject("http://servicio-productos/listProduct", Producto[].class)); // @RibbonClient(name = "servicio-productos")
        return productoList.stream().map(producto -> new Item(producto, 1)).collect(Collectors.toList());
    }

    @Override
    public Item findById(Long id, Integer cantidad) {
        // Producto producto = restTemplate.getForObject("http://localhost:8001/detalleProducto?id=" + id, Producto.class);
        Producto producto = restTemplate.getForObject("http://servicio-productos/detalleProducto?id=" + id, Producto.class); // @RibbonClient(name = "servicio-productos")
        return new Item(producto, cantidad);
    }
}
