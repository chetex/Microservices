package com.formacionbdi.springboot.app.productos.sprinbootservicioproductos.models.dao;

import com.formacionbdi.springboot.app.productos.sprinbootservicioproductos.models.entity.Producto;
import org.springframework.data.repository.CrudRepository;

public interface IProductoDao extends CrudRepository<Producto, Long> {
}
