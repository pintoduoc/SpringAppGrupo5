package com.duoc.SpringApp_Grupo5.Controller.ReportesYAnaliticas;

import com.duoc.SpringApp_Grupo5.Modelo.ReportesyAnaliticas.Reporte;
import com.duoc.SpringApp_Grupo5.Service.ReportesyAnaliticas.ReporteService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/reporte")
@Tag(name = "Reportes", description = "Operaciones para la clase 'Reporte'.")

public class ReporteController {

    @Autowired
    private ReporteService reporteService;

    @GetMapping
    @Operation(summary = "Obtener Reportes.", description = "Devuelve una lista de todos los reportes registrados en la base de datos.")
    public String getAllReportes() {return reporteService.getAllReportes(); }

    @PostMapping
    @Operation(summary = "Añadir Reporte.", description = "Registra un reporte a la base de datos, requiriendo los siguientes datos: Tipo, Fecha Generacion y Datos.")
    public String addReporte(@RequestBody Reporte reporte) {return reporteService.addReporte(reporte); }

    @GetMapping("/{id}")
    @Operation(summary = "Obtener Reporte por ID.", description = "Busca un reporte con el ID entregado, y lo devuelve.")
    public String getReporteById(@PathVariable int id) {return reporteService.getReporteById(id); }

    @DeleteMapping("/{id}")
    @Operation(summary = "Eliminar Reporte.", description = "Busca un reporte con el ID entregada, y lo elimina.")
    public String deleteReporte(@PathVariable int id) {return reporteService.deleteReporte(id); }

    @PutMapping("/{id}")
    @Operation(summary = "Actualizar Reporte.", description = "Busca un reporte por su ID, y cambia sus datos por los entregados por el usuario.")
    public String updateReporte(@PathVariable int id, @RequestBody Reporte reporte) {
        return reporteService.updateReporte(id, reporte);
    }
}
