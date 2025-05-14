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
    private int idResena;
    private int calificacion;
    @ManyToOne
    @JoinColumn(name = "cliente_id_cliente")
    private Cliente cliente;
    @OneToOne
    @JoinColumn(name = "producto_id_producto")
    private Producto producto;
    private String comentario;
}