package com.duoc.SpringApp_Grupo5.Assemblers.VentasFacturacion;

import com.duoc.SpringApp_Grupo5.Controller.VentasFacturacion.VentaController;
import com.duoc.SpringApp_Grupo5.Modelo.VentasFacturacion.Venta;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;


@Component
public class VentaModelAssembler implements RepresentationModelAssembler<Venta, EntityModel<Venta>> {
    @Override
    public EntityModel<Venta> toModel(Venta venta) {
        return EntityModel.of(venta,
                linkTo(methodOn(VentaController.class).getVentaById(venta.getIdVenta())).withSelfRel(),
                linkTo(methodOn(VentaController.class).getAllVentas()).withRel("GET")
        );
    }
}
