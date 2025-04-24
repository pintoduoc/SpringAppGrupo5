package com.duoc.SpringApp_Grupo5.Modelo.Usuarios;

public class usuario {
    private int id;
    private String nombre, email, contraseña, rol;
    private boolean estado;
    //Constructores:
    public usuario() {
    }

    public usuario(int id, String nombre, String email, String contraseña, String rol, boolean estado) {
        this.id = id;
        this.nombre = nombre;
        this.email = email;
        this.contraseña = contraseña;
        this.rol = rol;
        this.estado = estado;
    }

    //Getter & Setter:
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }
    //Metodos:
    public boolean autenticar(usuario usuario, String password) {
        if (usuario.getContraseña().equals(password)) {
            return true;
        }else {
            return false;
        }
    }
}
