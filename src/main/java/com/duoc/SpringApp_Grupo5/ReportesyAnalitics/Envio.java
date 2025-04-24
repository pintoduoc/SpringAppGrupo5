package com.duoc.SpringApp_Grupo5.ReportesyAnalitics;

import java.util.UUID;
import java.util.Date;

public class Envio {
    private UUID id;
    private UUID pedidoId;
    private String estado;
    private String direccionDestino;
    private Date fechaEnvio;

    // Constructor
    public Envio(UUID id, UUID pedidoId, String estado, String direccionDestino, Date fechaEnvio) {
        this.id = id;
        this.pedidoId = pedidoId;
        this.estado = estado;
        this.direccionDestino = direccionDestino;
        this.fechaEnvio = fechaEnvio;
    }

    // Getters y setters
    public UUID getId() {
        return id;
    }

    public UUID getPedidoId() {
        return pedidoId;
    }

    public String getEstado() {
        return estado;
    }

    public String getDireccionDestino() {
        return direccionDestino;
    }

    public Date getFechaEnvio() {
        return fechaEnvio;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    // Método para actualizar estado
    public void actualizarEstado(String nuevoEstado) {
        this.estado = nuevoEstado;
    }
}
