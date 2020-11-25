package com.formacionbdi.springboot.app.productos.sprinbootservicioproductos.models.service;

import com.formacionbdi.springboot.app.productos.sprinbootservicioproductos.models.entity.IProductoRepository;
import com.formacionbdi.springboot.app.productos.sprinbootservicioproductos.models.entity.Producto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ProductoService implements IProductoService {

    @Autowired
    private IProductoRepository iProductoRepository;

    @Override
    @Transactional(readOnly = true)
    public List<Producto> findAll() {
        return (List<Producto>) iProductoRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Producto findById(Long id) {
        return iProductoRepository.findById(id).orElse(null);
    }
}
