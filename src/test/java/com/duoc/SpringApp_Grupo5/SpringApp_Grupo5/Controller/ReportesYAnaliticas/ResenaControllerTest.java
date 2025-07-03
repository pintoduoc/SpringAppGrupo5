package com.duoc.SpringApp_Grupo5.Controller.ReportesYAnaliticas;

import com.duoc.SpringApp_Grupo5.Assemblers.ReportesYAnaliticas.ResenaModelAssembler;
import com.duoc.SpringApp_Grupo5.Controller.ReportesYAnaliticas.ResenaController;
import com.duoc.SpringApp_Grupo5.Modelo.ReportesyAnaliticas.Resena;
import com.duoc.SpringApp_Grupo5.Service.ReportesyAnaliticas.ResenaService;

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

@WebMvcTest(ResenaController.class)
class ResenaControllerTest {

  @Autowired
  private MockMvc mockMvc;

  @Autowired
  private ObjectMapper objectMapper;

  @MockitoBean
  private ResenaService resenaService;

  @MockitoBean
  private ResenaModelAssembler resenaModelAssembler;

  private Resena resena1;
  private Resena resena2;

  @BeforeEach
  void setUp() {
    resena1 = new Resena();
    resena1.setIdResena(1);
    resena1.setCalificacion(7);
    resena1.setComentario("Buenisimo");

    resena2 = new Resena();
    resena2.setIdResena(2);
    resena2.setCalificacion(5);
    resena2.setComentario("Bueno");
  }

  @Test
  void getAllResenas() throws Exception {
    List<Resena> resenas = Arrays.asList(resena1, resena2);

    when(resenaService.getAllResenas()).thenReturn(resenas);

    CollectionModel<EntityModel<Resena>> collectionModel = CollectionModel.of(Arrays.asList(EntityModel.of(resena1), EntityModel.of(resena2)));

    when(resenaModelAssembler.toCollectionModel(resenas)).thenReturn(collectionModel);

    mockMvc.perform(get("/resena"))
      .andExpect(status().isOk())
      .andExpect(jsonPath("$._embedded.resenaList", hasSize(2)));
  }

  @Test
  void addResena() throws Exception {
    when(resenaService.addResena(resena1)).thenReturn(resena1);

    EntityModel<Resena> entityModel = EntityModel.of(resena1);
    when(resenaModelAssembler.toModel(resena1)).thenReturn(entityModel);

    String resenaJson = objectMapper.writeValueAsString(entityModel);

    mockMvc.perform(post("/resena")
      .contentType("application/json")
      .content(resenaJson))
      .andExpect(status().isOk())
      .andExpect(jsonPath("$.idResena").value(1));
  }

  @Test
  void getResenaById() throws Exception {
    when(resenaService.getResenaById(1)).thenReturn(resena1);

    EntityModel<Resena> entityModel = EntityModel.of(resena1);
    when(resenaModelAssembler.toModel(resena1)).thenReturn(entityModel);

    mockMvc.perform(get("/resena/1"))
      .andExpect(status().isOk())
      .andExpect(jsonPath("$.idResena").value(1));
  }

  @Test
  void deleteResena() throws Exception {
    int idResena = 2;

    when(resenaService.deleteResena(idResena)).thenReturn(true);

    mockMvc.perform(delete("/resena/" + idResena))
      .andExpect(status().isOk());
  }
}
