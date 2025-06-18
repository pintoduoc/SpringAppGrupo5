package com.duoc.SpringApp_Grupo5.Assemblers.GestionInventario;

import com.duoc.SpringApp_Grupo5.Controller.GestionInventario.ProductoController;
import com.duoc.SpringApp_Grupo5.Modelo.GestionInventario.Producto;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Component
public class ProductoModelAssembler implements RepresentationModelAssembler<Producto, EntityModel<Producto>> {

    @Override
    public EntityModel<Producto> toModel(Producto producto) {
/*
        RepresentionalModel = Permite a la clase contener una lista de Links de acceso
        EntityModel = Es un contenedor generico que adjunta la entidad mas una serie de enlaces
        LinkTo = Es un metodo que nos permite construir los Links o URL's de acceso que posee nuestro controlador
*/
        return EntityModel.of(producto,
                linkTo(methodOn(ProductoController.class).getProductoById(producto.getId_producto())).withSelfRel(),
                linkTo(methodOn(ProductoController.class).getAllProductos()).withRel("GET")
        );
    }
}
