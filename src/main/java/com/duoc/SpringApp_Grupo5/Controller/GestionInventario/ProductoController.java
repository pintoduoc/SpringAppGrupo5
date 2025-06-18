package com.duoc.SpringApp_Grupo5.Controller.GestionInventario;

import com.duoc.SpringApp_Grupo5.Assemblers.GestionInventario.ProductoModelAssembler;
import com.duoc.SpringApp_Grupo5.Modelo.GestionInventario.Producto;
import com.duoc.SpringApp_Grupo5.Service.GestionInventario.ProductoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/producto")
@Tag(name = "Productos", description = "Operaciones para la clase 'Producto.'")

public class ProductoController {

    @Autowired
    private ProductoService productoService;

    @Autowired
    ProductoModelAssembler assembler;

    @GetMapping
    @Operation(summary = "Obtener todos los productos.", description = "Devuelve todos los productos registrados.")
    public CollectionModel<EntityModel<Producto>> getAllProductos() {
        List<Producto> productos = productoService.getAllProductos();
        return assembler.toCollectionModel(productos);
    }

    @PostMapping
    @Operation(summary = "Añadir producto.", description = "Registra un producto a la base de datos, requiriendo los siguientes datos: Stock, ID Proveedor, Nombre, Descripcion, Categoria y Precio.")
    public EntityModel<Producto> addProducto(@RequestBody Producto producto) {
        Producto nuevo =  productoService.addProducto(producto);
        if(nuevo != null){
            return assembler.toModel(nuevo);
        }else{
            return null;
        }
    }

    @GetMapping("/{id}")
    @Operation(summary = "Buscar producto por ID.", description = "Busca un producto por su ID y lo devuelve.")
    public EntityModel<Producto> getProductoById(@PathVariable int id) {
        Producto producto = productoService.getProductoById(id);
        if (producto != null) {
            return assembler.toModel(producto);
        } else {
            return null;
        }
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Eliminar producto.", description = "Busca un producto por su ID y lo elimina.")
    public void deleteProducto(@PathVariable int id) {
        productoService.deleteProducto(id);

    }

    @PutMapping("/{id}")
    @Operation(summary = "Actualizar producto.", description = "Busca un producto por su ID, y cambia sus datos por los entregados por el usuario.")
    public EntityModel<Producto> updateProducto(@PathVariable int id, @RequestBody Producto producto) {
        Producto nuevoProducto = productoService.updateProducto(id, producto);
        if(nuevoProducto != null) {
            return assembler.toModel(nuevoProducto);
        }else{
            return null;
        }
    }


}
