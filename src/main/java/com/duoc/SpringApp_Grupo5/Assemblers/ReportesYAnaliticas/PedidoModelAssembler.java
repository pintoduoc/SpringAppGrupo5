package com.duoc.SpringApp_Grupo5.Assemblers.ReportesYAnaliticas;

import com.duoc.SpringApp_Grupo5.Controller.ReportesYAnaliticas.PedidoController;
import com.duoc.SpringApp_Grupo5.Modelo.ReportesyAnaliticas.Pedido;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Component
public class PedidoModelAssembler implements RepresentationModelAssembler<Pedido, EntityModel<Pedido>> {
    @Override
    public EntityModel<Pedido> toModel(Pedido pedido) {
        return EntityModel.of(pedido,
                linkTo(methodOn(PedidoController.class).getPedidoById(pedido.getIdPedido())).withSelfRel(),
                linkTo(methodOn(PedidoController.class).getAllPedidos()).withRel("GET")
                );
    }
}
