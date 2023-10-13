
package com.sise.proyecto.dao;

import com.sise.proyecto.model.Producto;
import java.util.List;


public interface ProductoDAO {
    
    public List<Producto> listarProductos();
    public void addProducto(Producto u);
    public void updateProducto(Producto p);
    public int validarProducto(int id);
    
}
