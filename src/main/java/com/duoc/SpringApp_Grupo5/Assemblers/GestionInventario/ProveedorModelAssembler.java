package com.duoc.SpringApp_Grupo5.Assemblers.GestionInventario;

import com.duoc.SpringApp_Grupo5.Controller.GestionInventario.ProveedorController;
import com.duoc.SpringApp_Grupo5.Modelo.GestionInventario.Proveedor;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;


@Component
public class ProveedorModelAssembler implements RepresentationModelAssembler<Proveedor, EntityModel<Proveedor>> {

    @Override
    public EntityModel<Proveedor> toModel(Proveedor proveedor) {
        return EntityModel.of(proveedor,
                linkTo(methodOn(ProveedorController.class).getProveedor(proveedor.getId())).withSelfRel(),
                linkTo(methodOn(ProveedorController.class).getAllProveedores()).withRel("GET")
        );
    }
}
