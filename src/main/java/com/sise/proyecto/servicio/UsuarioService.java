package com.sise.proyecto.servicio;
import com.sise.proyecto.model.Usuario;
import java.util.List;

public interface UsuarioService {
    
public Usuario listarUsuario(int id);
public List<Usuario> listarUsuarios();

public void addUsuario(Usuario u);
public void updateUsuario(Usuario p);
public void updateUsuarioestado(int id, String estado);

public String validarUsuario (String nusuario, String pass);
}
