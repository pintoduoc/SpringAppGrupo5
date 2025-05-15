package com.duoc.SpringApp_Grupo5.Repositorio.VentasFacturacion;

import com.duoc.SpringApp_Grupo5.Modelo.VentasFacturacion.Venta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VentaRepository extends JpaRepository <Venta {
}
