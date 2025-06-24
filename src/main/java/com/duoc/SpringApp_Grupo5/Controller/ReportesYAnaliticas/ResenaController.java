package com.duoc.SpringApp_Grupo5.Controller.ReportesYAnaliticas;

import com.duoc.SpringApp_Grupo5.Assemblers.ReportesYAnaliticas.ResenaModelAssembler;
import com.duoc.SpringApp_Grupo5.Modelo.ReportesyAnaliticas.Resena;
import com.duoc.SpringApp_Grupo5.Service.ReportesyAnaliticas.ResenaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/resena")
@Tag(name = "Reseñas", description = "Operaciones para la clase 'Resena'.")

public class ResenaController {

    @Autowired
    private ResenaService resenaService;

    @Autowired
    ResenaModelAssembler assembler;

    @GetMapping
    @Operation(summary = "Obtener Reseñas.", description = "Devuelve una lista de todas las reseñas registradas en la base de datos.")
    public CollectionModel<EntityModel<Resena>> getAllResenas() {
        List<Resena> resenas = resenaService.getAllResenas();
        return assembler.toCollectionModel(resenas);
    }

    @PostMapping
    @Operation(summary = "Añadir Reseña.", description = "Registra una reseña a la base de datos, requiriendo los siguientes datos: Calificacion, ID Cliente, ID Producto y Comentario.")
    public EntityModel<Resena> addResena(@RequestBody Resena resena) {
        Resena nuevo = resenaService.addResena(resena);
        if (nuevo != null) {
            return assembler.toModel(nuevo);
        }else {
            return null;
        }
    }

    @GetMapping("/{id}")
    @Operation(summary = "Obtener Reseña por ID.", description = "Busca una reseña con el ID entregado, y la devuelve.")
    public EntityModel<Resena> getResenaById(@PathVariable int id) {
        Resena resena = resenaService.getResenaById(id);
        if (resena != null) {
            return assembler.toModel(resena);
        }else {
            return null;
        }
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Eliminar Reseña.", description = "Busca una reseña con el ID entregado, y la elimina-")
    public void deleteResena(@PathVariable int id) {
        resenaService.deleteResena(id);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Actualizar Reseña.", description = "Busca una reseña por su ID, y cambia sus datos por los entregados por el usuario.")
    public EntityModel<Resena> updateResena(@PathVariable int id, @RequestBody Resena resena) {
        Resena nuevoResena = resenaService.updateResena(id, resena);
        if (nuevoResena != null) {
            return assembler.toModel(nuevoResena);
        }else {
            return null;
        }
    }
}
