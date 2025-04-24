package com.duoc.SpringApp_Grupo5.LogisiticayEnvios;

import java.util.Date;
import java.util.UUID;
import org.json.JSONObject;

public class Reporte {
    private UUID id;
    private String tipo;
    private Date fechaGeneracion;
    private JSONObject datos;

    public Reporte(UUID id, String tipo, Date fechaGeneracion, JSONObject datos) {
        this.id = id;
        this.tipo = tipo;
        this.fechaGeneracion = fechaGeneracion;
        this.datos = datos;
    }

    public void generarReporte() {

    }
}