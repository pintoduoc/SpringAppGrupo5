package com.duoc.SpringApp_Grupo5.Controller.VentasFacturacion;

import com.duoc.SpringApp_Grupo5.Modelo.VentasFacturacion.Venta;
import com.duoc.SpringApp_Grupo5.Service.VentasFacturacion.VentaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/venta")
@Tag(name = "Venta", description = "Operaciones para la clase 'Venta'")

public class VentaController {

    @Autowired
    private VentaService ventaService;

    @GetMapping
    @Operation(summary = "Obtener todas las ventas", description = "Devuelve una lista con todas las ventas registradas")
    public String getAllVentas() {return ventaService.getAllVentas(); }

    @PostMapping
    @Operation(summary = "Registrar venta", description = "Registra una venta a la base de datos. Requiere: Usuario y productos")
    public String addVenta(@RequestBody Venta venta) {return ventaService.addVenta(venta); }

    @GetMapping("/{id}")
    @Operation(summary = "Buscar venta", description = "Busca una venta mediante la id ingresada")
    public String getVentaById(@PathVariable int id) {return ventaService.getVentaById(id); }

    @DeleteMapping("/{id}")
    @Operation(summary = "Borrar venta", description = "Borra una venta mediante la id ingresada")
    public String deleteVenta(@PathVariable int id) {return ventaService.deleteVenta(id); }

    @PutMapping("/{id}")
    @Operation(summary = "Actualizar venta", description = "Actualiza una venta. Requiere: id de la venta a actualizar, nuevo usuario y nuevo producto")
    public String updateVenta(@PathVariable int id, @RequestBody Venta venta){
        return ventaService.updateVenta(id, venta);
    }
}
