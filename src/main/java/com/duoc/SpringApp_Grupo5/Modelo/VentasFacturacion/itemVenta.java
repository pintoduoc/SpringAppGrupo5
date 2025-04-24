package com.duoc.SpringApp_Grupo5.Modelo.VentasFacturacion;

public class itemVenta {
    private int productoId;
    private int cantidad;
    private float subtotal;

    //Constructores:
    public itemVenta() {
    }

    public itemVenta(int productoId, int cantidad, float subtotal) {
        this.productoId = productoId;
        this.cantidad = cantidad;
        this.subtotal = subtotal;
    }

    //Getter & Setter:
    public int getProductoId() {
        return productoId;
    }

    public void setProductoId(int productoId) {
        this.productoId = productoId;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public float getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(float subtotal) {
        this.subtotal = subtotal;
    }
}
