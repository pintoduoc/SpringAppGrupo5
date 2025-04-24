package com.duoc.SpringApp_Grupo5.Modelo.VentasFacturacion;

import com.duoc.SpringApp_Grupo5.Modelo.GestionInventario.producto;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class venta {
    private int id, clienteId, productoId;
    private List<producto> productos = new ArrayList();
    private Date fecha;
    private float precio;
    private String estado;

    //Constructores:
    public venta() {
    }

    public venta(int id, int clienteId, int productoId, List<producto> productos, Date fecha, float precio, String estado) {
        this.id = id;
        this.clienteId = clienteId;
        this.productoId = productoId;
        this.productos = productos;
        this.fecha = fecha;
        this.precio = precio;
        this.estado = estado;
    }


    //Getter & Setter:
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getClienteId() {
        return clienteId;
    }

    public void setClienteId(int clienteId) {
        this.clienteId = clienteId;
    }

    public int getProductoId() {
        return productoId;
    }

    public void setProductoId(int productoId) {
        this.productoId = productoId;
    }

    public List<producto> getProductos() {
        return productos;
    }

    public void setProductos(List<producto> productos) {
        this.productos = productos;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}
