package com.duoc.SpringApp_Grupo5.Service.Usuarios;

import com.duoc.SpringApp_Grupo5.Modelo.Usuarios.Usuario;
import com.duoc.SpringApp_Grupo5.Repositorio.Usuarios.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service

public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    //Listar
    public String getAllUsuarios() {
        String output = "";
        for (Usuario usuario : usuarioRepository.findAll()){
            output += "ID Usuario: "+usuario.getId();
            output += "Nombre: "+usuario.getNombre()+"\n";
            output += "Email: "+usuario.getEmail()+"\n";
            output += "Contraseña: "+usuario.getContraseña()+"\n";
            output += "Rol: "+usuario.getRol()+"\n";

        }
        return output;
    }

    //Buscar
    public String getUsuarioById(int id) {
        String output = "";
        if(usuarioRepository.existsById(id)){
            Usuario buscado = usuarioRepository.findById(id).get();
            output += "ID Usuario: "+buscado.getId()+"\n";
            output += "Nombre: "+buscado.getNombre()+"\n";
            output += "Email: "+buscado.getEmail()+"\n";
            output += "Contraseña: "+buscado.getContraseña()+"\n";
            output += "Rol: "+buscado.getRol()+"\n";
            return output;
        }else{
            return "No se encuentra usuario con esa ID";
        }
    }

    //Agregar
    public String addUsuario(Usuario usuario) {
        if(!usuarioRepository.existsById(usuario.getId())){
            usuarioRepository.save(usuario);
            return "Usuario agregado correctamente";
        }else{
            return "Usuario ya existe";
        }
    }

    //Eliminar
    public String deleteUsuario(int id) {
        if(usuarioRepository.existsById(id)){
            usuarioRepository.deleteById(id);
            return "Usuario eliminado correctamente";
        }else{
            return "No se encontraron usuarios con esa ID";
        }
    }

    //Actualizar
    public String updateUsuario(int id, Usuario usuario) {
        if(usuarioRepository.existsById(id)){
            Usuario buscado =usuarioRepository.findById(id).get();
            buscado.setNombre(usuario.getNombre());
            buscado.setEmail(usuario.getEmail());
            buscado.setContraseña(usuario.getContraseña());
            buscado.setRol(usuario.getRol());
            usuarioRepository.save(buscado);
            return "Usuario actualizado con exito";
        }else {
            return "No se encontraron usuarios con esa ID";
        }
    }
}