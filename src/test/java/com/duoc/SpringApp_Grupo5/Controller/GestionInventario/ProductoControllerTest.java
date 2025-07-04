package com.duoc.SpringApp_Grupo5.Controller.GestionInventario;

import com.duoc.SpringApp_Grupo5.Assemblers.GestionInventario.ProductoModelAssembler;
import com.duoc.SpringApp_Grupo5.Modelo.GestionInventario.Producto;
import com.duoc.SpringApp_Grupo5.Service.GestionInventario.ProductoService;
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

@WebMvcTest(ProductoController.class)
class ProductoControllerTest {

  @Autowired
  private MockMvc mockMvc;

  @Autowired
  private ObjectMapper objectMapper;

  @MockitoBean
  private ProductoService productoService;

  @MockitoBean
  private ProductoModelAssembler productoModelAssembler;

  private Producto producto1;
  private Producto producto2;

  @BeforeEach
  void setUp() {
    producto1 = new Producto();
    producto1.setId_producto(1);
    producto1.setStock(10);
    producto1.setNombre("Tele Phillips");
    producto1.setDescripcion("Televisor 23");
    producto1.setCategoria("Electronica");
    producto1.setPrecio(100);

    producto2 = new Producto();
    producto2.setId_producto(2);
    producto2.setStock(50);
    producto2.setNombre("Horno Teka");
    producto2.setDescripcion("Cocina");
    producto2.setCategoria("Electrodomesticos");
    producto2.setPrecio(85);
  }

  @Test
  void getAllProductos() throws Exception {
    List<Producto> productos = Arrays.asList(producto1, producto2);

    when(productoService.getAllProductos()).thenReturn(productos);
    CollectionModel<EntityModel<Producto>> collectionModel = CollectionModel.of(Arrays.asList(EntityModel.of(producto1), EntityModel.of(producto2)));

    when(productoModelAssembler.toCollectionModel(productos)).thenReturn(collectionModel);

    mockMvc.perform(get("/producto"))
      .andExpect(status().isOk())
      .andExpect(jsonPath("$._embedded.productoList",  hasSize(2)));
  }

  @Test
  void addProducto() throws Exception {
    when(productoService.addProducto(producto1)).thenReturn(producto1);
    EntityModel<Producto> entityModel = EntityModel.of(producto1);
    when(productoModelAssembler.toModel(producto1)).thenReturn(entityModel);

    String jsonRequest = objectMapper.writeValueAsString(entityModel);
    mockMvc.perform(post("/producto")
      .content(jsonRequest)
      .contentType("application/json"))
      .andExpect(status().isOk())
      .andExpect(jsonPath("$.id_producto").value(1));

  }

  @Test
  void getProductoById() throws Exception {
    when(productoService.getProductoById(1)).thenReturn(producto1);

    EntityModel<Producto> entityModel = EntityModel.of(producto1);
    when(productoModelAssembler.toModel(producto1)).thenReturn(entityModel);

    mockMvc.perform(get("/producto/1"))
      .andExpect(status().isOk())
      .andExpect(jsonPath("$.id_producto").value(1));
  }

  @Test
  void deleteProducto() throws Exception {
    int id = 1;
    when(productoService.deleteProducto(id)).thenReturn(Boolean.TRUE);

    mockMvc.perform(delete("/producto/1"))
      .andExpect(status().isOk());
  }
}
