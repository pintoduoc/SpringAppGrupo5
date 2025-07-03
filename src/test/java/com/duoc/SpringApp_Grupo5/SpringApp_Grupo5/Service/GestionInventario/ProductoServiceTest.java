package com.duoc.SpringApp_Grupo5.Service.GestionInventario;

import com.duoc.SpringApp_Grupo5.Modelo.GestionInventario.Producto;
import com.duoc.SpringApp_Grupo5.Service.GestionInventario.ProductoService;
import com.duoc.SpringApp_Grupo5.Repositorio.GestionInventario.ProductoRepository;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
class ProductoServiceTest {

  @Mock
  private ProductoRepository productoRepository;

  @InjectMocks
  private ProductoService productoService;

  private Producto producto1;
  private Producto producto2;

  @BeforeEach
  void setUp() {
    MockitoAnnotations.openMocks(this);

    producto1 = new Producto();
    producto1.setId_producto(1);
    producto1.setStock(10);
    //producto1.setProveedor(1);
    producto1.setNombre("Tele Phillips");
    producto1.setDescripcion("Televisor 23");
    producto1.setCategoria("Electronica");
    producto1.setPrecio(100);

    producto2 = new Producto();
    producto2.setId_producto(2);
    producto2.setStock(50);
    //producto2.setProveedor(2);
    producto2.setNombre("Horno Teka");
    producto2.setDescripcion("Cocina");
    producto2.setCategoria("Electrodomesticos");
    producto2.setPrecio(85);
  }

  @Test
  void testgetAllProductos() {
    when(productoRepository.findAll()).thenReturn(Arrays.asList(producto1, producto2));
    List<Producto> productos = productoService.getAllProductos();

    assertNotNull(productos);
    assertEquals(2, productos.size());
    verify(productoRepository).findAll();
  }

  @Test
  void testgetProductoById() {
    when(productoRepository.findById(1)).thenReturn(Optional.of(producto1));
    when(productoRepository.existsById(1)).thenReturn(true);

    Producto resultado = productoService.getProductoById(1);
    assertNotNull(resultado);
    assertEquals("Tele Phillips", resultado.getNombre());
    verify(productoRepository).findById(1);
    verify(productoRepository).existsById(1);

  }

  @Test
  void testgetProductoCategoriaById() {
    when(productoRepository.findById(2)).thenReturn(Optional.of(producto2));
    when(productoRepository.existsById(2)).thenReturn(true);

    Producto resultado = productoService.getProductoById(2);
    assertNotNull(resultado);
    assertEquals("Electrodomesticos", resultado.getCategoria());
    verify(productoRepository).findById(2);
    verify(productoRepository).existsById(2);
  }

  @Test
  void updateProducto() {
  }
}
