package com.duoc.SpringApp_Grupo5.Service.ReportesyAnaliticas;

import com.duoc.SpringApp_Grupo5.Modelo.LogisticayEnvio.Envio;
import com.duoc.SpringApp_Grupo5.Modelo.ReportesyAnaliticas.Resena;
import com.duoc.SpringApp_Grupo5.Repositorio.ReportesyAnaliticas.ReporteRepository;
import com.duoc.SpringApp_Grupo5.Repositorio.ReportesyAnaliticas.ResenaRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
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
class ResenaServiceTest {

  @Mock
  private ResenaRepository resenaRepository;

  @InjectMocks
  private ResenaService resenaService;

  private Resena resena1;
  private Resena resena2;

  @BeforeEach
  void setUp() {
    MockitoAnnotations.openMocks(this);
    resena1 = new Resena();
    resena1.setIdResena(1);
    resena1.setCalificacion(7);
    resena1.setComentario("Buenisimo");

    resena2 = new Resena();
    resena2.setIdResena(2);
    resena2.setCalificacion(5);
    resena2.setComentario("Bueno");
  }

  @Test
  void testgetAllResenas() {
    when(resenaRepository.findAll()).thenReturn(Arrays.asList(resena1, resena2));
    List<Resena> resenas = resenaService.getAllResenas();

    assertNotNull(resenas);
    assertEquals(2, resenas.size());
    verify(resenaRepository).findAll();
  }

  @Test
  void testgetResenaById() {
    when(resenaRepository.findById(1)).thenReturn(Optional.of(resena1));
    when(resenaRepository.existsById(1)).thenReturn(Boolean.TRUE);
    Resena resena = resenaService.getResenaById(1);
    assertNotNull(resena);
    assertEquals(1, resena.getIdResena());
    verify(resenaRepository).findById(1);
    verify(resenaRepository).existsById(1);
  }

  @Test
  void testaddResena() {
    Resena resena = new Resena();
    resena.setIdResena(3);
    resena.setCalificacion(6);
    resena.setComentario("Bueno");

    when(resenaRepository.save(resena)).thenReturn(resena);

    Resena result = resenaService.addResena(resena);
    assertNotNull(result);
    assertEquals("Bueno", result.getIdResena());

    verify(resenaRepository).save(resena);
  }

  @Test
  void deleteResena() {
    int id = 3;

    when(resenaRepository.existsById(id)).thenReturn(true);
    doNothing().when(resenaRepository).deleteById(id);

    boolean result = resenaService.deleteResena(3);

    assertTrue(result);
    verify(resenaRepository).existsById(id);
    verify(resenaRepository).deleteById(id);
  }
}
