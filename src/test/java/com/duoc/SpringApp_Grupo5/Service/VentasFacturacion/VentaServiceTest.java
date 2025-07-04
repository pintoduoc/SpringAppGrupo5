package com.duoc.SpringApp_Grupo5.Service.VentasFacturacion;

import com.duoc.SpringApp_Grupo5.Modelo.VentasFacturacion.Venta;
import com.duoc.SpringApp_Grupo5.Repositorio.VentasFacturacion.VentaRepository;
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

@SpringBootTest
@AutoConfigureMockMvc
@ExtendWith(MockitoExtension.class)
class VentaServiceTest {

  @Mock
  private VentaRepository ventaRepository;

  @InjectMocks
  private VentaService ventaService;

  private Venta venta1;
  private Venta venta2;

  @BeforeEach
  void setUp() {
    MockitoAnnotations.openMocks(this);
    venta1 = new Venta();
    venta1.setIdVenta(1);

    venta2 = new Venta();
    venta2.setIdVenta(2);
  }

  @Test
  void testgetAllVentas() {
    when(ventaRepository.findAll()).thenReturn(Arrays.asList(venta1, venta2));
    List<Venta> ventas = ventaService.getAllVentas();

    assertNotNull(ventas);
    assertEquals(2, ventas.size());
    verify(ventaRepository).findAll();
  }

  @Test
  void getVentaById() {
    when(ventaRepository.findById(1)).thenReturn(Optional.of(venta1));
    when(ventaRepository.existsById(1)).thenReturn(true);

    Venta venta = ventaService.getVentaById(1);
    assertNotNull(venta);
    assertEquals(1, venta.getIdVenta());
    verify(ventaRepository).findById(1);
    verify(ventaRepository).existsById(1);
  }

  @Test
  void addVenta() {
    Venta venta = new Venta();
    venta.setIdVenta(3);

    when(ventaRepository.save(venta)).thenReturn(venta);

    Venta ventaSalida = ventaService.addVenta(venta);
    assertNotNull(ventaSalida);
    assertEquals(3, ventaSalida.getIdVenta());
    verify(ventaRepository).save(venta);
  }

  @Test
  void deleteVenta() {
    int id = 3;

    when(ventaRepository.existsById(id)).thenReturn(true);
    doNothing().when(ventaRepository).deleteById(id);

    boolean result = ventaService.deleteVenta(3);
    assertTrue(result);
    verify(ventaRepository).existsById(id);
    verify(ventaRepository).deleteById(id);
  }
}
