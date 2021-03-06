package com.formacionbdi.springboot.app.productos.sprinbootservicioproductos.controller;

import com.formacionbdi.springboot.app.productos.sprinbootservicioproductos.models.entity.Producto;
import com.formacionbdi.springboot.app.productos.sprinbootservicioproductos.models.service.IProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Create restController PRODUCT. It has the interface to connect with JPA data access
 */
@RestController
public class ProductoController {

    @Autowired
    private Environment environment;

    @Value("${server.port}")
    private Integer port;

    @Autowired
    private IProductoService iProductoService;

    @GetMapping("/listProduct")
    public List<Producto> listProduct() {
        return iProductoService.findAll().stream().map(producto -> {
            // producto.setPort(Integer.parseInt(environment.getProperty("local.server.port")));
            producto.setPort(port);
            return producto;
        }).collect(Collectors.toList());
    }

    @GetMapping("/detalleProducto")
    public Producto detalleProducto (@RequestParam Long id) throws Exception {
        Producto producto = iProductoService.findById(id);
        // producto.setPort(Integer.parseInt(environment.getProperty("local.server.port")));
        producto.setPort(port);

        // (1) Podemos simular dormir los procesos
        // Sleep the process
        // En hystric, el timeout es de 1 segundo, por lo que va a ejecutar el fallback method
//        Thread.sleep(2000L);

        // (2) Simulamos un fallo en el proceso
        // Forzamos un fallo
//        boolean ok = false;
//        if (!ok) {
//            throw new Exception("No puedo cargar el producto");
//        }
        return producto;
    }
}
