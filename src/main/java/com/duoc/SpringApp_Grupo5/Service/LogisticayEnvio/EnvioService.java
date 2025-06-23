package com.duoc.SpringApp_Grupo5.Service.LogisticayEnvio;

import com.duoc.SpringApp_Grupo5.Modelo.LogisticayEnvio.Envio;
import com.duoc.SpringApp_Grupo5.Repositorio.LogisticayEnvio.EnvioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EnvioService {
    @Autowired
    private EnvioRepository envioRepository;

    //Listar
    public List<Envio> getAllEnvios() {
        return envioRepository.findAll();
    }

    //Buscar
    public Envio getEnvioById(int id){
        if(envioRepository.existsById(id)){
            return envioRepository.findById(id).get();
        }else{
            return null;
        }
    }
    //Agregar
    public Envio addEnvio(Envio envio){
        return envioRepository.save(envio);
    }
    //Eliminar
    public boolean deleteEnvio(int id){
        if(envioRepository.existsById(id)){
            envioRepository.deleteById(id);
            return true;
        }else {
            return false;
        }
    }
    //Actualizar
    public Envio updateEnvio(int id, Envio envio){
        if(envioRepository.existsById(id)){
            Envio buscado = envioRepository.findById(id).get();
            buscado.setPedido(envio.getPedido());
            buscado.setCliente(envio.getCliente());
            buscado.setDireccionEnvio(envio.getDireccionEnvio());
            buscado.setFechaEnvio(envio.getFechaEnvio());
            buscado.setEstadoEnvio(envio.getEstadoEnvio());
            envioRepository.save(buscado);
            return envio;
        }else{
            return null;
        }
    }
}
