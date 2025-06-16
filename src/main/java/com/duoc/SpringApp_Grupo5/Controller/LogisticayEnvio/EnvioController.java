package com.duoc.SpringApp_Grupo5.Controller.LogisticayEnvio;

import com.duoc.SpringApp_Grupo5.Modelo.LogisticayEnvio.Envio;
import com.duoc.SpringApp_Grupo5.Service.LogisticayEnvio.EnvioService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/envio")
@Tag(name = "Envio", description = "Operaciones para la clase 'Envio'.")

public class EnvioController {

    @Autowired
    private EnvioService envioService;

    @GetMapping
    @Operation(summary = "Obtener todos los envios.", description = "Devuelve todos los Envios regristrados.")
    public String getAllEnvios() {return envioService.getAllEnvios(); }

    @PostMapping
    @Operation(summary = "Añadir Envio.", description = "Registra un envio a la base de datos, requiriendo los siguientes datos: ID Pedido, ID Cliente, Direccion Envio, Fecha Envio y Estado Envio.")
    public String addEnvio(@RequestBody Envio envio) {return envioService.addEnvio(envio); }

    @GetMapping("/{id}")
    @Operation(summary = "Obtener Envio por ID.", description = "Busca el envio con el ID entregado y lo devuelve.")
    public String getEnvioById(@PathVariable int id) {return envioService.getEnvioById(id); }

    @DeleteMapping("/{id}")
    @Operation(summary = "Eliminar envio por ID.", description = "Busca el envio con el ID entregado y lo devuelve.")
    public String deleteEnvio(@PathVariable int id) {return envioService.deleteEnvio(id); }

    @PutMapping("/{id}")
    @Operation(summary = "Actualizar Envio.", description = "Busca un envio por su ID, y cambia sus datos por los entregados por el usuario.")
    public String updateEnvio(@PathVariable int id, @RequestBody Envio envio) {
        return envioService.updateEnvio(id,envio);
    }
}
