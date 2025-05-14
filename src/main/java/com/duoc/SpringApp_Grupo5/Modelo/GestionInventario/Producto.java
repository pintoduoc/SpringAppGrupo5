package com.duoc.SpringApp_Grupo5.Modelo.GestionInventario;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

@Entity
public class Producto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_producto;
    private int stock;
    @OneToOne
    @JoinColumn(name = "proveedor_id")
    private Proveedor proveedor;
    private String nombre, descripcion, categoria;
    private float precio;
}