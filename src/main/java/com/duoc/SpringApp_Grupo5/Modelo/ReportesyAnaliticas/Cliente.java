package com.duoc.SpringApp_Grupo5.Modelo.ReportesyAnaliticas;

import java.util.ArrayList;
import java.util.List;

public class Cliente {
    private int idCliente;
    private String nombreCliente, emailCliente, direccionCliente, passwordCliente;
    private List<Resena> resenas = new ArrayList<>();
    private List<Pedido> pedidos = new ArrayList<>();

    public Cliente(int idCliente, String nombreCliente, String emailCliente, String direccionCliente, String passwordCliente, List<Resena> resenas, List<Pedido> pedidos) {
        this.idCliente = idCliente;
        this.nombreCliente = nombreCliente;
        this.emailCliente = emailCliente;
        this.direccionCliente = direccionCliente;
        this.passwordCliente = passwordCliente;
        this.resenas = resenas;
        this.pedidos = pedidos;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    public String getEmailCliente() {
        return emailCliente;
    }

    public void setEmailCliente(String emailCliente) {
        this.emailCliente = emailCliente;
    }

    public String getDireccionCliente() {
        return direccionCliente;
    }

    public void setDireccionCliente(String direccionCliente) {
        this.direccionCliente = direccionCliente;
    }

    public String getPasswordCliente() {
        return passwordCliente;
    }

    public void setPasswordCliente(String passwordCliente) {
        this.passwordCliente = passwordCliente;
    }

    public List<Resena> getResenas() {
        return resenas;
    }

    public void setResenas(List<Resena> resenas) {
        this.resenas = resenas;
    }

    public List<Pedido> getPedidos() {
        return pedidos;
    }

    public void setPedidos(List<Pedido> pedidos) {
        this.pedidos = pedidos;
    }

    //Metodos
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
    }

}