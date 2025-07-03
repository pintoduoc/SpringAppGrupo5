package com.duoc.SpringApp_Grupo5.Service.GestionInventario;

import com.duoc.SpringApp_Grupo5.Modelo.GestionInventario.Proveedor;

import com.duoc.SpringApp_Grupo5.Repositorio.GestionInventario.ProveedorRepository;
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
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
class ProveedorServiceTest {

  @Mock
  private ProveedorRepository proveedorRepository;

  @InjectMocks
  private ProveedorService proveedorService;

  private Proveedor proveedor1;
  private Proveedor proveedor2;
  private Proveedor proveedorExistente;
  private Proveedor proveedorActualizado;

  @BeforeEach
  void setUp() {
    MockitoAnnotations.openMocks(this);

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

    proveedorExistente = new Proveedor();
    proveedorExistente.setId(3);
    proveedorExistente.setNombre("Proveedor3");
    proveedorExistente.setDireccion("Pajaritos 345");
    proveedorExistente.setContacto("Gonzalo");

    proveedorActualizado = new Proveedor();
    proveedorActualizado.setNombre("Proveedor4");
    proveedorActualizado.setDireccion("Vespucio 890");
    proveedorActualizado.setContacto("Clara");

  }

  @Test
  void testgetAllProveedores() {
    when(proveedorRepository.findAll()).thenReturn(Arrays.asList(proveedor1, proveedor2));
    List<Proveedor> proveedores = proveedorService.getAllProveedores();

    assertNotNull(proveedores);
    assertEquals(2, proveedores.size());
    verify(proveedorRepository).findAll();
  }

  @Test
  void testgetProveedorById() {
    when(proveedorRepository.findById(1)).thenReturn(Optional.of(proveedor1));
    when(proveedorRepository.existsById(1)).thenReturn(true);

    Proveedor proveedor = proveedorService.getProveedorById(1);

    assertNotNull(proveedor);
    assertEquals("Proveedor1", proveedor.getNombre());
    verify(proveedorRepository).findById(1);
    verify(proveedorRepository).existsById(1);
  }

  @Test
  void testgetProveedorContactoById() {
    when(proveedorRepository.findById(2)).thenReturn(Optional.of(proveedor2));
    when(proveedorRepository.existsById(2)).thenReturn(true);

    Proveedor proveedor = proveedorService.getProveedorById(2);

    assertNotNull(proveedor);
    assertEquals("Cristian", proveedor.getContacto());
    verify(proveedorRepository).findById(2);
    verify(proveedorRepository).existsById(2);
  }

  @Test
  void testaddProveedor() {
    Proveedor proveedor = new Proveedor();
    proveedor.setId(3);
    proveedor.setNombre("Proveedor3");
    proveedor.setDireccion("Macul 456");
    proveedor.setContacto("Pedro");

    when(proveedorRepository.save(proveedor)).thenReturn(proveedor);

    Proveedor result = proveedorService.addProveedor(proveedor);

    assertNotNull(result);
    assertEquals("Proveedor3", result.getNombre());

    verify(proveedorRepository).save(proveedor);
  }

  @Test
  void testdeleteProveedor() {
    int id = 1;

    when(proveedorRepository.existsById(id)).thenReturn(true);
    doNothing().when(proveedorRepository).deleteById(id);

    boolean resultado = proveedorService.deleteProveedor(id);

    assertTrue(resultado);
    verify(proveedorRepository).existsById(id);
    verify(proveedorRepository).deleteById(id);
  }

  /*
  @Test
  void testupdateProveedor() {
    // Mockeo findById para devolver el proveedor existente
    when(proveedorRepository.findById(3)).thenReturn(Optional.of(proveedorExistente));

    // Mockeo save para devolver el proveedor actualizado
    when(proveedorRepository.save(any(Proveedor.class))).thenReturn(proveedorExistente);

    // Ejecutamos el método
    Proveedor resultado = proveedorService.updateProveedor(3, proveedorActualizado);

    // Verificar resultados
    assertNotNull(resultado);
    assertEquals("Proveedor4", resultado.getNombre());
    assertEquals("Vespucio 890", resultado.getDireccion());
    assertEquals("Clara", resultado.getContacto());

    // Verificamos que los métodos fueron llamados
    verify(proveedorRepository).findById(3);
    verify(proveedorRepository).save(any(Proveedor.class));
  }

   */
}
