package com.sise.proyecto.controller;

import com.sise.proyecto.model.Producto;
import com.sise.proyecto.servicio.ProductoService;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductoRestController {
    
    private ProductoService productoService;
    @Autowired(required = true)
    @Qualifier(value = "productoService")

    public void setProductoService(ProductoService ps) {
        this.productoService = ps;
    }
    

    @RequestMapping(value="/rest/inventario/consultarProducto", method = RequestMethod.GET)
    public List<Producto> getProductosDB() {
    List<Producto> listaRet = new ArrayList<Producto>();
    listaRet = this.productoService.listarProductos();
    return listaRet;
    }

    @RequestMapping(value="/rest/inventario/registrarProducto", method = RequestMethod.POST)
    public String addProductosDB(@RequestParam("descripcion") String descripcion,@RequestParam("precio")double precio,  @RequestParam("cantidad") int cantidad,@RequestParam("fecha") String fecha,@RequestParam("idcate") int idcate ) throws ParseException {
    
    DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    Date date = dateFormat.parse(fecha);
    
    Producto empBean = new Producto();
    empBean.setDescripcion(descripcion);
    empBean.setPrecio(precio);
    empBean.setCantidad(cantidad);
    empBean.setEstado("Habilitado");
    empBean.setFechaRegistro(date);
    empBean.setIdCategoria(idcate);
    this.productoService.addProducto(empBean);
    return "El Producto fue creado exitosamente";
    }
    
    @RequestMapping(value="/rest/inventario/actualizarProducto", method = RequestMethod.POST)
    public String updateProductosDB(@RequestParam("id") int id,@RequestParam("descripcion") String descripcion,@RequestParam("precio")double precio,  @RequestParam("cantidad") int cantidad,@RequestParam("estado") String estado,@RequestParam("fecha") String fecha,@RequestParam("idcate") int idcate ) throws ParseException {
    
    DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    Date date = dateFormat.parse(fecha);
       
    Producto empBean = new Producto();
    empBean.setCodigo(id);
    empBean.setDescripcion(descripcion);
    empBean.setPrecio(precio);
    empBean.setCantidad(cantidad);
    empBean.setEstado(estado);
    empBean.setFechaRegistro(date);
    empBean.setIdCategoria(idcate);
    this.productoService.updateProducto(empBean);
    return "Producto Actualizado";
    }
    
    @RequestMapping(value="/rest/inventario/validarStock", method = RequestMethod.GET)
    public int validarStockDB(@RequestParam("id") int id) {
    int rs = this.productoService.validarProducto(id);
    return rs;
    }
}
