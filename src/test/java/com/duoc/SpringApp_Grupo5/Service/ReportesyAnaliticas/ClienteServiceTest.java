package com.duoc.SpringApp_Grupo5.Service.ReportesyAnaliticas;

import com.duoc.SpringApp_Grupo5.Modelo.ReportesyAnaliticas.Cliente;
import com.duoc.SpringApp_Grupo5.Repositorio.ReportesyAnaliticas.ClienteRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.stubbing.OngoingStubbing;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.hamcrest.Matchers.any;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
class ClienteServiceTest {

  @Mock
  private ClienteRepository clienteRepository;

  @InjectMocks
  private ClienteService clienteService;

  private Cliente cliente1;
  private Cliente cliente2;

  @BeforeEach
  void setUp() {
    MockitoAnnotations.openMocks(this);

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
  void testgetAllClientes() {
    when(clienteRepository.findAll()).thenReturn(Arrays.asList(cliente1, cliente2));
    List<Cliente> clientes = clienteService.getAllClientes();

    assertNotNull(clientes);
    assertEquals(2, clientes.size());
    verify(clienteRepository).findAll();
  }

  @Test
  void testgetClienteNombreById() {
    when(clienteRepository.existsById(1)).thenReturn(true);
    when(clienteRepository.findById(1)).thenReturn(Optional.of(cliente1));

    Cliente resultado = clienteService.getClienteById(1);
    assertNotNull(resultado);
    assertEquals("Pedro", resultado.getNombreCliente());
    verify(clienteRepository).existsById(1);
    verify(clienteRepository).findById(1);
  }

  @Test
  void testgetClienteDireccionById() {
    when(clienteRepository.existsById(2)).thenReturn(true);
    when(clienteRepository.findById(2)).thenReturn(Optional.of(cliente2));

    Cliente resultado = clienteService.getClienteById(2);
    assertNotNull(resultado);
    assertEquals("Providencia 1234", resultado.getDireccionCliente());
    verify(clienteRepository).existsById(2);
    verify(clienteRepository).findById(2);
  }

  @Test
  void testUpdateCliente() {
  }

}
