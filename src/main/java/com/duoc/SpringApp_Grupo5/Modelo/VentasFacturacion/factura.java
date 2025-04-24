package com.duoc.SpringApp_Grupo5.Modelo.VentasFacturacion;

import java.util.Date;

public class factura {
    private int id;
    private int ventaId;
    private Date fechaEmision;
    private String emailCliente;

    //Construcores:
    public factura() {
    }

    public factura(int id, int ventaId, Date fechaEmision, String emailCliente) {
        this.id = id;
        this.ventaId = ventaId;
        this.fechaEmision = fechaEmision;
        this.emailCliente = emailCliente;
    }

    //Getter & Setter:
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getVentaId() {
        return ventaId;
    }

    public void setVentaId(int ventaId) {
        this.ventaId = ventaId;
    }

    public Date getFechaEmision() {
        return fechaEmision;
    }

    public void setFechaEmision(Date fechaEmision) {
        this.fechaEmision = fechaEmision;
    }

    public String getEmailCliente() {
        return emailCliente;
    }

    public void setEmailCliente(String emailCliente) {
        this.emailCliente = emailCliente;
    }
}
