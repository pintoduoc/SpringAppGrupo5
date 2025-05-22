package com.duoc.SpringApp_Grupo5.Service.GestionInventario;

import com.duoc.SpringApp_Grupo5.Modelo.GestionInventario.Producto;
import com.duoc.SpringApp_Grupo5.Repositorio.GestionInventario.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductoService {

    @Autowired
    private ProductoRepository productoRepository;

    //Listar:
    public String getAllProductos() {
        String output = "";

        for (Producto producto : productoRepository.findAll()) {
            output += "ID Producto: "+producto.getId_producto()+"\n";
            output += "Stock: "+producto.getStock()+"\n";
            output += "ID Proveedor: "+producto.getProveedor().getId()+"\n";
            output += "Nombre: "+producto.getNombre()+"\n";
            output += "Descripcion: "+producto.getDescripcion()+"\n";
            output += "Categoria: "+producto.getCategoria()+"\n";
            output += "Precio: "+producto.getPrecio()+"\n";
        }
        if(output.isEmpty()) {
            return "No se encontraron productos";
        }else{
            return output;
        }
    }

    //Buscar
    public String getProductoById(int id) {
        String output = "";
        if(productoRepository.existsById(id)){
            Producto buscado=productoRepository.findById(id).get();
            output += "ID Producto: "+buscado.getId_producto()+"\n";
            output += "Stock: "+buscado.getStock()+"\n";
            output += "ID Proveedor: "+buscado.getProveedor().getId()+"\n";
            output += "Nombre: "+buscado.getNombre()+"\n";
            output += "Descripcion: "+buscado.getDescripcion()+"\n";
            output += "Categoria: "+buscado.getCategoria()+"\n";
            output += "Precio: "+buscado.getPrecio()+"\n";
            return output;
        }else{
            return "No se encontraron productos con esa ID";
        }
    }

    //Agregar
    public String addProducto(Producto producto) {
        if(!productoRepository.existsById(producto.getId_producto())){
            productoRepository.save(producto);
            return "Producto agregado correctamente";
        }else{
            return "Producto ya existente";
        }
    }
    //Eliminar
    public String deleteProducto(int id) {
        if(productoRepository.existsById(id)){
            productoRepository.deleteById(id);
            return "Producto eliminado correctamente";
        }else{
            return "No se encontraron productos con esa ID";
        }
    }

    //Actualizar
    public String updateProducto(int id, Producto producto) {
        if(productoRepository.existsById(id)){
            Producto buscado=productoRepository.findById(id).get();
            buscado.setStock(producto.getStock());
            buscado.setProveedor(producto.getProveedor());
            buscado.setNombre(producto.getNombre());
            buscado.setDescripcion(producto.getDescripcion());
            buscado.setCategoria(producto.getCategoria());
            buscado.setPrecio(producto.getPrecio());
            productoRepository.save(buscado);
            return "Producto actualizado correctamente";
        }else{
            return "No se encontraron productos con esa ID";
        }
    }

}
