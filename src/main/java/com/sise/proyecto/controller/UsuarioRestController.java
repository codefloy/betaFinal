package com.sise.proyecto.controller;

import com.sise.proyecto.model.Usuario;
import com.sise.proyecto.servicio.UsuarioService;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@RestController
public class UsuarioRestController {
    
    private UsuarioService usuarioService;
    @Autowired(required = true)
    @Qualifier(value = "usuarioService")

    public void setUsuarioService(UsuarioService ps) {
        this.usuarioService = ps;
    }
    @RequestMapping("/verificar")
    public String verificarEstado() {
        return "Ok";
    }

    
    
    
    
    
    @RequestMapping(value="/rest/usuario/consultar", method = RequestMethod.GET)
    public List<Usuario> getUsuariosDB() {
    List<Usuario> listaRet = new ArrayList<Usuario>();
    listaRet = this.usuarioService.listarUsuarios();
    return listaRet;
    }

    @RequestMapping(value="/rest/usuario/registrar", method = RequestMethod.POST)
    public String addUsuariosDB(@RequestParam("nombres") String name,@RequestParam("fecha")String fecha,  @RequestParam("nusuario") String nusuario,@RequestParam("pass") String pass ) throws ParseException {
    
    DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    Date date = dateFormat.parse(fecha);
       
    Usuario empBean = new Usuario();
    empBean.setNombres(name);
    empBean.setFechaRegistro(date);
    empBean.setNusuario(nusuario);
    empBean.setEstado("Habilitado");
    empBean.setPassword(pass);
    this.usuarioService.addUsuario(empBean);
    return "El usuario fue creado exitosamente";
    }
    
    @RequestMapping(value="/rest/usuario/actualizar", method = RequestMethod.POST)
    public String updateUsuariosDB(@RequestParam("id") int id,@RequestParam("nombres") String name,@RequestParam("fecha")String fecha, @RequestParam("nusuario") String nusuario,@RequestParam("pass") String pass,@RequestParam("estado")String estado ) throws ParseException {
    
    DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    Date date = dateFormat.parse(fecha);
       
    Usuario empBean = new Usuario();
    empBean.setId(id);
    empBean.setNombres(name);
    empBean.setFechaRegistro(date);
    empBean.setNusuario(nusuario);
    empBean.setPassword(pass);
    empBean.setEstado(estado);
    this.usuarioService.updateUsuario(empBean);
    return "Usuario Actualizado";
    }
    
    @RequestMapping(value="/rest/usuario/darBaja", method = RequestMethod.POST)
    public String updateUsuariosDBestado(@RequestParam("id") int id, @RequestParam("estado") String estado ){
    this.usuarioService.updateUsuarioestado(id,estado);
    return "Estado actualizado";
    }
    
    
    
    
    
    
    
    
    @RequestMapping(value="/rest/usuario/consultarusuario", method = RequestMethod.POST)
    public Usuario editUsuariosDB(@RequestParam("id") int id) {
    Usuario nuser = this.usuarioService.listarUsuario(id);
    return nuser;
    }
    
    
    
    
    
    @RequestMapping(value="/rest/autenticate", method = RequestMethod.GET)
    public String validarUsuariosPDB( @RequestParam("nusuario")String nusuario,@RequestParam("pass") String pass ) {
    return  this.usuarioService.validarUsuario(nusuario,pass);
    }

    
}