package com.duoc.SpringApp_Grupo5.Service.GestionInventario;

import com.duoc.SpringApp_Grupo5.Modelo.GestionInventario.Producto;
import com.duoc.SpringApp_Grupo5.Modelo.GestionInventario.Proveedor;
import com.duoc.SpringApp_Grupo5.Repositorio.GestionInventario.ProveedorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProveedorService {
    @Autowired
    private ProveedorRepository proveedorRepository;

    //Listar
    public String getAllProveedores() {
        String output = "";

        for (Proveedor proveedor : proveedorRepository.findAll()) {
            output +="ID Proveedor: "+proveedor.getId()+"\n";
            output +="Nombre: "+proveedor.getNombre()+"\n";
            output +="Contacto: "+proveedor.getContacto()+"\n";
            output +="Direccion: "+proveedor.getDireccion()+"\n";
        }
        if(output.isEmpty()){
            return "No se encontraron proveedores";
        }else{
            return output;
        }
    }
    //Buscar
    public String getProveedorById(int id) {
        String output = "";
        if(proveedorRepository.existsById(id)){
            Proveedor buscado = proveedorRepository.findById(id).get();
            output = "ID Proveedor "+buscado.getId()+"\n";
            output +="Nombre: "+buscado.getNombre()+"\n";
            output +="Contacto: "+buscado.getContacto()+"\n";
            output +="Direccion: "+buscado.getDireccion()+"\n";
            return output;
        }else{
            return "No se encontraron proveedores con esa ID";
        }
    }

    //Agregar
    public String addProveedor(Proveedor proveedor) {
        if(!proveedorRepository.existsById(proveedor.getId())){
            proveedorRepository.save(proveedor);
            return "Proveedor agregado correctamente";
        }else{
            return "Proveedor ya existente";
        }
    }

    //Eliminar
    public String deleteProveedor(int id) {
        if(proveedorRepository.existsById(id)){
            proveedorRepository.deleteById(id);
            return "Proveedor eliminado correctamente";
        }else{
            return "No se encontraron proveedores con esa ID";
        }
    }

    //Actualizar
    public String updateProveedor(int id, Proveedor proveedor) {
        if(proveedorRepository.existsById(id)){
            Proveedor buscado = proveedorRepository.findById(id).get();
            buscado.setNombre(proveedor.getNombre());
            buscado.setContacto(proveedor.getContacto());
            buscado.setDireccion(proveedor.getDireccion());
            proveedorRepository.save(buscado);
            return "Proveedor actualizado correctamente";
        }else{
            return "No se encontraron proveedores con esa ID";
        }
    }
}
