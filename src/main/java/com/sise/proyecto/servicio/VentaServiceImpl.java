package com.sise.proyecto.servicio;

import com.sise.proyecto.dao.VentaDAO;
import com.sise.proyecto.model.Venta;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
public class VentaServiceImpl implements VentaService{
    private VentaDAO ventaDAO;
    
    public void setVentaDAO(VentaDAO ventaDAO) {
    this.ventaDAO = ventaDAO;
    }
    
    @Override
    @Transactional
    public List<Venta> listarVentas() {
        return this.ventaDAO.listarVentas();
    }
}
