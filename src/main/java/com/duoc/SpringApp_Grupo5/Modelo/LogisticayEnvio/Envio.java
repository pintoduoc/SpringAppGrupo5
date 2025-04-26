package com.duoc.SpringApp_Grupo5.Modelo.LogisticayEnvio;

import com.duoc.SpringApp_Grupo5.Modelo.ReportesyAnaliticas.Cliente;

public class Envio {
    private int idEnvio;
    private Pedido pedido;
    private Cliente cliente;
    private String direccionEnvio, fechaEnvio, estadoEnvio;

    public Envio(int idEnvio, Pedido pedido, Cliente cliente, String direccionEnvio, String fechaEnvio, String estadoEnvio) {
        this.idEnvio = idEnvio;
        this.pedido = pedido;
        this.cliente = cliente;
        this.direccionEnvio = direccionEnvio;
        this.fechaEnvio = fechaEnvio;
        this.estadoEnvio = estadoEnvio;
    }

    public int getIdEnvio() {
        return idEnvio;
    }

    public void setIdEnvio(int idEnvio) {
        this.idEnvio = idEnvio;
    }

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public String getDireccionEnvio() {
        return direccionEnvio;
    }

    public void setDireccionEnvio(String direccionEnvio) {
        this.direccionEnvio = direccionEnvio;
    }

    public String getFechaEnvio() {
        return fechaEnvio;
    }

    public void setFechaEnvio(String fechaEnvio) {
        this.fechaEnvio = fechaEnvio;
    }

    public String getEstadoEnvio() {
        return estadoEnvio;
    }

    public void setEstadoEnvio(String estadoEnvio) {
        this.estadoEnvio = estadoEnvio;
    }

    //Metodos
    public void actualizarEstadoEnvio(Envio envio, String estado) {
        envio.setEstadoEnvio(estado);
        System.out.println("Estado del pedido actualizado: " + estado);
    }

}
