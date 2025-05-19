package com.duoc.SpringApp_Grupo5.Controller.GestionInventario;

import com.duoc.SpringApp_Grupo5.Modelo.GestionInventario.Proveedor;
import com.duoc.SpringApp_Grupo5.Service.GestionInventario.ProveedorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping

public class ProveedorController {

    @Autowired
    private ProveedorService proveedorService;

    @GetMapping
    public String getAllProveedores() { return proveedorService.getAllProveedores(); }

    @PostMapping
    public String addProveedor(@RequestBody Proveedor proveedor) { return proveedorService.addProveedor(proveedor);}

    @GetMapping("/{id}")
    public String getProveedor(@PathVariable int id) { return proveedorService.getProveedorById(id); }

    @DeleteMapping("/{id}")
    public String deleteProveedor(@PathVariable int id) {return proveedorService.deleteProveedor(id); }

    @PutMapping("/{id}")
    public String updateProveedor(@PathVariable int id, @RequestBody Proveedor proveedor) {
        return proveedorService.updateProveedor(id,proveedor);
    }

}
