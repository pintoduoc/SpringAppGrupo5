package com.duoc.SpringApp_Grupo5.Service.ReportesyAnaliticas;

import com.duoc.SpringApp_Grupo5.Modelo.ReportesyAnaliticas.Resena;
import com.duoc.SpringApp_Grupo5.Repositorio.ReportesyAnaliticas.ResenaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ResenaService {
    @Autowired
    ResenaRepository resenaRepository;

    //Listar
    public List<Resena> getAllResenas(){
        return resenaRepository.findAll();
    }
    //Buscar
    public Resena getResenaById(int id){
        if(resenaRepository.existsById(id)){
            return resenaRepository.findById(id).get();
        }else {
            return null;
        }
    }
    //Agregar
    public Resena addResena(Resena resena){
        return resenaRepository.save(resena);
    }
    //Eliminar
    public boolean deleteResena(int id){
        if(resenaRepository.existsById(id)){
            resenaRepository.deleteById(id);
            return true;
        }else {
            return false;
        }
    }
    //Actualizar
    public Resena updateResena(int id, Resena resena){
        if(resenaRepository.existsById(id)){
            Resena buscado = resenaRepository.findById(id).get();
            buscado.setCalificacion(resena.getCalificacion());
            buscado.setCliente(resena.getCliente());
            buscado.setProducto(resena.getProducto());
            buscado.setComentario(resena.getComentario());
            resenaRepository.save(buscado);
            return resena;
        }else{
            return null;
        }
    }
}
