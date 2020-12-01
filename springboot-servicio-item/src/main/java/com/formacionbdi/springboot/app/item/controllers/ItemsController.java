package com.formacionbdi.springboot.app.item.controllers;

import com.formacionbdi.springboot.app.item.models.Item;
import com.formacionbdi.springboot.app.item.models.Producto;
import com.formacionbdi.springboot.app.item.service.IItemService;
import com.formacionbdi.springboot.app.item.service.ItemServiceImpl;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
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
    @Qualifier("serviceFeign") // Aqui le indicamos si queremos conectarnos al otro microservicio por Feign, o por RestTemplate.
    private IItemService itemServiceImpl;

    @GetMapping("/listItems")
    public List<Item> listItems() {
        return itemServiceImpl.findAll();
    }

    @HystrixCommand(fallbackMethod = "alternativeMethod")
    @GetMapping("/detalle")
    public Item detalle(@RequestParam Long id, @RequestParam Integer cantidad) {
        return itemServiceImpl.findById(id, cantidad);
    }

    /**
     * Create new alternative method if hystic found error.
     *
     * @param id
     * @param cantidad
     * @return
     */
    public Item alternativeMethod(Long id, Integer cantidad) {
        Item item = new Item();
        try {
            Producto producto = new Producto();

            item.setCantidad(cantidad);
            producto.setId(id);
            producto.setNombre("Metodo alternativo");
            producto.setPrecio(500.00);

            item.setProducto(producto);
        } catch(Exception e) {
            e.printStackTrace();
        }
        return item;
    }
}
