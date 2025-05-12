package com.duoc.SpringApp_Grupo5.Modelo.ReportesyAnaliticas;

import com.duoc.SpringApp_Grupo5.Modelo.GestionInventario.Producto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Resena {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idResena, calificacion;
    @ManyToOne
    @JoinColumn(name = "cliente_id_cliente")
    private Cliente cliente;
    @OneToOne
    @JoinColumns({
            @JoinColumn(name = "producto_id", referencedColumnName = "id"),
            @JoinColumn(name = "producto_proveedorId", referencedColumnName = "proveedorId"),
            @JoinColumn(name = "producto_stock", referencedColumnName = "stock")
    })
    private Producto producto;
    private String comentario;
}