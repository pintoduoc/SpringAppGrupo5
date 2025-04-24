package com.duoc.SpringApp_Grupo5.LogisiticayEnvios;

import java.util.List;
import java.util.UUID;

public class Cliente {
    private UUID id;
    private String nombre;
    private String email;
    private String direccion;
    private List<Pedido> historialPedidos;
    private List<ClienteProducto> productosCalificados;

    public Cliente(UUID id, String nombre, String email, String direccion, List<Pedido> historialPedidos, List<ClienteProducto> productosCalificados) {
        this.id = id;
        this.nombre = nombre;
        this.email = email;
        this.direccion = direccion;
        this.historialPedidos = historialPedidos;
        this.productosCalificados = productosCalificados;
    }

    public void registrar() {
        // Lógica de registro
    }

    public void iniciarSesion() {
        // Lógica de inicio de sesión
    }
}