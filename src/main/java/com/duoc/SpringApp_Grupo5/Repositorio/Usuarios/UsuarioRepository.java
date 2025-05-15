package com.duoc.SpringApp_Grupo5.Repositorio.Usuarios;

import com.duoc.SpringApp_Grupo5.Modelo.Usuarios.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

}
