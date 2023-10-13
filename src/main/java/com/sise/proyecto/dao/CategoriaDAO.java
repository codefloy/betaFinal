
package com.sise.proyecto.dao;
import com.sise.proyecto.model.Categoria;
import java.util.List;

public interface CategoriaDAO {
    public List<Categoria> listarCategorias();
    public void addCategoria(Categoria u);
    public void updateCategoria(Categoria u);
}
