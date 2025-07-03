package com.duoc.SpringApp_Grupo5.Service.ReportesyAnaliticas;

import com.duoc.SpringApp_Grupo5.Modelo.LogisticayEnvio.Envio;
import com.duoc.SpringApp_Grupo5.Modelo.ReportesyAnaliticas.Reporte;
import com.duoc.SpringApp_Grupo5.Repositorio.ReportesyAnaliticas.ReporteRepository;
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
class ReporteServiceTest {

  @Mock
  private ReporteRepository reporteRepository;

  @InjectMocks
  private ReporteService reporteService;

  private Reporte reporte1;
  private Reporte reporte2;

  @BeforeEach
  void setUp() {
    reporte1 = new Reporte();
    reporte1.setId(1);
    reporte1.setTipo("Reporte");
    reporte1.setDatos("Datos1");
    //reporte1.setFechaGeneracion("");

    reporte2 = new Reporte();
    reporte2.setId(2);
    reporte2.setTipo("Cuadro");
    reporte1.setDatos("Datos2");
    //reporte2.setFechaGeneracion("");
  }

  @Test
  void testgetAllReportes() {
    when(reporteRepository.findAll()).thenReturn(Arrays.asList(reporte1, reporte2));

    List<Reporte> reportes = reporteService.getAllReportes();

    assertNotNull(reportes);
    assertEquals(2, reportes.size());
    verify(reporteRepository).findAll();
  }

  @Test
  void testgetReporteById() {

    when(reporteRepository.findById(1)).thenReturn(Optional.of(reporte1));
    when(reporteRepository.existsById(1)).thenReturn(true);

    Reporte reporte = reporteService.getReporteById(1);
    assertNotNull(reporte);
    assertEquals(1, reporte.getId());
    verify(reporteRepository).findById(1);
    verify(reporteRepository).existsById(1);
  }

  @Test
  void testaddReporte() {
    Reporte reporte = new Reporte();

    reporte.setId(3);
    reporte.setTipo("Word");

    when(reporteRepository.save(reporte)).thenReturn(reporte);

    Reporte result = reporteService.addReporte(reporte);
    assertNotNull(result);
    assertEquals("Word", result.getTipo());
    verify(reporteRepository).save(reporte);
  }

  @Test
  void deleteReporte() {
    int id = 1;

    when(reporteRepository.existsById(id)).thenReturn(true);
    doNothing().when(reporteRepository).deleteById(id);

    boolean resultado = reporteService.deleteReporte(1);

    assertTrue(resultado);
    verify(reporteRepository).existsById(id);
    verify(reporteRepository).deleteById(id);

  }
}
