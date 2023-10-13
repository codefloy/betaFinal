
package com.sise.proyecto.dao;

import com.sise.proyecto.model.Categoria;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;


public class CategoriaDAOImpl implements CategoriaDAO{
    private SessionFactory sessionFactory;
    public void setSessionFactory(SessionFactory sf) {
    this.sessionFactory = sf;
    }
    
    @Override
    public List<Categoria> listarCategorias() {
        List<Categoria> listaUsuarios = new ArrayList<Categoria>();
        Session session = this.sessionFactory.getCurrentSession();
        try {
        listaUsuarios = session.createQuery("from Categoria").list();
        } catch (Exception e) {
        e.printStackTrace();
        } finally {
        return listaUsuarios;
        }
    }
    
    @Override
    public void addCategoria(Categoria u) {
        Session session = this.sessionFactory.getCurrentSession();
        session.persist(u);
    }
    
    @Override
    public void updateCategoria(Categoria u) {
        Session session = this.sessionFactory.getCurrentSession();
        session.update(u);
    }
}
