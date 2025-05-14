package com.duoc.SpringApp_Grupo5.Modelo.ReportesyAnaliticas;

import java.util.ArrayList;
import java.util.List;
import com.duoc.SpringApp_Grupo5.Modelo.GestionInventario.Producto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Pedido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idPedido;
    @OneToOne
    @JoinColumn(name = "cliente_id_cliente")
    private Cliente cliente;
    private String estado;
    @OneToMany
    @JoinTable(name = "pedido_producto", joinColumns = @JoinColumn(name = "pedido_id_pedido"), inverseJoinColumns = @JoinColumn(name = "producto_id_producto"))
    private List<Producto> productos = new ArrayList<>();


    /*Metodos viejos (borrador)
    public void crearPedido(int idPedido, Cliente cliente) {
        Pedido pedido = new Pedido(idPedido, cliente, "Procesando", productosPedido);
        System.out.println("Pedido realizado con exito");
    }*/
}