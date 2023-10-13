package com.sise.proyecto.dao;

import com.sise.proyecto.model.Venta;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;


public class VentaDAOImpl implements VentaDAO{
    
     private SessionFactory sessionFactory;
    public void setSessionFactory(SessionFactory sf) {
    this.sessionFactory = sf;
    }
    
    @Override
    public List<Venta> listarVentas() {
        List<Venta> listaUsuarios = new ArrayList<Venta>();
        Session session = this.sessionFactory.getCurrentSession();
        try {
        listaUsuarios = session.createQuery("from Venta").list();
        } catch (Exception e) {
        e.printStackTrace();
        } finally {
        return listaUsuarios;
        }
    }
}
