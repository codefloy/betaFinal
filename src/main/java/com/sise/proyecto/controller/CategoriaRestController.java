
package com.sise.proyecto.controller;

import com.sise.proyecto.model.Categoria;
import com.sise.proyecto.servicio.CategoriaService;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CategoriaRestController {
     private CategoriaService categoriaService;
    @Autowired(required = true)
    @Qualifier(value = "categoriaService")

    public void setCategoriaService(CategoriaService ps) {
        this.categoriaService = ps;
    }
    
    @RequestMapping(value="/rest/inventario/consultarCategoria", method = RequestMethod.GET)
    public List<Categoria> getCategoriasDB() {
    List<Categoria> listaRet = new ArrayList<Categoria>();
    listaRet = this.categoriaService.listarCategorias();
    return listaRet;
    }

    @RequestMapping(value="/rest/inventario/registrarCategoria", method = RequestMethod.POST)
    public String addCategoriasDB(@RequestParam("descripcion") String descripcion,@RequestParam("fecha") String fecha ) throws ParseException {
    
    DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    Date date = dateFormat.parse(fecha);
       
    Categoria empBean = new Categoria();
    empBean.setDescripcion(descripcion);
    empBean.setFechaRegistro(date);
    empBean.setEstado("Habilitado");
    this.categoriaService.addCategoria(empBean);
    return "La Categoría fue creado exitosamente";
    }
    
    @RequestMapping(value="/rest/inventario/actualizarCategoria", method = RequestMethod.POST)
    public String updateCategoriasDB(@RequestParam("id") int id,@RequestParam("descripcion") String descripcion,@RequestParam("fecha") String fecha,@RequestParam("estado") String estado  ) throws ParseException {
    
    DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    Date date = dateFormat.parse(fecha);
       
    Categoria empBean = new Categoria();
    empBean.setIdCategoria(id);
    empBean.setDescripcion(descripcion);
    empBean.setFechaRegistro(date);
    empBean.setEstado(estado);
    this.categoriaService.updateCategoria(empBean);
    return "Categoría Actualizada";
    }
}
