package com.duoc.SpringApp_Grupo5.Controller.ReportesYAnaliticas;

import com.duoc.SpringApp_Grupo5.Modelo.ReportesyAnaliticas.Resena;
import com.duoc.SpringApp_Grupo5.Service.ReportesyAnaliticas.ResenaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping

public class ResenaController {

    @Autowired
    private ResenaService resenaService;

    @GetMapping
    public String getAllResenas() {return resenaService.getAllResenas(); }

    @PostMapping
    public String addResena(@RequestBody Resena resena) {return resenaService.addResena(resena); }

    @GetMapping("/{id}")
    public String getResenaById(@PathVariable int id) {return resenaService.getResenaById(id); }

    @DeleteMapping("/{id}")
    public String deleteResena(@PathVariable int id) { return resenaService.deleteResena(id); }

    @PutMapping("/{id}")
    public String updateResena(@PathVariable int id, @RequestBody Resena resena) {
        return resenaService.updateResena(id, resena);
    }
}
