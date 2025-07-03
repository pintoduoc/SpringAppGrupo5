package com.duoc.SpringApp_Grupo5.Controller.GestionInventario;

import com.duoc.SpringApp_Grupo5.Assemblers.GestionInventario.ProveedorModelAssembler;
import com.duoc.SpringApp_Grupo5.Modelo.GestionInventario.Proveedor;
import com.duoc.SpringApp_Grupo5.Service.GestionInventario.ProveedorService;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.test.context.bean.override.mockito.MockitoBean;

import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(ProveedorController.class)
class ProveedorControllerTest {

  @Autowired
  private MockMvc mockMvc;

  @Autowired
  private ObjectMapper objectMapper;

  @MockitoBean
  private ProveedorService proveedorService;

  @MockitoBean
  private ProveedorModelAssembler proveedorModelAssembler;

  private Proveedor proveedor1;
  private Proveedor proveedor2;

  @BeforeEach
  void setUp() {
    proveedor1 = new Proveedor();
    proveedor1.setId(1);
    proveedor1.setNombre("Proveedor1");
    proveedor1.setDireccion("Grecia 10590");
    proveedor1.setContacto("Nicolas");

    proveedor2 = new Proveedor();
    proveedor2.setId(1);
    proveedor2.setNombre("Proveedor2");
    proveedor2.setDireccion("Av Matta 234");
    proveedor2.setContacto("Cristian");
  }

  @Test
  void getAllProveedores() throws Exception {
    List<Proveedor> proveedores = Arrays.asList(proveedor1, proveedor2);

    when(proveedorService.getAllProveedores()).thenReturn(proveedores);

    CollectionModel<EntityModel<Proveedor>> collectionModel = CollectionModel.of(Arrays.asList(EntityModel.of(proveedor1),  EntityModel.of(proveedor2)));

    when(proveedorModelAssembler.toCollectionModel(proveedores)).thenReturn(collectionModel);

    mockMvc.perform(get("/proveedor"))
      .andExpect(status().isOk())
      .andExpect(jsonPath("$._embedded.proveedorList", hasSize(2)));
  }

  @Test
  void addProveedor() throws Exception {
    when(proveedorService.addProveedor(proveedor1)).thenReturn(proveedor1);

    EntityModel<Proveedor> entityModel = EntityModel.of(proveedor1);
    when(proveedorModelAssembler.toModel(proveedor1)).thenReturn(entityModel);

    String jsonRequest = objectMapper.writeValueAsString(entityModel);

    mockMvc.perform(post("/proveedor")
      .contentType("application/json")
      .content(jsonRequest))
      .andExpect(status().isOk())
      .andExpect(jsonPath("$.id").value(1));
  }

  @Test
  void getProveedor() throws Exception {
    when(proveedorService.getProveedorById(1)).thenReturn(proveedor1);
    EntityModel<Proveedor> entityModel = EntityModel.of(proveedor1);
    when(proveedorModelAssembler.toModel(proveedor1)).thenReturn(entityModel);
    String jsonRequest = objectMapper.writeValueAsString(entityModel);
    mockMvc.perform(get("/proveedor/{id}", 1))
      .andExpect(status().isOk())
      .andExpect(jsonPath("$.id").value(1));
  }

  @Test
  void deleteProveedor() throws Exception {
    int id = 1;

    when(proveedorService.deleteProveedor(1)).thenReturn(true);

    mockMvc.perform(delete("/proveedor/{id}", 1))
      .andExpect(status().isOk());
  }

}
