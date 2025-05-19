package com.duoc.SpringApp_Grupo5.Repositorio.LogisticayEnvio;

import com.duoc.SpringApp_Grupo5.Modelo.LogisticayEnvio.Envio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EnvioRepository extends JpaRepository<Envio, Integer> {
}
