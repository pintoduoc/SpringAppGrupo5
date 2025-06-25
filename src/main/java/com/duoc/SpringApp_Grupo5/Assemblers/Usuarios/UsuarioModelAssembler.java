package com.duoc.SpringApp_Grupo5.Assemblers.Usuarios;

import com.duoc.SpringApp_Grupo5.Controller.Usuarios.UsuarioController;
import com.duoc.SpringApp_Grupo5.Modelo.Usuarios.Usuario;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;


@Component
public class UsuarioModelAssembler implements RepresentationModelAssembler<Usuario, EntityModel<Usuario>> {
    @Override
    public EntityModel<Usuario> toModel(Usuario usuario) {
        return EntityModel.of(usuario,
                linkTo(methodOn(UsuarioController.class).getUsuarioById(usuario.getId())).withSelfRel(),
                linkTo(methodOn(UsuarioController.class).getAllUsuarios()).withRel("GET")
                );
    }
}
