package com.duoc.SpringApp_Grupo5.Service.LogisticayEnvio;

import com.duoc.SpringApp_Grupo5.Modelo.LogisticayEnvio.Envio;
import com.duoc.SpringApp_Grupo5.Repositorio.LogisticayEnvio.EnvioRepository;
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
class EnvioServiceTest {

  @Mock
  private EnvioRepository envioRepository;

  @InjectMocks
  private EnvioService envioService;

  private Envio envio1;
  private Envio envio2;

  @BeforeEach
  void setUp() {
    envio1 = new Envio();
    envio1.setIdEnvio(1);
    envio1.setDireccionEnvio("Alameda 345");
    envio1.setEstadoEnvio("Enviado");

    envio2 = new Envio();
    envio2.setIdEnvio(2);
    envio2.setDireccionEnvio("Colon 456");
    envio2.setEstadoEnvio("Entregado");
  }
  @Test
  void testgetAllEnvios() {
    when(envioRepository.findAll()).thenReturn(Arrays.asList(envio1, envio2));

    List<Envio> envios = envioService.getAllEnvios();

    assertNotNull(envios);
    assertEquals(envios.size(), 2);
    verify(envioRepository).findAll();
  }

  @Test
  void testgetEnvioById() {
    when(envioRepository.findById(1)).thenReturn(Optional.of(envio1));
    when(envioRepository.existsById(1)).thenReturn(true);

    Envio envio = envioService.getEnvioById(1);

    assertNotNull(envio);
    assertEquals(1, envio.getIdEnvio());
    verify(envioRepository).findById(1);
    verify(envioRepository).existsById(1);
  }

  @Test
  void testgetEnvioEstadoById() {
    when(envioRepository.findById(1)).thenReturn(Optional.of(envio1));
    when(envioRepository.existsById(1)).thenReturn(true);

    Envio envio = envioService.getEnvioById(1);

    assertNotNull(envio);
    assertEquals("Enviado", envio.getEstadoEnvio());
    verify(envioRepository).findById(1);
    verify(envioRepository).existsById(1);
  }

  @Test
  void testaddEnvio() {
    Envio envio = new Envio();

    envio.setIdEnvio(3);
    envio.setDireccionEnvio("Vicuna Mackenna 345");
    envio.setEstadoEnvio("Entregado");

    when(envioRepository.save(envio)).thenReturn(envio);

    Envio result = envioService.addEnvio(envio);
    assertNotNull(result);
    assertEquals("Entregado",  result.getEstadoEnvio());

    verify(envioRepository).save(envio);
  }

  @Test
  void deleteEnvio() {
    int id = 1;

    when(envioRepository.existsById(id)).thenReturn(true);
    doNothing().when(envioRepository).deleteById(id);

    boolean resultado = envioService.deleteEnvio(1);

    assertTrue(resultado);
    verify(envioRepository).existsById(id);
    verify(envioRepository).deleteById(id);
  }

  @Test
  void updateEnvio() {
  }
}
