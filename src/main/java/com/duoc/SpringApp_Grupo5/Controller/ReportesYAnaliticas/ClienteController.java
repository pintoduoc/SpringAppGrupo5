package com.duoc.SpringApp_Grupo5.Controller.ReportesYAnaliticas;

import com.duoc.SpringApp_Grupo5.Modelo.ReportesyAnaliticas.Cliente;
import com.duoc.SpringApp_Grupo5.Service.ReportesyAnaliticas.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping

public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @GetMapping
    public String getAllClientes() {return clienteService.getAllClientes();}

    @PostMapping
    public String addCliente(@RequestBody Cliente cliente) {return clienteService.addCliente(cliente); }

    @GetMapping("/{id}")
    public String getClienteById(@PathVariable int id) {return clienteService.getClienteById(id); }

    @DeleteMapping("/{id}")
    public String deleteCliente(@PathVariable int id) {return clienteService.deleteCliente(id); }

    @PutMapping("/{id}")
    public String updateCliente(@PathVariable int id, @RequestBody Cliente cliente) {
        return clienteService.updateCliente(id, cliente);
    }
}
