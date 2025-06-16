package com.duoc.SpringApp_Grupo5.Controller.ReportesYAnaliticas;

import com.duoc.SpringApp_Grupo5.Modelo.ReportesyAnaliticas.Resena;
import com.duoc.SpringApp_Grupo5.Service.ReportesyAnaliticas.ResenaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/resena")
@Tag(name = "Reseñas", description = "Operaciones para la clase 'Resena'.")

public class ResenaController {

    @Autowired
    private ResenaService resenaService;

    @GetMapping
    @Operation(summary = "Obtener Reseñas.", description = "Devuelve una lista de todas las reseñas registradas en la base de datos.")
    public String getAllResenas() {return resenaService.getAllResenas(); }

    @PostMapping
    @Operation(summary = "Añadir Reseña.", description = "Registra una reseña a la base de datos, requiriendo los siguientes datos: Calificacion, ID Cliente, ID Producto y Comentario.")
    public String addResena(@RequestBody Resena resena) {return resenaService.addResena(resena); }

    @GetMapping("/{id}")
    @Operation(summary = "Obtener Reseña por ID.", description = "Busca una reseña con el ID entregado, y la devuelve.")
    public String getResenaById(@PathVariable int id) {return resenaService.getResenaById(id); }

    @DeleteMapping("/{id}")
    @Operation(summary = "Eliminar Reseña.", description = "Busca una reseña con el ID entregado, y la elimina-")
    public String deleteResena(@PathVariable int id) { return resenaService.deleteResena(id); }

    @PutMapping("/{id}")
    @Operation(summary = "Actualizar Reseña.", description = "Busca una reseña por su ID, y cambia sus datos por los entregados por el usuario.")
    public String updateResena(@PathVariable int id, @RequestBody Resena resena) {
        return resenaService.updateResena(id, resena);
    }
}
