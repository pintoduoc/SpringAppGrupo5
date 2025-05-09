package com.duoc.SpringApp_Grupo5.Modelo.ReportesyAnaliticas;

import com.duoc.SpringApp_Grupo5.Modelo.GestionInventario.producto;

public class Resena {
    private int idResena, calificacion;
    private Cliente cliente;
    private producto producto;
    private String comentario;

    public Resena(int idResena, int calificacion, Cliente cliente, producto producto, String comentario) {
        this.idResena = idResena;
        this.calificacion = calificacion;
        this.cliente = cliente;
        this.producto = producto;
        this.comentario = comentario;
    }

    public int getIdResena() {
        return idResena;
    }

    public void setIdResena(int idResena) {
        this.idResena = idResena;
    }

    public int getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(int calificacion) {
        this.calificacion = calificacion;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public producto getProducto() {
        return producto;
    }

    public void setProducto(producto producto) {
        this.producto = producto;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }
}
