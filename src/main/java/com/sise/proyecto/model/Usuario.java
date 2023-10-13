package com.sise.proyecto.model;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "USUARIO")
public class Usuario {
    
@Id
@Column(name = "idUsuario")
@GeneratedValue(strategy = GenerationType.IDENTITY)
private int id;
private String nombres;
private Date fechaRegistro;
private String nusuario;
private String password;
private String estado;

    public Usuario() {
    }

    public Usuario(int id, String nombres, Date fechaRegistro, String nusuario, String password, String estado) {
        this.id = id;
        this.nombres = nombres;
        this.fechaRegistro = fechaRegistro;
        this.nusuario = nusuario;
        this.password = password;
        this.estado = estado;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public Date getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(Date fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public String getNusuario() {
        return nusuario;
    }

    public void setNusuario(String nusuario) {
        this.nusuario = nusuario;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }


    
    

    
    
}