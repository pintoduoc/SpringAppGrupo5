package com.duoc.SpringApp_Grupo5.Modelo.GestionInventario;

public class proveedor {
    private int id;
    private String nombre, contacto, direccion;

    //Constructores:
    public proveedor() {
    }

    public proveedor(String nombre, int id, String contacto, String direccion) {
        this.nombre = nombre;
        this.id = id;
        this.contacto = contacto;
        this.direccion = direccion;
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

    public String getContacto() {
        return contacto;
    }

    public void setContacto(String contacto) {
        this.contacto = contacto;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
}
