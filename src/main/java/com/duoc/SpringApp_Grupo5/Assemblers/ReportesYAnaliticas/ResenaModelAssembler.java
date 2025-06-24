package com.duoc.SpringApp_Grupo5.Assemblers.ReportesYAnaliticas;

import com.duoc.SpringApp_Grupo5.Controller.ReportesYAnaliticas.ResenaController;
import com.duoc.SpringApp_Grupo5.Modelo.ReportesyAnaliticas.Resena;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;


@Component
public class ResenaModelAssembler implements RepresentationModelAssembler<Resena, EntityModel<Resena>> {
    @Override
    public EntityModel<Resena> toModel(Resena resena) {
        return EntityModel.of(resena,
                linkTo(methodOn(ResenaController.class).getResenaById(resena.getIdResena())).withSelfRel(),
                linkTo(methodOn(ResenaController.class).getAllResenas()).withRel("GET")
                );
    }
}
