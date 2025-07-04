package com.duoc.SpringApp_Grupo5.Controller.ReportesYAnaliticas;

import com.duoc.SpringApp_Grupo5.Assemblers.ReportesYAnaliticas.PedidoModelAssembler;
import com.duoc.SpringApp_Grupo5.Modelo.ReportesyAnaliticas.Pedido;
import com.duoc.SpringApp_Grupo5.Service.ReportesyAnaliticas.PedidoService;

import com.fasterxml.jackson.databind.ObjectMapper;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
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

@WebMvcTest(PedidoController.class)
class PedidoControllerTest {

  @Autowired
  private MockMvc mockMvc;

  @Autowired
  private ObjectMapper objectMapper;

  @MockitoBean
  private PedidoService pedidoService;

  @MockitoBean
  private PedidoModelAssembler pedidoModelAssembler;

  private Pedido pedido1;
  private Pedido pedido2;

  @BeforeEach
  void setUp() {
    pedido1 = new Pedido();
    pedido1.setIdPedido(1);
    pedido1.setEstado("Enviado");

    pedido2 = new Pedido();
    pedido2.setIdPedido(2);
    pedido2.setEstado("Pendiente");
  }

  @Test
  void getAllPedidos() throws Exception {
    List<Pedido> pedidos = Arrays.asList(pedido1, pedido2);

    when(pedidoService.getAllPedidos()).thenReturn(pedidos);

    CollectionModel<EntityModel<Pedido>> collectionModel = CollectionModel.of(Arrays.asList(EntityModel.of(pedido1), EntityModel.of(pedido2)));

    when(pedidoModelAssembler.toCollectionModel(pedidos)).thenReturn(collectionModel);

    mockMvc.perform(get("/pedido"))
      .andExpect(status().isOk())
      .andExpect(jsonPath("$._embedded.pedidoList", hasSize(2)));

  }

  @Test
  void addPedido() throws Exception {
    when(pedidoService.addPedido(pedido1)).thenReturn(pedido1);

    EntityModel<Pedido> entityModel = EntityModel.of(pedido1);
    when(pedidoModelAssembler.toModel(pedido1)).thenReturn(entityModel);

    String jsonRequest = objectMapper.writeValueAsString(entityModel);

    mockMvc.perform(post("/pedido")
        .contentType("application/json")
        .content(jsonRequest))
      .andExpect(status().isOk())
      .andExpect(jsonPath("$.idPedido").value(1));

  }

  @Test
  void getPedidoById() throws Exception {
    when(pedidoService.getPedidoById(1)).thenReturn(pedido1);

    EntityModel<Pedido> entityModel = EntityModel.of(pedido1);
    when(pedidoModelAssembler.toModel(pedido1)).thenReturn(entityModel);

    mockMvc.perform(get("/pedido/1", 1))
      .andExpect(status().isOk())
      .andExpect(jsonPath("$.idPedido").value(1));
  }

  @Test
  void deletePedido() throws Exception {
    int idPedido = 1;

    when(pedidoService.deletePedido(idPedido)).thenReturn(true);

    mockMvc.perform(delete("/pedido/1", 1))
      .andExpect(status().isOk());
  }
}
