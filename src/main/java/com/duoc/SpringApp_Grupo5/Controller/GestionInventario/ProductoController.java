package com.duoc.SpringApp_Grupo5.Controller.GestionInventario;

import com.duoc.SpringApp_Grupo5.Modelo.GestionInventario.Producto;
import com.duoc.SpringApp_Grupo5.Service.GestionInventario.ProductoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/producto")
@Tag(name = "Productos", description = "Operaciones para la clase 'Producto.'")

public class ProductoController{

    @Autowired
    private ProductoService productoService;

    @GetMapping
    @Operation(summary = "Obtener todos los productos.", description = "Devuelve todos los productos registrados.")
    public String getAllProductos() {return productoService.getAllProductos(); }

    @PostMapping
    @Operation(summary = "Añadir producto.", description = "Registra un producto a la base de datos, requiriendo los siguientes datos: Stock, ID Proveedor, Nombre, Descripcion, Categoria y Precio.")
    public String addProducto(@RequestBody Producto producto) {return productoService.addProducto(producto); }

    @GetMapping("/{id}")
    @Operation(summary = "Buscar producto por ID.", description = "Busca un producto por su ID y lo devuelve.")
    public String getProductoById(@PathVariable int id) { return productoService.getProductoById(id); }

    @DeleteMapping("/{id}")
    @Operation(summary = "Eliminar producto.", description = "Busca un producto por su ID y lo elimina.")
    public String deleteProducto(@PathVariable int id) { return productoService.deleteProducto(id); }

    @PutMapping("/{id}")
    @Operation(summary = "Actualizar producto.", description = "Busca un producto por su ID, y cambia sus datos por los entregados por el usuario.")
    public String updateProducto(@PathVariable int id, @RequestBody Producto producto){
        return productoService.updateProducto(id,producto);
    }


}
