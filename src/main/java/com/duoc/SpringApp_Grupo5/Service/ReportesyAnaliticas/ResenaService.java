package com.duoc.SpringApp_Grupo5.Service.ReportesyAnaliticas;

import com.duoc.SpringApp_Grupo5.Modelo.ReportesyAnaliticas.Resena;
import com.duoc.SpringApp_Grupo5.Repositorio.ReportesyAnaliticas.ResenaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ResenaService {
    @Autowired
    ResenaRepository resenaRepository;

    //Listar
    public String getAllResenas(){
        String output = "";

        for (Resena resena : resenaRepository.findAll()) {
            output += "ID Reseña: "+resena.getIdResena()+"\n";
            output += "Calificacion: "+resena.getCalificacion()+"\n";
            output += "Cliente: "+resena.getCliente()+"\n";
            output += "Producto: "+resena.getProducto()+"\n";
            output += "Comentario: "+resena.getComentario()+"\n";
        }
        if(output.isEmpty()){
            return "No se encontraron reseñas";
        }else{
            return output;
        }
    }
    //Buscar
    public String getResenaById(int id){
        String output = "";
        if(resenaRepository.existsById(id)){
            Resena buscado = resenaRepository.findById(id).get();
            output += "ID Reseña "+buscado.getIdResena()+"\n";
            output += "Calificacion: "+buscado.getCalificacion()+"\n";
            output += "Cliente: "+buscado.getCliente()+"\n";
            output += "Producto: "+buscado.getProducto()+"\n";
            output += "Comentario: "+buscado.getComentario()+"\n";
            return output;
        }else{
            return "No se encontraron reseñas con esa ID";
        }
    }
    //Agregar
    public String addResena(Resena resena){
        if(!resenaRepository.existsById(resena.getIdResena())){
            resenaRepository.save(resena);
            return "Reseña agregada correctamente";
        }else{
            return "Reseña ya existente";
        }
    }
    //Eliminar
    public String deleteResena(int id){
        if(resenaRepository.existsById(id)){
            resenaRepository.deleteById(id);
            return "Reseña eliminada correctamente";
        }else{
            return "No se encontraron reseñas con esa ID";
        }
    }
    //Actualizar
    public String updateResena(int id, Resena resena){
        if(resenaRepository.existsById(id)){
            Resena buscado = resenaRepository.findById(id).get();
            buscado.setCalificacion(resena.getCalificacion());
            buscado.setCliente(resena.getCliente());
            buscado.setProducto(resena.getProducto());
            buscado.setComentario(resena.getComentario());
            resenaRepository.save(buscado);
            return "Reseña actualizada correctamente";
        }else{
            return "No se encontraron reseñas con esa ID";
        }
    }
}
