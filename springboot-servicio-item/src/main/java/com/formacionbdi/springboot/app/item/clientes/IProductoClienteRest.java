package com.formacionbdi.springboot.app.item.clientes;

import com.formacionbdi.springboot.app.item.models.Producto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * We create here a new interface with Feign library. This library allow us
 * connect with Product microservice given "application.properties" name and
 * the "url"
 */
@FeignClient(name = "servicio-productos")
public interface IProductoClienteRest {

    @GetMapping("/listProduct")
    List<Producto> listar();

    @GetMapping("/detalleProducto")
    Producto detalleProducto (@RequestParam Long id);
}
