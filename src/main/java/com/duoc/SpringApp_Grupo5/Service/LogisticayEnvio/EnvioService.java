package com.duoc.SpringApp_Grupo5.Service.LogisticayEnvio;

import com.duoc.SpringApp_Grupo5.Modelo.LogisticayEnvio.Envio;
import com.duoc.SpringApp_Grupo5.Repositorio.LogisticayEnvio.EnvioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EnvioService {
    @Autowired
    private EnvioRepository envioRepository;

    //Listar
    public String getAllEnvios() {
        String output = "";

        for (Envio envio : envioRepository.findAll()) {
            output +="ID Envio: "+envio.getIdEnvio()+"\n";
            output +="Pedido: "+envio.getPedido()+"\n";
            output +="Cliente: "+envio.getCliente()+"\n";
            output +="Direccion Envio: "+envio.getDireccionEnvio()+"\n";
            output +="Fecha Envio: "+envio.getFechaEnvio()+"\n";
            output +="Estado Envio: "+envio.getEstadoEnvio()+"\n";
        }
        if(output.isEmpty()){
            return "No se encontraron envios";
        }else{
            return output;
        }
    }

    //Buscar
    public String getEnvioById(int id){
        String output = "";
        if(envioRepository.existsById(id)){
            Envio buscado = envioRepository.findById(id).get();
            output += "ID Envio: "+buscado.getIdEnvio()+"\n";
            output += "Pedido: "+buscado.getPedido()+"\n";
            output += "Cliente: "+buscado.getCliente()+"\n";
            output += "Direccion Envio: "+buscado.getDireccionEnvio()+"\n";
            output += "Fecha Envio: "+buscado.getFechaEnvio();
            output += "Estado Envio: "+buscado.getEstadoEnvio()+"\n";
            return output;
        }else{
            return "No se encontraron envios con esa ID";
        }
    }
    //Agregar
    public String addEnvio(Envio envio){
        if(!envioRepository.existsById(envio.getIdEnvio())){
            envioRepository.save(envio);
            return "Envio agregado correctamente";
        }else{
            return "Envio ya existente";
        }
    }
    //Eliminar
    public String deleteEnvio(int id){
        if(envioRepository.existsById(id)){
            envioRepository.deleteById(id);
            return "Envio eliminado correctamente";
        }else{
            return "No se encontraron envios con esa ID";
        }
    }
    //Actualizar
    public String updateEnvio(int id, Envio envio){
        if(envioRepository.existsById(id)){
            Envio buscado = envioRepository.findById(id).get();
            buscado.setPedido(envio.getPedido());
            buscado.setCliente(envio.getCliente());
            buscado.setDireccionEnvio(envio.getDireccionEnvio());
            buscado.setFechaEnvio(envio.getFechaEnvio());
            buscado.setEstadoEnvio(envio.getEstadoEnvio());
            envioRepository.save(buscado);
            return "Envio actualizado correctamente";
        }else{
            return "No se encontraron envios con esa ID";
        }
    }
}
