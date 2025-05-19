package com.duoc.SpringApp_Grupo5.Service.ReportesyAnaliticas;

import com.duoc.SpringApp_Grupo5.Modelo.ReportesyAnaliticas.Pedido;
import com.duoc.SpringApp_Grupo5.Repositorio.ReportesyAnaliticas.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PedidoService {
    @Autowired
    private PedidoRepository pedidoRepository;

    //Listar
    public String getAllPedidos(){
        String output = "";

        for(Pedido pedido : pedidoRepository.findAll()){
            output +="ID Pedido: "+pedido.getIdPedido()+"\n";
            output +="Cliente Asignado: "+pedido.getCliente()+"\n";
            output +="Estado: "+pedido.getEstado()+"\n";
            output +="Productos: "+pedido.getProductos()+"\n";
        }
        if(output.isEmpty()){
            return "No se encontraron pedidos";
        }else{
            return output;
        }
    }
    //Buscar
    public String getPedidoById(int id){
        String output = "";

        if(pedidoRepository.existsById(id)){
            Pedido buscado = pedidoRepository.findById(id).get();
            output = "ID Pedido: "+buscado.getIdPedido()+"\n";
            output +="Cliente Asignado: "+buscado.getCliente()+"\n";
            output +="Estado: "+buscado.getEstado()+"\n";
            output +="Productos: "+buscado.getProductos()+"\n";
            return output;
        }else{
            return "No se encontraron pedidos con esa ID";
        }
    }
    //Agregar
    public String addPedido(Pedido pedido){
        if(!pedidoRepository.existsById(pedido.getIdPedido())){
            pedidoRepository.save(pedido);
            return "Pedido agregado correctamente";
        }else{
            return "Pedido ya existente";
        }
    }
    //Eliminar
    public String deletePedido(int id){
        if(pedidoRepository.existsById(id)){
            pedidoRepository.deleteById(id);
            return "Pedido eliminado correctamente";
        }else{
            return "No se encontraron pedidos con esa ID";
        }
    }

    //Actualizar
    public String updatePedido(int id, Pedido pedido){
        if(pedidoRepository.existsById(id)){
            Pedido buscado = pedidoRepository.findById(id).get();
            buscado.setCliente(pedido.getCliente());
            buscado.setEstado(pedido.getEstado());
            buscado.setProductos(pedido.getProductos());
            pedidoRepository.save(buscado);
            return "Pedido actualizado correctamente";
        }else{
            return "No se encontraron pedidos con esa ID";
        }
    }
}
