package com.duoc.SpringApp_Grupo5.Service.ReportesyAnaliticas;

import com.duoc.SpringApp_Grupo5.Modelo.LogisticayEnvio.Envio;
import com.duoc.SpringApp_Grupo5.Modelo.ReportesyAnaliticas.Pedido;
import com.duoc.SpringApp_Grupo5.Repositorio.ReportesyAnaliticas.PedidoRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
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
class PedidoServiceTest {

  @Mock
  private PedidoRepository pedidoRepository;

  @InjectMocks
  private PedidoService pedidoService;

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
  void testgetAllPedidos() {
    when(pedidoRepository.findAll()).thenReturn(Arrays.asList(pedido1, pedido2));

    List<Pedido> pedidos = pedidoService.getAllPedidos();

    assertNotNull(pedidos);
    assertEquals(2, pedidos.size());
    verify(pedidoRepository).findAll();
  }

  @Test
  void testgetPedidoById() {
    when(pedidoRepository.findById(1)).thenReturn(Optional.of(pedido1));
    when(pedidoRepository.existsById(1)).thenReturn(true);

    Pedido pedido = pedidoService.getPedidoById(1);

    assertNotNull(pedido);
    assertEquals(1, pedido.getIdPedido());
    verify(pedidoRepository).findById(1);
    verify(pedidoRepository).existsById(1);
  }

  @Test
  void testaddPedido() {
    Pedido pedido = new Pedido();

    pedido.setIdPedido(3);
    pedido.setEstado("Pendiente");

    when(pedidoRepository.save(pedido)).thenReturn(pedido);

    Pedido result = pedidoService.addPedido(pedido);

    assertNotNull(result);
    assertEquals("Pendiente",  result.getEstado());

    verify(pedidoRepository).save(pedido);
  }

  @Test
  void deletePedido() {
    int id = 1;

    when(pedidoRepository.existsById(id)).thenReturn(true);
    doNothing().when(pedidoRepository).deleteById(id);

    boolean result = pedidoService.deletePedido(1);

    assertTrue(result);
    verify(pedidoRepository).existsById(id);
    verify(pedidoRepository).deleteById(id);
  }

  @Test
  void updatePedido() {
  }
}
