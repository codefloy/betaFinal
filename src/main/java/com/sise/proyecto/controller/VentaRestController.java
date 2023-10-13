package com.sise.proyecto.controller;

import com.sise.proyecto.model.Venta;
import com.sise.proyecto.servicio.VentaService;
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
public class VentaRestController {
    
    private VentaService ventaService;
    @Autowired(required = true)
    @Qualifier(value = "ventaService")

    public void setVentaService(VentaService ps) {
        this.ventaService = ps;
    }
    

    @RequestMapping(value="/rest/compras/consultar", method = RequestMethod.GET)
    public List<Venta> getVentasDB() {
    List<Venta> listaRet = new ArrayList<Venta>();
    listaRet = this.ventaService.listarVentas();
    return listaRet;
    }

//    @RequestMapping(value="/rest/inventario/registrarProducto", method = RequestMethod.POST)
//    public String addProductosDB(@RequestParam("descripcion") String descripcion,@RequestParam("precio")double precio,  @RequestParam("cantidad") int cantidad,@RequestParam("fecha") String fecha,@RequestParam("idcate") int idcate ) throws ParseException {
//    
//    DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
//    Date date = dateFormat.parse(fecha);
//       
//    Producto empBean = new Producto();
//    empBean.setDescripcion(descripcion);
//    empBean.setPrecio(precio);
//    empBean.setCantidad(cantidad);
//    empBean.setEstado("Habilitado");
//    empBean.setFechaRegistro(date);
//    empBean.setIdCategoria(idcate);
//    this.productoService.addProducto(empBean);
//    return "El Producto fue creado exitosamente";
//    }
   
}
