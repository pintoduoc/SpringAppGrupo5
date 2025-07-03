package com.duoc.SpringApp_Grupo5.Controller.VentasFacturacion;

import com.duoc.SpringApp_Grupo5.Assemblers.VentasFacturacion.VentaModelAssembler;
import com.duoc.SpringApp_Grupo5.Modelo.VentasFacturacion.Venta;
import com.duoc.SpringApp_Grupo5.Service.VentasFacturacion.VentaService;

import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.test.context.bean.override.mockito.MockitoBean;

import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.*;

import com.fasterxml.jackson.databind.ObjectMapper;

@WebMvcTest(VentaController.class)
class VentaControllerTest {

  @Autowired
  private MockMvc mockMvc;

  @Autowired
  private ObjectMapper objectMapper;

  @MockitoBean
  private VentaService ventaService;

  @MockitoBean
  private VentaModelAssembler ventaModelAssembler;

  private Venta venta1;
  private Venta venta2;

  @BeforeEach
  void setUp() {
    venta1 = new Venta();
    venta1.setIdVenta(1);

    venta2 = new Venta();
    venta2.setIdVenta(2);
  }

  @Test
  void getAllVentas() throws Exception {
    List<Venta> ventas = Arrays.asList(venta1, venta2);

    when(ventaService.getAllVentas()).thenReturn(ventas);

    CollectionModel<EntityModel<Venta>> collectionModel = CollectionModel.of(Arrays.asList(EntityModel.of(venta1), EntityModel.of(venta2)));

    when(ventaModelAssembler.toCollectionModel(ventas)).thenReturn(collectionModel);

    mockMvc.perform(get("/venta"))
      .andExpect(status().isOk())
      .andExpect(jsonPath("$._embedded.ventaList", hasSize(2)));
  }

  @Test
  void addVenta() throws Exception {
    when(ventaService.addVenta(venta1)).thenReturn(venta1);

    EntityModel<Venta> entityModel = EntityModel.of(venta1);
    when(ventaModelAssembler.toModel(venta1)).thenReturn(entityModel);

    String jsonRequest = objectMapper.writeValueAsString(entityModel);

    mockMvc.perform(post("/venta")
        .contentType("application/json")
        .content(jsonRequest))
      .andExpect(status().isOk())
      .andExpect(jsonPath("$.idVenta").value(1));
  }

  @Test
  void getVentaById() throws Exception {
    when(ventaService.getVentaById(1)).thenReturn(venta1);

    EntityModel<Venta> entityModel = EntityModel.of(venta1);
    when(ventaModelAssembler.toModel(venta1)).thenReturn(entityModel);

    mockMvc.perform(get("/venta/1"))
      .andExpect(status().isOk())
      .andExpect(jsonPath("$.idVenta").value(1));
  }

  @Test
  void deleteVenta() throws Exception {
    int idVenta = 1;

    when(ventaService.deleteVenta(idVenta)).thenReturn(true);

    mockMvc.perform(delete("/venta/" + idVenta))
      .andExpect(status().isOk());
  }
}
