package com.duoc.SpringApp_Grupo5.Controller.VentasFacturacion;

import com.duoc.SpringApp_Grupo5.Assemblers.VentasFacturacion.VentaModelAssembler;
import com.duoc.SpringApp_Grupo5.Modelo.VentasFacturacion.Venta;
import com.duoc.SpringApp_Grupo5.Service.VentasFacturacion.VentaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/venta")
@Tag(name = "Venta", description = "Operaciones para la clase 'Venta'")

public class VentaController {

    @Autowired
    private VentaService ventaService;

    @Autowired
    VentaModelAssembler assembler;

    @GetMapping
    @Operation(summary = "Obtener todas las ventas", description = "Devuelve una lista con todas las ventas registradas")
    public CollectionModel<EntityModel<Venta>> getAllVentas() {
        List<Venta> ventas = ventaService.getAllVentas();
        return assembler.toCollectionModel(ventas);
    }

    @PostMapping
    @Operation(summary = "Registrar venta", description = "Registra una venta a la base de datos. Requiere: Usuario y productos")
    public EntityModel<Venta> addVenta(@RequestBody Venta venta) {
        Venta nuevo = ventaService.addVenta(venta);
        if (nuevo != null) {
            return assembler.toModel(nuevo);
        } else {
            return null;
        }
    }

    @GetMapping("/{id}")
    @Operation(summary = "Buscar venta", description = "Busca una venta mediante la id ingresada")
    public EntityModel<Venta> getVentaById(@PathVariable int id) {
        Venta venta = ventaService.getVentaById(id);
        if (venta != null) {
            return assembler.toModel(venta);
        } else {
            return null;
        }
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Borrar venta", description = "Borra una venta mediante la id ingresada")
    public void deleteVenta(@PathVariable int id) {
        ventaService.deleteVenta(id);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Actualizar venta", description = "Actualiza una venta. Requiere: id de la venta a actualizar, nuevo usuario y nuevo producto")
    public EntityModel<Venta> updateVenta(@PathVariable int id, @RequestBody Venta venta){
        Venta nuevoVenta = ventaService.updateVenta(id, venta);
        if (nuevoVenta != null) {
            return assembler.toModel(nuevoVenta);
        } else {
            return null;
        }
    }
}
