package com.duoc.SpringApp_Grupo5.Modelo.ReportesyAnaliticas;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Reporte {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String tipo;
    private Date fechaGeneracion;
    private String datos;


    /*Metodos viejos (borrador)
    public void generarReporte() {
        String reporteGenerado = "";
        reporteGenerado += "Fecha de Generacion: " + fechaGeneracion + "\n";
        reporteGenerado += "ID: " + id + "\n";
        reporteGenerado += "Tipo: " + tipo + "\n";
        reporteGenerado += "Reporte: " + datos.toString() + "\n";
        System.out.println(reporteGenerado);

    }*/
}