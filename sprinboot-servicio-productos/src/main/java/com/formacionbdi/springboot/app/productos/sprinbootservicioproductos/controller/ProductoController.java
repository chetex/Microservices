package com.formacionbdi.springboot.app.productos.sprinbootservicioproductos.controller;

import com.formacionbdi.springboot.app.productos.sprinbootservicioproductos.models.entity.Producto;
import com.formacionbdi.springboot.app.productos.sprinbootservicioproductos.models.service.IProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Create restController PRODUCT. It has the interface to connect with JPA data access
 */
@RestController
public class ProductoController {

    @Autowired
    private IProductoService iProductoService;

    @GetMapping("/listProduct")
    public List<Producto> listProduct() {
        return iProductoService.findAll();
    }

    @GetMapping("/detalleProducto")
    public Producto detalleProducto (@RequestParam Long id) {
        return iProductoService.findById(id);
    }
}
