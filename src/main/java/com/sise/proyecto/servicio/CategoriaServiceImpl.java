
package com.sise.proyecto.servicio;

import com.sise.proyecto.dao.CategoriaDAO;
import com.sise.proyecto.model.Categoria;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
public class CategoriaServiceImpl implements CategoriaService{
     private CategoriaDAO categoriaDAO;
    
    public void setCategoriaDAO(CategoriaDAO categoriaDAO) {
    this.categoriaDAO = categoriaDAO;
    }
    
    @Override
    @Transactional
    public List<Categoria> listarCategorias() {
        return this.categoriaDAO.listarCategorias();
    }
    
    @Override
    @Transactional
    public void addCategoria(Categoria u){
        this.categoriaDAO.addCategoria(u);
    };
    
    @Override
    @Transactional
    public void updateCategoria(Categoria u){
        this.categoriaDAO.updateCategoria(u);
    };
}
