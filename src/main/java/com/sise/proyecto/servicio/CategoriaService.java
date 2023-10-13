
package com.sise.proyecto.servicio;

import com.sise.proyecto.model.Categoria;
import java.util.List;


public interface CategoriaService {
    public List<Categoria> listarCategorias();
    public void addCategoria(Categoria u);
    public void updateCategoria(Categoria u);
}
