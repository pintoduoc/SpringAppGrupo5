package com.duoc.SpringApp_Grupo5.Service.Usuarios;

import com.duoc.SpringApp_Grupo5.Modelo.Usuarios.Usuario;
import com.duoc.SpringApp_Grupo5.Repositorio.Usuarios.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    //Listar
    public List<Usuario> getAllUsuarios() {
        return usuarioRepository.findAll();
    }

    //Buscar
    public Usuario getUsuarioById(int id) {
        if(usuarioRepository.existsById(id)){
            return usuarioRepository.findById(id).get();
        }else{
            return null;
        }
    }

    //Agregar
    public Usuario addUsuario(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    //Eliminar
    public boolean deleteUsuario(int id) {
        if(usuarioRepository.existsById(id)){
            usuarioRepository.deleteById(id);
            return true;
        }else{
            return false;
        }
    }

    //Actualizar
    public Usuario updateUsuario(int id, Usuario usuario) {
        if(usuarioRepository.existsById(id)){
            Usuario buscado =usuarioRepository.findById(id).get();
            buscado.setNombre(usuario.getNombre());
            buscado.setEmail(usuario.getEmail());
            buscado.setContrasena(usuario.getContrasena());
            buscado.setRol(usuario.getRol());
            usuarioRepository.save(buscado);
            return usuario;
        }else {
            return null;
        }
    }
}