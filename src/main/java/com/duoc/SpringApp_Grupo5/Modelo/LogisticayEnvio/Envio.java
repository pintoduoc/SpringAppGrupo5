package com.duoc.SpringApp_Grupo5.Modelo.LogisticayEnvio;
import com.duoc.SpringApp_Grupo5.Modelo.ReportesyAnaliticas.Cliente;
import com.duoc.SpringApp_Grupo5.Modelo.ReportesyAnaliticas.Pedido;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor


public class Envio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idEnvio;
    private Pedido pedido;
    private Cliente cliente;
    private String direccionEnvio, fechaEnvio, estadoEnvio;



    /*Metodos
    public void actualizarEstadoEnvio(Envio envio, String estado) {
        envio.setEstadoEnvio(estado);
        System.out.println("Estado del pedido actualizado: " + estado);
    }*/

}
