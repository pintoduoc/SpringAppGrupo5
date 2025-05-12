package com.duoc.SpringApp_Grupo5.Modelo.ReportesyAnaliticas;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@Entity
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idCliente;
    private String nombreCliente, emailCliente, direccionCliente, passwordCliente;
    private List<Resena> resenas = new ArrayList<>();
    private List<Pedido> pedidos = new ArrayList<>();

    /*Metodos
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