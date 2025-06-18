package com.duoc.SpringApp_Grupo5.Service.GestionInventario;

import com.duoc.SpringApp_Grupo5.Modelo.GestionInventario.Producto;
import com.duoc.SpringApp_Grupo5.Repositorio.GestionInventario.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductoService {

    @Autowired
    private ProductoRepository productoRepository;

    //Listar:
    public List<Producto> getAllProductos() {
       return productoRepository.findAll();
    }

    //Buscar
    public Producto getProductoById(int id) {
        if(productoRepository.existsById(id)){
            return  productoRepository.findById(id).get();
        }else{
            return null;
        }
    }

    //Agregar
    public Producto addProducto(Producto producto) {
        return productoRepository.save(producto);
    }
    //Eliminar
    public boolean deleteProducto(int id) {
        if(productoRepository.existsById(id)){
            productoRepository.deleteById(id);
            return true;
        }else{
            return false;
        }
    }

    //Actualizar
    public Producto updateProducto(int id, Producto producto) {
        if(productoRepository.existsById(id)){
            Producto buscado=productoRepository.findById(id).get();
            buscado.setStock(producto.getStock());
            buscado.setProveedor(producto.getProveedor());
            buscado.setNombre(producto.getNombre());
            buscado.setDescripcion(producto.getDescripcion());
            buscado.setCategoria(producto.getCategoria());
            buscado.setPrecio(producto.getPrecio());
            productoRepository.save(buscado);
            return producto;
        }else{
            return null;
        }
    }

}
