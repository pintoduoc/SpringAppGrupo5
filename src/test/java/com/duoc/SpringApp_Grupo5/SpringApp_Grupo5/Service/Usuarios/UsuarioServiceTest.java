package com.duoc.SpringApp_Grupo5.Service.Usuarios;

import com.duoc.SpringApp_Grupo5.Modelo.Usuarios.Usuario;
import com.duoc.SpringApp_Grupo5.Repositorio.Usuarios.UsuarioRepository;
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

@AutoConfigureMockMvc
@SpringBootTest
@ExtendWith(MockitoExtension.class)
class UsuarioServiceTest {

  @Mock
  private UsuarioRepository usuarioRepository;

  @InjectMocks
  private UsuarioService usuarioService;

  private Usuario usuario1;
  private Usuario usuario2;

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
  void testgetAllUsuarios() {
    when(usuarioRepository.findAll()).thenReturn(Arrays.asList(usuario1, usuario2));
    List<Usuario> resultado = usuarioService.getAllUsuarios();

    assertNotNull(resultado);
    assertEquals(2, resultado.size());
  }

  @Test
  void testgetUsuarioById() {
    when(usuarioRepository.findById(1)).thenReturn(Optional.of(usuario1));
    when(usuarioRepository.existsById(1)).thenReturn(Boolean.TRUE);

    Usuario resultado = usuarioService.getUsuarioById(1);
    assertNotNull(resultado);
    assertEquals(1, resultado.getId());
    verify(usuarioRepository).findById(1);
    verify(usuarioRepository).existsById(1);
  }

  @Test
  void testaddUsuario() {
    Usuario usuario = new Usuario();

    usuario.setId(1);
    usuario.setContrasena("password");
    usuario.setNombre("Antonio");
    usuario.setEmail("anto@gmail.com");
    usuario.setEstado(true);
    usuario.setRol("Administrador");

    when(usuarioRepository.save(usuario)).thenReturn(usuario);
    Usuario resultado = usuarioService.addUsuario(usuario);
    assertNotNull(resultado);
    assertEquals("Antonio", resultado.getNombre());

  }

  @Test
  void deleteUsuario() {
    int id = 3;

    when(usuarioRepository.existsById(id)).thenReturn(Boolean.TRUE);
    doNothing().when(usuarioRepository).deleteById(id);

    boolean resultado = usuarioService.deleteUsuario(id);

    assertTrue(resultado);
    verify(usuarioRepository).existsById(id);
    verify(usuarioRepository).deleteById(id);
  }
}
