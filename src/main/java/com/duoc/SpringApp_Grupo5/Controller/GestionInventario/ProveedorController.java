package com.duoc.SpringApp_Grupo5.Controller.GestionInventario;

import com.duoc.SpringApp_Grupo5.Assemblers.GestionInventario.ProveedorModelAssembler;
import com.duoc.SpringApp_Grupo5.Modelo.GestionInventario.Proveedor;
import com.duoc.SpringApp_Grupo5.Service.GestionInventario.ProveedorService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/proveedor")
@Tag(name = "Proveedores", description = "Operaciones para la clase 'Proveedor'.")

public class ProveedorController {

    @Autowired
    private ProveedorService proveedorService;

    @Autowired
    ProveedorModelAssembler assembler;

    @GetMapping
    @Operation(summary = "Obtener todos los proveedores.", description = "Devuelve todos los proveedores registrados.")
    public CollectionModel<EntityModel<Proveedor>> getAllProveedores() {
        List<Proveedor> proveedores = proveedorService.getAllProveedores();
        return assembler.toCollectionModel(proveedores);
    }

    @PostMapping
    @Operation(summary = "Añadir Proveedor.", description = "Registra un proveedor a la base de datos, requiriendo los siguientes datos: Nombre, Contacto y Direccion.")
    public EntityModel<Proveedor> addProveedor(@RequestBody Proveedor proveedor) {
        Proveedor nuevo = proveedorService.addProveedor(proveedor);
        if (nuevo != null) {
            return assembler.toModel(nuevo);
        }else {
            return null;
        }
    }

    @GetMapping("/{id}")
    @Operation(summary = "Obtener Proveedor por ID.", description = "Busca un Proveedor por su ID y lo devuelve.")
    public EntityModel<Proveedor> getProveedor(@PathVariable int id) {
        Proveedor proveedor = proveedorService.getProveedorById(id);
        if (proveedor != null) {
            return assembler.toModel(proveedor);
        } else {
            return null;
        }
    };
    @DeleteMapping("/{id}")
    @Operation(summary = "Eliminar Proveedor.", description = "Busca un proveedor por su ID y lo elimina del registro.")
    public void deleteProveedor(@PathVariable int id) {
        proveedorService.deleteProveedor(id);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Actualizar Proveedor.", description = "Busca un proveedor por su ID, y cambia sus datos por los entregados por el usuario.")
    public EntityModel<Proveedor> updateProveedor(@PathVariable int id, @RequestBody Proveedor proveedor) {
        Proveedor actualizado = proveedorService.updateProveedor(id, proveedor);
        if (actualizado != null) {
            return assembler.toModel(actualizado);
        } else {
            return null;
        }
    }

}
