package com.duoc.SpringApp_Grupo5.Controller.GestionInventario;

import com.duoc.SpringApp_Grupo5.Modelo.GestionInventario.Producto;
import com.duoc.SpringApp_Grupo5.Service.GestionInventario.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/producto")

public class ProductoController{

    @Autowired
    private ProductoService productoService;

    @GetMapping
    public String getAllProductos() {return productoService.getAllProductos(); }

    @PostMapping
    public String addProducto(@RequestBody Producto producto) {return productoService.addProducto(producto); }

    @GetMapping("/{id}")
    public String getProductoById(@PathVariable int id) { return productoService.getProductoById(id); }

    @DeleteMapping("/{id}")
    public String deleteProducto(@PathVariable int id) { return productoService.deleteProducto(id); }

    @PutMapping("/{id}")
    public String updateProducto(@PathVariable int id, @RequestBody Producto producto){
        return productoService.updateProducto(id,producto);
    }


}
