package com.duoc.SpringApp_Grupo5.LogisiticayEnvios;

import java.util.List;
import java.util.UUID;

public class Pedido {
    private UUID id;
    private UUID clienteId;
    private List<UUID> productos;
    private float total;
    private String estado;
    private List<ClienteProducto> productosRelacionados;

    public Pedido(UUID id, UUID clienteId, List<UUID> productos, float total, String estado, List<ClienteProducto> productosRelacionados) {
        this.id = id;
        this.clienteId = clienteId;
        this.productos = productos;
        this.total = total;
        this.estado = estado;
        this.productosRelacionados = productosRelacionados;
    }

    public void crearPedido() {
        // Lógica para crear el pedido
    }
}