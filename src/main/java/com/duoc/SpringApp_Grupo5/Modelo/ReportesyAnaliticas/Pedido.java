package com.duoc.SpringApp_Grupo5.Modelo.ReportesyAnaliticas;

import java.util.ArrayList;
import java.util.List;


public class Pedido {
    private int idPedido;
    private Cliente cliente;
    private String estado;
    private List<Producto> productosPedido = new ArrayList<>();

    public Pedido(int idPedido, Cliente cliente, String estado, List<Producto> productosPedido) {
        this.idPedido = idPedido;
        this.cliente = cliente;
        this.estado = estado;
        this.productosPedido = productosPedido;
    }

    public int getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(int idPedido) {
        this.idPedido = idPedido;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public List<Producto> getProductosPedido() {
        return productosPedido;
    }

    public void setProductosPedido(List<Producto> productosPedido) {
        this.productosPedido = productosPedido;
    }
    //Metodos
    public void crearPedido(int idPedido, Cliente cliente) {
        Pedido pedido = new Pedido(idPedido, cliente, "Procesando", productosPedido);
        System.out.println("Pedido realizado con exito");
    }
}