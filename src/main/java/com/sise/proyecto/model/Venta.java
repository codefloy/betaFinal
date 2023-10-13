
package com.sise.proyecto.model;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "venta")
public class Venta {
    
@Id
@Column(name = "idVenta")
@GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idVenta;
    private Date hora;
    private String estado;
    private double monto;
    private Date fecha;
    private int idCajero;
    private int idUsuario;

    public Venta() {
    }

    public Venta(int idVenta, Date hora, String estado, double monto, Date fecha, int idCajero, int idUsuario) {
        this.idVenta = idVenta;
        this.hora = hora;
        this.estado = estado;
        this.monto = monto;
        this.fecha = fecha;
        this.idCajero = idCajero;
        this.idUsuario = idUsuario;
    }

    public int getIdVenta() {
        return idVenta;
    }

    public void setIdVenta(int idVenta) {
        this.idVenta = idVenta;
    }

    public Date getHora() {
        return hora;
    }

    public void setHora(Date hora) {
        this.hora = hora;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public int getIdCajero() {
        return idCajero;
    }

    public void setIdCajero(int idCajero) {
        this.idCajero = idCajero;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }
    
    
    
    
    
    
}
