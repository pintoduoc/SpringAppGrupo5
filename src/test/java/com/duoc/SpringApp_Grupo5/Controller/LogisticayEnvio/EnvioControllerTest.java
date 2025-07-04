package com.duoc.SpringApp_Grupo5.Controller.LogisticayEnvio;

import com.duoc.SpringApp_Grupo5.Assemblers.LogisticayEnvio.EnvioModelAssembler;
import com.duoc.SpringApp_Grupo5.Modelo.LogisticayEnvio.Envio;
import com.duoc.SpringApp_Grupo5.Service.LogisticayEnvio.EnvioService;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(EnvioController.class)
class EnvioControllerTest {

  @Autowired
  private MockMvc mockMvc;

  @Autowired
  private ObjectMapper objectMapper;

  @MockitoBean
  private EnvioService envioService;

  @MockBean
  private EnvioModelAssembler envioModelAssembler;

  private Envio envio1;
  private Envio envio2;

  @BeforeEach
  void setUp() {
    envio1 = new Envio();
    envio1.setIdEnvio(1);
    envio1.setDireccionEnvio("Alameda 345");
    envio1.setEstadoEnvio("Enviado");

    envio2 = new Envio();
    envio2.setIdEnvio(2);
    envio2.setDireccionEnvio("Colon 456");
    envio2.setEstadoEnvio("Entregado");
  }

  @Test
  void getAllEnvios() throws Exception {
    List<Envio> envios = Arrays.asList(envio1, envio2);

    when(envioService.getAllEnvios()).thenReturn(envios);

    CollectionModel<EntityModel<Envio>> collectionModel = CollectionModel.of(Arrays.asList(EntityModel.of(envio1), EntityModel.of(envio2)));

    when(envioModelAssembler.toCollectionModel(envios)).thenReturn(collectionModel);

    mockMvc.perform(get("/envio"))
      .andExpect(status().isOk())
      .andExpect(jsonPath("$._embedded.envioList", hasSize(2)));

  }

  @Test
  void addEnvio() throws Exception {
    when(envioService.addEnvio(envio1)).thenReturn(envio1);

    EntityModel<Envio> entityModel = EntityModel.of(envio1);
    when(envioModelAssembler.toModel(envio1)).thenReturn(entityModel);

    String json = objectMapper.writeValueAsString(entityModel);

    mockMvc.perform(post("/envio")
      .contentType("application/json")
      .content(json))
      .andExpect(status().isOk())
      .andExpect(jsonPath("$.idEnvio").value(1));

  }

  @Test
  void getEnvioById() throws Exception {
    when(envioService.getEnvioById(1)).thenReturn(envio1);

    EntityModel<Envio> entityModel = EntityModel.of(envio1);
    when(envioModelAssembler.toModel(envio1)).thenReturn(entityModel);

    mockMvc.perform(get("/envio/1"))
      .andExpect(status().isOk())
      .andExpect(jsonPath("$.idEnvio").value(1));
  }

  @Test
  void deleteEnvio() throws Exception {
    int idEnvio = 1;

    when(envioService.deleteEnvio(idEnvio)).thenReturn(Boolean.TRUE);

    mockMvc.perform(delete("/envio/" + idEnvio))
      .andExpect(status().isOk());
  }
}
