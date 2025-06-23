package com.duoc.SpringApp_Grupo5.Controller.LogisticayEnvio;

import com.duoc.SpringApp_Grupo5.Assemblers.LogisticayEnvio.EnvioModelAssembler;
import com.duoc.SpringApp_Grupo5.Modelo.LogisticayEnvio.Envio;
import com.duoc.SpringApp_Grupo5.Service.LogisticayEnvio.EnvioService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.parser.Entity;
import java.util.List;

@RestController
@RequestMapping("/envio")
@Tag(name = "Envio", description = "Operaciones para la clase 'Envio'.")

public class EnvioController {

    @Autowired
    private EnvioService envioService;

    @Autowired
    EnvioModelAssembler assembler;

    @GetMapping
    @Operation(summary = "Obtener todos los envios.", description = "Devuelve todos los Envios regristrados.")
    public CollectionModel<EntityModel<Envio>> getAllEnvios() {
        List<Envio> envios = envioService.getAllEnvios();
        return assembler.toCollectionModel(envios);
    }

    @PostMapping
    @Operation(summary = "Añadir Envio.", description = "Registra un envio a la base de datos, requiriendo los siguientes datos: ID Pedido, ID Cliente, Direccion Envio, Fecha Envio y Estado Envio.")
    public EntityModel<Envio> addEnvio(@RequestBody Envio envio) {
        Envio nuevo = envioService.addEnvio(envio);
        if(nuevo != null){
            return assembler.toModel(nuevo);
        }else{
            return null;
        }
    }

    @GetMapping("/{id}")
    @Operation(summary = "Obtener Envio por ID.", description = "Busca el envio con el ID entregado y lo devuelve.")
    public EntityModel<Envio> getEnvioById(@PathVariable int id) {
        Envio envio = envioService.getEnvioById(id);
        if(envio != null){
            return assembler.toModel(envio);
        }else{
            return null;
        }
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Eliminar envio por ID.", description = "Busca el envio con el ID entregado y lo devuelve.")
    public void deleteEnvio(@PathVariable int id) {
        envioService.deleteEnvio(id);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Actualizar Envio.", description = "Busca un envio por su ID, y cambia sus datos por los entregados por el usuario.")
    public EntityModel<Envio> updateEnvio(@PathVariable int id, @RequestBody Envio envio) {
        Envio nuevoEnvio = envioService.updateEnvio(id, envio);
        if(nuevoEnvio != null){
            return assembler.toModel(nuevoEnvio);
        }else {
            return null;
        }
    }
}
