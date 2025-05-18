package com.duoc.SpringApp_Grupo5.Controller.LogisticayEnvio;

import com.duoc.SpringApp_Grupo5.Modelo.LogisticayEnvio.Envio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping

public class EnvioController {

    @Autowired
    private EnvioService envioService;

    @GetMapping
    public String getAllEnvios() {return envioService.getAllEnvios(); }

    @PostMapping
    public String addEnvio(@RequestBody Envio envio) {return envioService.addEnvio(envio); }

    @GetMapping("/{id}")
    public String getEnvioById(@PathVariable int id) {return envioService.getEnvioById(id); }

    @DeleteMapping("/{id}")
    public String deleteEnvio(@PathVariable int id) {return envioService.deleteEnvio(id); }

    @PutMapping("/{id}")
    public String updateEnvio(@PathVariable int id, @RequestBody Envio envio) {
        return envioService.updateEnvio(id,envio);
    }
}
