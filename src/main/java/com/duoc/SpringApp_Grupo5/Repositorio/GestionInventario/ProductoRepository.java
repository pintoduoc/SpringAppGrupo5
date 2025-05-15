package com.duoc.SpringApp_Grupo5.Repositorio.GestionInventario;

import com.duoc.SpringApp_Grupo5.Modelo.GestionInventario.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductoRepository extends JpaRepository<Producto, Long> {
}
