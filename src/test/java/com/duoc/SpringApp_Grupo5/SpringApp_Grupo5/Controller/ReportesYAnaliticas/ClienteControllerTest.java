package com.duoc.SpringApp_Grupo5.Controller.ReportesYAnaliticas;

import com.duoc.SpringApp_Grupo5.Assemblers.ReportesYAnaliticas.ClienteModelAssembler;
import com.duoc.SpringApp_Grupo5.Modelo.ReportesyAnaliticas.Cliente;
import com.duoc.SpringApp_Grupo5.Service.ReportesyAnaliticas.ClienteService;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
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

@WebMvcTest(ClienteController.class)
class ClienteControllerTest {

  @Autowired
  private MockMvc mockMvc;

  @Autowired
  private ObjectMapper objectMapper;

  @MockitoBean
  private ClienteService clienteService;

  @MockitoBean
  private ClienteModelAssembler clienteModelAssembler;

  private Cliente cliente1;
  private Cliente cliente2;

  @BeforeEach
  void setUp() {
    cliente1 = new Cliente();
    cliente1.setIdCliente(1);
    cliente1.setDireccionCliente("Alameda 777");
    cliente1.setEmailCliente("pedro@gmail.com");
    cliente1.setNombreCliente("Pedro");

    cliente2 = new Cliente();
    cliente2.setIdCliente(2);
    cliente2.setDireccionCliente("Providencia 1234");
    cliente2.setEmailCliente("juan@gmail.com");
    cliente2.setNombreCliente("Juan");
  }

  @Test
  void getAllClientes() throws Exception {
    List<Cliente> clientes = Arrays.asList(cliente1, cliente2);

    when(clienteService.getAllClientes()).thenReturn(clientes);

    CollectionModel<EntityModel<Cliente>> collectionModelClientes = CollectionModel.of(Arrays.asList(EntityModel.of(cliente1), EntityModel.of(cliente2)));

    when(clienteModelAssembler.toCollectionModel(clientes)).thenReturn(collectionModelClientes);

    mockMvc.perform(get("/cliente"))
      .andExpect(status().isOk())
      .andExpect(jsonPath("$._embedded.clienteList", hasSize(2)));
  }

  @Test
  void addCliente() throws Exception {
    when(clienteService.addCliente(cliente1)).thenReturn(cliente1);

    EntityModel<Cliente> entityModelCliente = EntityModel.of(cliente1);
    when(clienteModelAssembler.toModel(cliente1)).thenReturn(entityModelCliente);

    String jsonRequest = objectMapper.writeValueAsString(entityModelCliente);

    mockMvc.perform(post("/cliente")
      .contentType("application/json")
      .content(jsonRequest))
      .andExpect(status().isOk())
      .andExpect(jsonPath("$.idCliente").value(1));
  }

  @Test
  void getClienteById() throws Exception {
    when(clienteService.getClienteById(1)).thenReturn(cliente1);

    EntityModel<Cliente> entityModelCliente = EntityModel.of(cliente1);
    when(clienteModelAssembler.toModel(cliente1)).thenReturn(entityModelCliente);

    mockMvc.perform(get("/cliente/1"))
      .andExpect(status().isOk())
      .andExpect(jsonPath("$.idCliente").value(1));
  }

  @Test
  void deleteCliente() throws Exception {
    int idCliente = 1;

    when(clienteService.deleteCliente(idCliente)).thenReturn(true);

    mockMvc.perform(delete("/cliente/1"))
      .andExpect(status().isOk());
  }

}
