package com.duoc.SpringApp_Grupo5.Service.VentasFacturacion;

import com.duoc.SpringApp_Grupo5.Modelo.VentasFacturacion.Venta;
import com.duoc.SpringApp_Grupo5.Repositorio.VentasFacturacion.VentaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VentaService {
    @Autowired
    private VentaRepository ventaRepository;

    //Listar
    public List<Venta> getAllVentas() {
        return ventaRepository.findAll();
    }

    //Buscar
    public Venta getVentaById(int id) {
        if (ventaRepository.existsById(id)) {
            return ventaRepository.findById(id).get();
        } else {
            return null;
        }
    }
    //Agregar
    public Venta addVenta(Venta venta) {
        return ventaRepository.save(venta);
    }
    //Eliminar
    public boolean deleteVenta(int id) {
        if (ventaRepository.existsById(id)) {
            ventaRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }
    //Actualizar
    public Venta updateVenta(int id, Venta venta) {
        if(ventaRepository.existsById(id)){
            Venta buscado = ventaRepository.findById(id).get();
            buscado.setUsuario(venta.getUsuario());
            buscado.setProductosVenta(venta.getProductosVenta());
            ventaRepository.save(buscado);
            return venta;
        }else{
            return null;
        }
    }
}