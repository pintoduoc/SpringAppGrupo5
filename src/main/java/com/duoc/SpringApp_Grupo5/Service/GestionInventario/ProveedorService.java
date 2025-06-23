package com.duoc.SpringApp_Grupo5.Service.GestionInventario;

import com.duoc.SpringApp_Grupo5.Modelo.GestionInventario.Proveedor;
import com.duoc.SpringApp_Grupo5.Repositorio.GestionInventario.ProveedorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProveedorService {
    @Autowired
    private ProveedorRepository proveedorRepository;

    //Listar

     public List<Proveedor> getAllProveedores() {
            return proveedorRepository.findAll();
        }

    //Buscar
    public Proveedor getProveedorById(int id) {
        if(proveedorRepository.existsById(id)){
            return proveedorRepository.findById(id).get();
        }else {
            return null;
        }
    }

    //Agregar
    public Proveedor addProveedor(Proveedor proveedor) {
        return proveedorRepository.save(proveedor);
    }

    //Eliminar
    public boolean deleteProveedor(int id) {
        if(proveedorRepository.existsById(id)){
            proveedorRepository.deleteById(id);
            return true;
        }else{
            return false;
        }
    }

    //Actualizar
    public Proveedor updateProveedor(int id, Proveedor proveedor) {
        if(proveedorRepository.existsById(id)){
            Proveedor buscado = proveedorRepository.findById(id).get();
            buscado.setNombre(proveedor.getNombre());
            buscado.setContacto(proveedor.getContacto());
            buscado.setDireccion(proveedor.getDireccion());
            proveedorRepository.save(buscado);
            return proveedor;
        }else{
            return null;
        }
    }
}
