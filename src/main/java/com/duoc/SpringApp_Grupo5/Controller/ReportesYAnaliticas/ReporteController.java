package com.duoc.SpringApp_Grupo5.Controller.ReportesYAnaliticas;

import com.duoc.SpringApp_Grupo5.Assemblers.ReportesYAnaliticas.ReporteModelAssembler;
import com.duoc.SpringApp_Grupo5.Modelo.ReportesyAnaliticas.Reporte;
import com.duoc.SpringApp_Grupo5.Service.GestionInventario.ProductoService;
import com.duoc.SpringApp_Grupo5.Service.ReportesyAnaliticas.ReporteService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reporte")
@Tag(name = "Reportes", description = "Operaciones para la clase 'Reporte'.")

public class ReporteController {

    @Autowired
    private ReporteService reporteService;

    @Autowired
    ReporteModelAssembler assembler;
    @Autowired
    private ProductoService productoService;

    @GetMapping
    @Operation(summary = "Obtener Reportes.", description = "Devuelve una lista de todos los reportes registrados en la base de datos.")
    public CollectionModel<EntityModel<Reporte>> getAllReportes() {
        List<Reporte> reportes = reporteService.getAllReportes();
        return assembler.toCollectionModel(reportes);
    }

    @PostMapping
    @Operation(summary = "Añadir Reporte.", description = "Registra un reporte a la base de datos, requiriendo los siguientes datos: Tipo, Fecha Generacion y Datos.")
    public EntityModel<Reporte> addReporte(@RequestBody Reporte reporte) {
        Reporte nuevo = reporteService.addReporte(reporte);
        if (nuevo != null) {
            return assembler.toModel(nuevo);
        }else {
            return null;
        }
    }

    @GetMapping("/{id}")
    @Operation(summary = "Obtener Reporte por ID.", description = "Busca un reporte con el ID entregado, y lo devuelve.")
    public EntityModel<Reporte> getReporteById(@PathVariable int id) {
        Reporte reporte = reporteService.getReporteById(id);
        if (reporte != null) {
            return assembler.toModel(reporte);
        }else {
            return null;
        }
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Eliminar Reporte.", description = "Busca un reporte con el ID entregada, y lo elimina.")
    public void deleteReporte(@PathVariable int id) {
        productoService.deleteProducto(id);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Actualizar Reporte.", description = "Busca un reporte por su ID, y cambia sus datos por los entregados por el usuario.")
    public EntityModel<Reporte> updateReporte(@PathVariable int id, @RequestBody Reporte reporte) {
        Reporte nuevoReporte = reporteService.updateReporte(id, reporte);
        if (nuevoReporte != null) {
            return assembler.toModel(nuevoReporte);
        }else {
            return null;
        }
    }
}
