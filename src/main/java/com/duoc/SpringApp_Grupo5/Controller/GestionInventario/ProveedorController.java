package com.duoc.SpringApp_Grupo5.Controller.GestionInventario;

import com.duoc.SpringApp_Grupo5.Modelo.GestionInventario.Proveedor;
import com.duoc.SpringApp_Grupo5.Service.GestionInventario.ProveedorService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/proveedor")
@Tag(name = "Proveedores", description = "Operaciones para la clase 'Proveedor'.")

public class ProveedorController {

    @Autowired
    private ProveedorService proveedorService;

    @GetMapping
    @Operation(summary = "Obtener todos los proveedores.", description = "Devuelve todos los proveedores registrados.")
    public String getAllProveedores() { return proveedorService.getAllProveedores(); }

    @PostMapping
    @Operation(summary = "Añadir Proveedor.", description = "Registra un proveedor a la base de datos, requiriendo los siguientes datos: Nombre, Contacto y Direccion.")
    public String addProveedor(@RequestBody Proveedor proveedor) { return proveedorService.addProveedor(proveedor);}

    @GetMapping("/{id}")
    @Operation(summary = "Obtener Proveedor por ID.", description = "Busca un Proveedor por su ID y lo devuelve.")
    public String getProveedor(@PathVariable int id) { return proveedorService.getProveedorById(id); }

    @DeleteMapping("/{id}")
    @Operation(summary = "Eliminar Proveedor.", description = "Busca un proveedor por su ID y lo elimina del registro.")
    public String deleteProveedor(@PathVariable int id) {return proveedorService.deleteProveedor(id); }

    @PutMapping("/{id}")
    @Operation(summary = "Actualizar Proveedor.", description = "Busca un proveedor por su ID, y cambia sus datos por los entregados por el usuario.")
    public String updateProveedor(@PathVariable int id, @RequestBody Proveedor proveedor) {
        return proveedorService.updateProveedor(id,proveedor);
    }

}
