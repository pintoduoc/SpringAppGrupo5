package com.duoc.SpringApp_Grupo5.Service.ReportesyAnaliticas;

import com.duoc.SpringApp_Grupo5.Modelo.ReportesyAnaliticas.Reporte;
import com.duoc.SpringApp_Grupo5.Repositorio.ReportesyAnaliticas.ReporteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReporteService {
    @Autowired
    private ReporteRepository reporteRepository;

    //Listar
    public List<Reporte> getAllReportes() {
        return reporteRepository.findAll();
    }
    //Buscar
    public Reporte getReporteById(int id) {
        if (reporteRepository.existsById(id)) {
            return reporteRepository.findById(id).get();
        }else {
            return null;
        }
    }

    //Agregar
    public Reporte addReporte(Reporte reporte) {
        return reporteRepository.save(reporte);
    }

    //Eliminar
    public boolean deleteReporte(int id) {
        if(reporteRepository.existsById(id)) {
            reporteRepository.deleteById(id);
            return true;
        }else {
            return false;
        }
    }

    //Actualizar
    public Reporte updateReporte(int id, Reporte reporte) {
        if(reporteRepository.existsById(id)) {
            Reporte buscado = reporteRepository.findById(id).get();
            buscado.setTipo(reporte.getTipo());
            buscado.setFechaGeneracion(reporte.getFechaGeneracion());
            buscado.setDatos(reporte.getDatos());
            reporteRepository.save(buscado);
            return reporte;
        }else{
            return null;
        }
    }
}
