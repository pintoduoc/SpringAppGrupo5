package com.duoc.SpringApp_Grupo5.LogisiticayEnvios;

import java.util.UUID;

public class ClienteProducto {
    private UUID id;
    private UUID clienteId;
    private UUID productoId;
    private int calificacion;
    private String comentario;

    public ClienteProducto(UUID id, UUID clienteId, UUID productoId, int calificacion, String comentario) {
        this.id = id;
        this.clienteId = clienteId;
        this.productoId = productoId;
        this.calificacion = calificacion;
        this.comentario = comentario;
    }
}