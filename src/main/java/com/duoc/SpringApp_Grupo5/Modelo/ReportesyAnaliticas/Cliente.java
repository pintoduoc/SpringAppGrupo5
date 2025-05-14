package com.duoc.SpringApp_Grupo5.Modelo.ReportesyAnaliticas;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idCliente;
    private String nombreCliente, emailCliente, direccionCliente, passwordCliente;
    @OneToMany
    @JoinTable(name = "cliente_resena", joinColumns = @JoinColumn(name = "cliente_id_cliente"), inverseJoinColumns = @JoinColumn(name = "resena_id_resena"))
    private List<Resena> resenas = new ArrayList<>();
    @OneToMany
    @JoinTable(name = "cliente_pedido", joinColumns = @JoinColumn(name = "cliente_id_cliente"), inverseJoinColumns = @JoinColumn(name = "pedido_id_pedido"))
    private List<Pedido> pedidos = new ArrayList<>();

    /*Metodos viejos (borrador):
    public void registrarCliente(int idCliente, String nombreCliente, String emailCliente, String direccionCliente, String passwordCliente) {
        Cliente cliente = new Cliente(idCliente, nombreCliente, emailCliente, direccionCliente, passwordCliente, resenas, pedidos);
        System.out.println("Cliente registrado");
    }
    public void iniciarSesionCliente(int idCliente, String passwordCliente) {
        if (idCliente == this.idCliente && passwordCliente.equals(this.passwordCliente)) {
            System.out.println("Inicio de sesion exitoso");
        }else {
            System.out.printf("Datos ingresados incorrectos");
        }
    }*/

}