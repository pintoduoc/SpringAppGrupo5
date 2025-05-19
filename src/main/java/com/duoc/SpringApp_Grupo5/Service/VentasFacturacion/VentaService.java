package com.duoc.SpringApp_Grupo5.Service.VentasFacturacion;

import com.duoc.SpringApp_Grupo5.Modelo.VentasFacturacion.Venta;
import com.duoc.SpringApp_Grupo5.Repositorio.VentasFacturacion.VentaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VentaService {
    @Autowired
    private VentaRepository ventaRepository;

    //Listar
    public String getAllVentas() {
        String output = "";

        for (Venta venta : ventaRepository.findAll()) {
            output += "ID Venta: " + venta.getIdVenta() + "\n";
            output += "Usuario: " + venta.getUsuario() + "\n";
            output += "Productos Asignados: " + venta.getProductosVenta() + "\n";

        }
        if(output.isEmpty()){
            return "No se encontraron ventas";
        }else{
            return output;
        }
    }

    //Buscar
    public String getVentaById(int id) {
        String output = "";
        if (ventaRepository.existsById(id)) {
            Venta buscado = ventaRepository.findById(id).get();
            output += "ID Venta: " + buscado.getIdVenta() + "\n";
            output += "Usuario: " + buscado.getUsuario() + "\n";
            output += "Productos Asignados: " + buscado.getProductosVenta() + "\n";
            return output;
        }else{
            return "No se encontraron ventas con esa ID";
        }
    }
    //Agregar
    public String addVenta(Venta venta) {
        if(!ventaRepository.existsById(venta.getIdVenta())){
            ventaRepository.save(venta);
            return "Venta agregada correctamente";
        }else{
            return "Envio ya existente";
        }
    }
    //Eliminar
    public String deleteVenta(int id) {
        if(ventaRepository.existsById(id)){
            ventaRepository.deleteById(id);
            return "Venta eliminada correctamente";
        }else{
            return "No se encontraron ventas con esa ID";
        }
    }
    //Actualizar
    public String updateVenta(int id, Venta venta) {
        if(ventaRepository.existsById(id)){
            Venta buscado = ventaRepository.findById(id).get();
            buscado.setUsuario(venta.getUsuario());
            buscado.setProductosVenta(venta.getProductosVenta());
            ventaRepository.save(buscado);
            return "Venta actualizada correctamente";
        }else{
            return "No se encontraron ventas con esa ID";
        }
    }
}