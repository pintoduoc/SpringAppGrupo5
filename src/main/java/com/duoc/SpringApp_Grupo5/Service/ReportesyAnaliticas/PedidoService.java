package com.duoc.SpringApp_Grupo5.Service.ReportesyAnaliticas;

import com.duoc.SpringApp_Grupo5.Modelo.ReportesyAnaliticas.Pedido;
import com.duoc.SpringApp_Grupo5.Repositorio.ReportesyAnaliticas.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PedidoService {
    @Autowired
    private PedidoRepository pedidoRepository;

    //Listar
    public List<Pedido> getAllPedidos(){
        return pedidoRepository.findAll();
    }
    //Buscar
    public Pedido getPedidoById(int id){
        if(pedidoRepository.existsById(id)){
            return pedidoRepository.findById(id).get();
        }else {
            return null;
        }
    }
    //Agregar
    public Pedido addPedido(Pedido pedido){
        return pedidoRepository.save(pedido);
    }
    //Eliminar
    public boolean deletePedido(int id){
        if(pedidoRepository.existsById(id)){
            pedidoRepository.deleteById(id);
            return true;
        }else {
            return false;
        }
    }

    //Actualizar
    public Pedido updatePedido(int id, Pedido pedido){
        if(pedidoRepository.existsById(id)){
            Pedido buscado = pedidoRepository.findById(id).get();
            buscado.setCliente(pedido.getCliente());
            buscado.setEstado(pedido.getEstado());
            buscado.setProductos(pedido.getProductos());
            pedidoRepository.save(buscado);
            return pedido;
        }else{
            return null;
        }
    }
}
