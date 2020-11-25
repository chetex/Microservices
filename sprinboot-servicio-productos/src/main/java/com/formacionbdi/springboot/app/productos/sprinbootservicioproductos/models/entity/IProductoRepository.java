package com.formacionbdi.springboot.app.productos.sprinbootservicioproductos.models.entity;

import com.formacionbdi.springboot.app.productos.sprinbootservicioproductos.models.entity.Producto;
import org.springframework.data.repository.CrudRepository;

public interface IProductoRepository extends CrudRepository<Producto, Long> {
}
