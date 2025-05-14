package com.duoc.SpringApp_Grupo5.Modelo.LogisticayEnvio;
import com.duoc.SpringApp_Grupo5.Modelo.ReportesyAnaliticas.Cliente;
import com.duoc.SpringApp_Grupo5.Modelo.ReportesyAnaliticas.Pedido;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity

public class Envio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idEnvio;
    @ManyToOne
    @JoinColumn(name = "pedido_id_pedido")
    private Pedido pedido;
    @ManyToOne
    @JoinColumn(name = "cliente_id_cliente")
    private Cliente cliente;
    private String direccionEnvio, fechaEnvio, estadoEnvio;



    /*Metodos viejos (borrador):
    public void actualizarEstadoEnvio(Envio envio, String estado) {
        envio.setEstadoEnvio(estado);
        System.out.println("Estado del pedido actualizado: " + estado);
    }*/

}
