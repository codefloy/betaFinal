
package com.sise.proyecto.dao;

import com.sise.proyecto.model.Producto;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;


public class ProductoDAOImpl implements ProductoDAO{
    
    private SessionFactory sessionFactory;
    public void setSessionFactory(SessionFactory sf) {
    this.sessionFactory = sf;
    }
    
    @Override
    public List<Producto> listarProductos() {
        List<Producto> listaUsuarios = new ArrayList<Producto>();
        Session session = this.sessionFactory.getCurrentSession();
        try {
        listaUsuarios = session.createQuery("from Producto").list();
        } catch (Exception e) {
        e.printStackTrace();
        } finally {
        return listaUsuarios;
        }
    }
    
    @Override
    public void addProducto(Producto u) {
        Session session = this.sessionFactory.getCurrentSession();
        session.persist(u);
    }
    
    @Override
    public void updateProducto(Producto u) {
        Session session = this.sessionFactory.getCurrentSession();
        session.update(u);
    }
    
    @Override
    public int validarProducto(int id) {
        int rs = 0;
        Producto npro = new Producto();
        try {
            Session session = this.sessionFactory.getCurrentSession();
            Criteria query = session.createCriteria(Producto.class);
            query.add(Restrictions.eq("id", id));
            List<Producto> lista = query.list();
            npro=lista.get(0);
            int stock = npro.getCantidad();
            if(stock>0){
                rs=1;
            }else{
                rs=0;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            return rs;
        }
        
    }
}
