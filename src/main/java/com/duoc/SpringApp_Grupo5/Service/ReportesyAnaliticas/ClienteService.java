package com.duoc.SpringApp_Grupo5.Service.ReportesyAnaliticas;

import com.duoc.SpringApp_Grupo5.Modelo.ReportesyAnaliticas.Cliente;
import com.duoc.SpringApp_Grupo5.Repositorio.ReportesyAnaliticas.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService {
    @Autowired
    private ClienteRepository clienteRepository;

    //Listar
    public List<Cliente> getAllClientes() {
        return clienteRepository.findAll();
    }
    //Buscar
    public Cliente getClienteById(int id) {
        if (clienteRepository.existsById(id)) {
            return clienteRepository.findById(id).get();
        }else {
            return null;
        }
    }

    //Agregar
    public Cliente addCliente(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    //ELiminar
    public boolean deleteCliente(int id) {
        if (clienteRepository.existsById(id)) {
            clienteRepository.deleteById(id);
            return true;
        }else {
            return false;
        }
    }

    //Actualizar
    public Cliente updateCliente(int id, Cliente cliente) {
        if(clienteRepository.existsById(id)){
            Cliente buscado = clienteRepository.findById(id).get();
            buscado.setNombreCliente(cliente.getNombreCliente());
            buscado.setEmailCliente(cliente.getEmailCliente());
            buscado.setDireccionCliente(cliente.getDireccionCliente());
            buscado.setPasswordCliente(cliente.getPasswordCliente());
            buscado.setResenas(cliente.getResenas());
            buscado.setPedidos(cliente.getPedidos());
            clienteRepository.save(buscado);
            return cliente;
        }else{
            return null;
        }
    }
}
