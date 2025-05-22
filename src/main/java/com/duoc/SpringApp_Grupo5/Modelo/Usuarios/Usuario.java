package com.duoc.SpringApp_Grupo5.Modelo.Usuarios;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nombre, email, contrasena, rol;
    private boolean estado;

    /*Metodos viejos (borrador):
    public boolean autenticar(Usuario usuario, String password) {
        if (usuario.getContraseña().equals(password)) {
            return true;
        }else {
            return false;
        }
    }*/
}
