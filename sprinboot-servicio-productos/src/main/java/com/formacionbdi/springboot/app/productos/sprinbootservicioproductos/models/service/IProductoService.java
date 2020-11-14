package com.formacionbdi.springboot.app.productos.sprinbootservicioproductos.models.service;

import com.formacionbdi.springboot.app.productos.sprinbootservicioproductos.models.entity.Producto;

import java.util.List;

public interface IProductoService {

    public List<Producto> findAll();
    public Producto findById(Long id);

}
