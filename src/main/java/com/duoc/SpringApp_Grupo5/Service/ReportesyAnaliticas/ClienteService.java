package com.duoc.SpringApp_Grupo5.Service.ReportesyAnaliticas;

import com.duoc.SpringApp_Grupo5.Modelo.ReportesyAnaliticas.Cliente;
import com.duoc.SpringApp_Grupo5.Repositorio.ReportesyAnaliticas.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClienteService {
    @Autowired
    private ClienteRepository clienteRepository;

    //Listar
    public String getAllClientes() {
        String output = "";

        for (Cliente cliente : clienteRepository.findAll()) {
            output +="ID Cliente: " + cliente.getIdCliente() + "\n";
            output +="Nombre Cliente: " + cliente.getNombreCliente() + "\n";
            output +="Email Cliente: " + cliente.getEmailCliente() + "\n";
            output +="Direccion Cliente: " + cliente.getDireccionCliente() + "\n";
            output +="Password Cliente: " + cliente.getPasswordCliente() + "\n";
            output +="Reseñas: " + cliente.getResenas() + "\n";
            output +="Pedidos: " + cliente.getPedidos() + "\n";
        }
        if(output.isEmpty()){
            return "No se encontraron clientes";
        }else{
            return output;
        }
    }
    //Buscar
    public String getClienteById(int id) {
        String output = "";
        if(clienteRepository.existsById(id)){
            Cliente buscado = clienteRepository.findById(id).get();
            output = "ID Cliente: " + buscado.getIdCliente() + "\n";
            output +="Nombre Cliente: " + buscado.getNombreCliente() + "\n";
            output +="Email Cliente: " + buscado.getEmailCliente() + "\n";
            output +="Direccion Cliente: " + buscado.getDireccionCliente() + "\n";
            output +="Password Cliente: " + buscado.getPasswordCliente() + "\n";
            output +="Resenas: " + buscado.getResenas() + "\n";
            output +="Pedidos: " + buscado.getPedidos() + "\n";
            return output;
        }else{
            return "No se encontraron clientes con esa ID";
        }
    }

    //Agregar
    public String addCliente(Cliente cliente) {
        if(!clienteRepository.existsById(cliente.getIdCliente())){
            clienteRepository.save(cliente);
            return "Cliente agregado correctamente";
        }else{
            return "Cliente ya existente";
        }
    }

    //ELiminar
    public String deleteCliente(int id) {
        if(clienteRepository.existsById(id)){
            clienteRepository.deleteById(id);
            return "Cliente eliminado correctamente";
        }else{
            return "No se encontraron clientes con esa ID";
        }
    }

    //Actualizar
    public String updateCliente(int id, Cliente cliente) {
        if(clienteRepository.existsById(id)){
            Cliente buscado = clienteRepository.findById(id).get();
            buscado.setNombreCliente(cliente.getNombreCliente());
            buscado.setEmailCliente(cliente.getEmailCliente());
            buscado.setDireccionCliente(cliente.getDireccionCliente());
            buscado.setPasswordCliente(cliente.getPasswordCliente());
            buscado.setResenas(cliente.getResenas());
            buscado.setPedidos(cliente.getPedidos());
            clienteRepository.save(buscado);
            return "Cliente actualizado correctamente";
        }else{
            return "No se encontraron clientes con esa ID";
        }
    }
}
