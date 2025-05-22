package com.duoc.SpringApp_Grupo5.Controller.VentasFacturacion;

import com.duoc.SpringApp_Grupo5.Modelo.VentasFacturacion.Venta;
import com.duoc.SpringApp_Grupo5.Service.VentasFacturacion.VentaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/venta")

public class VentaController {

    @Autowired
    private VentaService ventaService;

    @GetMapping
    public String getAllVentas() {return ventaService.getAllVentas(); }

    @PostMapping
    public String addVenta(@RequestBody Venta venta) {return ventaService.addVenta(venta); }

    @GetMapping("/{id}")
    public String getVentaById(@PathVariable int id) {return ventaService.getVentaById(id); }

    @DeleteMapping("/{id}")
    public String deleteVenta(@PathVariable int id) {return ventaService.deleteVenta(id); }

    @PutMapping("/{id}")
    public String updateVenta(@PathVariable int id, @RequestBody Venta venta){
        return ventaService.updateVenta(id, venta);
    }
}
