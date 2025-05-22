package com.duoc.SpringApp_Grupo5.Modelo.VentasFacturacion;

import com.duoc.SpringApp_Grupo5.Modelo.GestionInventario.Producto;
import com.duoc.SpringApp_Grupo5.Modelo.Usuarios.Usuario;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor

@Entity
public class Venta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idVenta;
    @OneToOne
    @JoinColumn(name = "usuario_id", referencedColumnName = "id")
    private Usuario usuario;
    @ManyToMany
    @JoinTable(name = "venta_producto", joinColumns = @JoinColumn(name = "venta_id_venta"), inverseJoinColumns = @JoinColumn(name = "producto_id_producto"))
    private List<Producto> productosVenta = new ArrayList<>();


}
