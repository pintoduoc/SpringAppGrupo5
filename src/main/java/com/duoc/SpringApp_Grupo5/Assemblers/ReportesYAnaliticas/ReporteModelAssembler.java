package com.duoc.SpringApp_Grupo5.Assemblers.ReportesYAnaliticas;

import com.duoc.SpringApp_Grupo5.Controller.ReportesYAnaliticas.ReporteController;
import com.duoc.SpringApp_Grupo5.Modelo.ReportesyAnaliticas.Reporte;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Component
public class ReporteModelAssembler implements RepresentationModelAssembler<Reporte, EntityModel<Reporte>> {
    @Override
    public EntityModel<Reporte> toModel(Reporte reporte) {
        return EntityModel.of(reporte,
                linkTo(methodOn(ReporteController.class).getReporteById(reporte.getId())).withSelfRel(),
                linkTo(methodOn(ReporteController.class).getAllReportes()).withRel("GET")
                );
    }
}
