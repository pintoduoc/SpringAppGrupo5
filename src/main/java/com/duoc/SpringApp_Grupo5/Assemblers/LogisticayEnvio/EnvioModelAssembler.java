package com.duoc.SpringApp_Grupo5.Assemblers.LogisticayEnvio;

import com.duoc.SpringApp_Grupo5.Controller.LogisticayEnvio.EnvioController;
import com.duoc.SpringApp_Grupo5.Modelo.LogisticayEnvio.Envio;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Component
public class EnvioModelAssembler implements RepresentationModelAssembler<Envio, EntityModel<Envio>> {
    @Override
    public EntityModel<Envio> toModel(Envio envio) {
        return EntityModel.of(envio,
                linkTo(methodOn(EnvioController.class).getEnvioById(envio.getIdEnvio())).withSelfRel(),
                linkTo(methodOn(EnvioController.class).getAllEnvios()).withRel("GET")
                );
    }
}
