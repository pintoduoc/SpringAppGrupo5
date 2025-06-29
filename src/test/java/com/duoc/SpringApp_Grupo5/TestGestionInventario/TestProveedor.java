package com.duoc.SpringApp_Grupo5.TestGestionInventario;


import com.duoc.SpringApp_Grupo5.Repositorio.GestionInventario.ProveedorRepository;
import com.duoc.SpringApp_Grupo5.Service.GestionInventario.ProveedorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc
public class TestProveedor {

    @Autowired
    ProveedorRepository proveedorRepository;
    @Autowired
    MockMvc mockMvc;
    @MockitoBean
    ProveedorService proveedorService;


}
