package com.duoc.SpringApp_Grupo5.Modelo.ReportesyAnaliticas;

import java.util.Date;
import org.json.JSONObject;

public class Reporte {
    private int id;
    private String tipo;
    private Date fechaGeneracion;
    private JSONObject datos;

    public Reporte(int id, String tipo, Date fechaGeneracion, JSONObject datos) {
        this.id = id;
        this.tipo = tipo;
        this.fechaGeneracion = fechaGeneracion;
        this.datos = datos;
    }


    public void generarReporte() {
        String reporteGenerado = "";
        reporteGenerado += "Fecha de Generacion: " + fechaGeneracion + "\n";
        reporteGenerado += "ID: " + id + "\n";
        reporteGenerado += "Tipo: " + tipo + "\n";
        reporteGenerado += "Reporte: " + datos.toString() + "\n";
        System.out.println(reporteGenerado);

    }
}