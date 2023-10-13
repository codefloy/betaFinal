
package com.sise.proyecto.servicio;

import com.sise.proyecto.model.Producto;
import java.util.List;


public interface ProductoService {
    
    public List<Producto> listarProductos();
    public void addProducto(Producto p);
    public void updateProducto(Producto p);
    public int validarProducto(int id);

}