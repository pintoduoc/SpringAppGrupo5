package com.duoc.SpringApp_Grupo5.Modelo.GestionInventario;

public class producto {
    private int id, proveedorId, stock;
    private String nombre, descripcion, categoria;
    private float precio;

    //Constructores:
    public producto() {
    }

    public producto(int id, int proveedorId, int stock, String nombre, String descripcion, String categoria, float precio) {
        this.id = id;
        this.proveedorId = proveedorId;
        this.stock = stock;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.categoria = categoria;
        this.precio = precio;
    }


    //Getter & Setter:
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getProveedorId() {
        return proveedorId;
    }

    public void setProveedorId(int proveedorId) {
        this.proveedorId = proveedorId;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }
}
