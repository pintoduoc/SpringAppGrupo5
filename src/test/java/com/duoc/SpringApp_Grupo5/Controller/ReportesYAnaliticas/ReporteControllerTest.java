package com.duoc.SpringApp_Grupo5.Controller.ReportesYAnaliticas;

import com.duoc.SpringApp_Grupo5.Assemblers.ReportesYAnaliticas.ReporteModelAssembler;
import com.duoc.SpringApp_Grupo5.Modelo.ReportesyAnaliticas.Reporte;
import com.duoc.SpringApp_Grupo5.Service.ReportesyAnaliticas.ReporteService;
import com.duoc.SpringApp_Grupo5.Service.GestionInventario.ProductoService;

import com.fasterxml.jackson.databind.ObjectMapper;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.test.context.bean.override.mockito.MockitoBean;

import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(ReporteController.class)
class ReporteControllerTest {

  @Autowired
  private MockMvc mockMvc;

  @Autowired
  private ObjectMapper objectMapper;

  @MockitoBean
  private ReporteService reporteService;

  @MockitoBean
  private ReporteModelAssembler reporteModelAssembler;

  @MockitoBean
  private ProductoService productoService;

  private Reporte reporte1;
  private Reporte reporte2;

  @BeforeEach
  void setUp() {
    reporte1 = new Reporte();
    reporte1.setId(1);
    reporte1.setTipo("Reporte");
    reporte1.setDatos("Datos1");

    reporte2 = new Reporte();
    reporte2.setId(2);
    reporte2.setTipo("Cuadro");
    reporte1.setDatos("Datos2");
  }

  @Test
  void getAllReportes() throws Exception {
    List<Reporte> reportes = Arrays.asList(reporte1, reporte2);

    when(reporteService.getAllReportes()).thenReturn(reportes);
    CollectionModel<EntityModel<Reporte>> collectionModel = CollectionModel.of(Arrays.asList(EntityModel.of(reporte1), EntityModel.of(reporte2)));

    when(reporteModelAssembler.toCollectionModel(reportes)).thenReturn(collectionModel);

    mockMvc.perform(get("/reporte"))
      .andExpect(status().isOk())
      .andExpect(jsonPath("$._embedded.reporteList", hasSize(2)));
  }

  @Test
  void addReporte() throws Exception {
    when(reporteService.addReporte(reporte1)).thenReturn(reporte1);

    EntityModel<Reporte> entityModel = EntityModel.of(reporte1);
    when(reporteModelAssembler.toModel(reporte1)).thenReturn(entityModel);

    String json = objectMapper.writeValueAsString(entityModel);

    mockMvc.perform(post("/reporte")
      .contentType("application/json")
      .content(json))
      .andExpect(status().isOk())
      .andExpect(jsonPath("$.id").value(1));
  }

  @Test
  void getReporteById() throws Exception {
    when(reporteService.getReporteById(1)).thenReturn(reporte1);

    EntityModel<Reporte> entityModel = EntityModel.of(reporte1);
    when(reporteModelAssembler.toModel(reporte1)).thenReturn(entityModel);

    mockMvc.perform(get("/reporte/1"))
      .andExpect(status().isOk())
      .andExpect(jsonPath("$.id").value(1));
  }

  @Test
  void deleteReporte() throws Exception {
    int id = 1;

    when(reporteService.deleteReporte(id)).thenReturn(true);

    mockMvc.perform(delete("/reporte/1"))
      .andExpect(status().isOk());

  }
}
