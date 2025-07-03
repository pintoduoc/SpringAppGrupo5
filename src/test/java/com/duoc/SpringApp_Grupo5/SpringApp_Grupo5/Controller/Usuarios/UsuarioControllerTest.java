package com.duoc.SpringApp_Grupo5.Controller.Usuarios;

import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;

import com.duoc.SpringApp_Grupo5.Assemblers.Usuarios.UsuarioModelAssembler;
import com.duoc.SpringApp_Grupo5.Modelo.Usuarios.Usuario;
import com.duoc.SpringApp_Grupo5.Service.GestionInventario.ProductoService;
import com.duoc.SpringApp_Grupo5.Service.Usuarios.UsuarioService;

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

@WebMvcTest(UsuarioController.class)
class UsuarioControllerTest {

  @Autowired
  private MockMvc mockMvc;

  @MockitoBean
  private UsuarioService usuarioService;

  @MockitoBean
  private ProductoService productoService;

  @MockitoBean
  private UsuarioModelAssembler assembler;

  private Usuario usuario1;
  private Usuario usuario2;
    @Autowired
    private ObjectMapper objectMapper;
    @Autowired
    private UsuarioModelAssembler usuarioModelAssembler;

  @BeforeEach
  void setUp() {
    usuario1 = new Usuario();
    usuario1.setId(1);
    usuario1.setContrasena("password");
    usuario1.setNombre("Juan");
    usuario1.setEmail("juan@gmail.com");
    usuario1.setEstado(true);
    usuario1.setRol("Administrador");

    usuario2 = new Usuario();
    usuario2.setId(2);
    usuario2.setContrasena("clave");
    usuario2.setNombre("Jose");
    usuario2.setEmail("jose@gmail.com");
    usuario2.setEstado(true);
    usuario2.setRol("Bodega");
  }

  @Test
  void getAllUsuarios() throws Exception {
    List<Usuario> usuarios  = Arrays.asList(usuario1, usuario2);

    // Mockeamos el servicio para devolver la lista
    when(usuarioService.getAllUsuarios()).thenReturn(usuarios);

    CollectionModel<EntityModel<Usuario>> collectionModel = CollectionModel.of(Arrays.asList(EntityModel.of(usuario1), EntityModel.of(usuario2)));

    when(assembler.toCollectionModel(usuarios)).thenReturn(collectionModel);

    // Probamos la respuesta GET
    mockMvc.perform(get("/usuario"))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$._embedded.usuarioList", hasSize(2)));
  }

  @Test
  void getUsuarioById() throws Exception {
    when(usuarioService.getUsuarioById(1)).thenReturn(usuario1);

    EntityModel<Usuario> entityModel = EntityModel.of(usuario1);
    when(assembler.toModel(usuario1)).thenReturn(entityModel);

    mockMvc.perform(get("/usuario/1"))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.id").value(1));
  }

  @Test
  void addUsuario() throws Exception {

    when(usuarioService.addUsuario(usuario1)).thenReturn(usuario1);

    EntityModel<Usuario> entityModel = EntityModel.of(usuario1);
    when(usuarioModelAssembler.toModel(usuario1)).thenReturn(entityModel);

    String jsonRequest = objectMapper.writeValueAsString(usuario1);

    mockMvc.perform(post("/usuario")
                    .contentType("application/json")
                    .content(jsonRequest))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.id").value(1))
            .andExpect(jsonPath("$.nombre").value("Juan"))
            .andExpect(jsonPath("$.email").value("juan@gmail.com"));

  }

  @Test
  void deleteUsuario() throws Exception {
    int usuarioId = 1;

    when(usuarioService.deleteUsuario(usuarioId)).thenReturn(true);

    mockMvc.perform(delete("/usuario/{id}", usuarioId))
            .andExpect(status().isOk());
  }
}
