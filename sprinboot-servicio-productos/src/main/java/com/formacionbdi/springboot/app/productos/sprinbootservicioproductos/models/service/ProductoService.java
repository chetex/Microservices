package com.formacionbdi.springboot.app.productos.sprinbootservicioproductos.models.service;

import com.formacionbdi.springboot.app.productos.sprinbootservicioproductos.models.dao.IProductoDao;
import com.formacionbdi.springboot.app.productos.sprinbootservicioproductos.models.entity.Producto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ProductoService implements IProductoService {

    @Autowired
    private IProductoDao iProductoDao;

    @Override
    @Transactional(readOnly = true)
    public List<Producto> findAll() {
        return (List<Producto>) iProductoDao.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Producto findById(Long id) {
        return iProductoDao.findById(id).orElse(null);
    }
}
