package com.formacionbdi.springboot.app.productos.sprinbootservicioproductos.controller;

import com.formacionbdi.springboot.app.productos.sprinbootservicioproductos.models.entity.Producto;
import com.formacionbdi.springboot.app.productos.sprinbootservicioproductos.models.service.IProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProductoController {

    @Autowired
    private IProductoService iProductoService;

    @GetMapping("/listProduct")
    public List<Producto> listProduct() {
        return iProductoService.findAll();
    }

    @GetMapping("/listProduct")
    public Producto detalleProducto (@RequestParam Long id) {
        return iProductoService.findById(id);
    }
}
