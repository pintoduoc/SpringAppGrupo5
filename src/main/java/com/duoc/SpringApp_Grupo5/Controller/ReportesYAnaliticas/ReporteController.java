package com.duoc.SpringApp_Grupo5.Controller.ReportesYAnaliticas;

import com.duoc.SpringApp_Grupo5.Modelo.ReportesyAnaliticas.Reporte;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping

public class ReporteController {

    @Autowired
    private ReporteService reporteService;

    @GetMapping
    public String getAllReportes() {return reporteService.getAllReportes(); }

    @PostMapping
    public String addReporte(@RequestBody Reporte reporte) {return reporteService.addReporte(reporte); }

    @GetMapping("/{id}")
    public String getReporteById(@PathVariable int id) {return reporteService,getReporteById(id); }

    @DeleteMapping("/{id}")
    public String deleteReporte(@PathVariable int id) {return reporteService.deleteReporte(id); }

    @PutMapping("/{id}")
    public String updateReporte(@PathVariable int id, @RequestBody Reporte reporte) {
        return reporteService.updateReporte(id, reporte);
    }
}
