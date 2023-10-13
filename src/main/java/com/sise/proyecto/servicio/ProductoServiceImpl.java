package com.sise.proyecto.servicio;

import com.sise.proyecto.dao.ProductoDAO;
import com.sise.proyecto.model.Producto;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.stereotype.Service;


@Service
public class ProductoServiceImpl implements ProductoService{
    private ProductoDAO productoDAO;
    
    public void setProductoDAO(ProductoDAO productoDAO) {
    this.productoDAO = productoDAO;
    }
    
    @Override
    @Transactional
    public List<Producto> listarProductos() {
        return this.productoDAO.listarProductos();
    }
    
    @Override
    @Transactional
    public void addProducto(Producto u){
        this.productoDAO.addProducto(u);
    };
    
    @Override
    @Transactional
    public void updateProducto(Producto u){
        this.productoDAO.updateProducto(u);
    };
    
    @Override
    @Transactional
    public int validarProducto(int id){
        return this.productoDAO.validarProducto(id);
    }
}
