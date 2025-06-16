package com.duoc.SpringApp_Grupo5.Controller.ReportesYAnaliticas;

import com.duoc.SpringApp_Grupo5.Modelo.ReportesyAnaliticas.Cliente;
import com.duoc.SpringApp_Grupo5.Service.ReportesyAnaliticas.ClienteService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cliente")
@Tag(name = "Clientes", description = "Operaciones para la clase 'Cliente'.")

public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @GetMapping
    @Operation(summary = "Obtener clientes.", description = "Devuele todos los clientes registrados.")
    public String getAllClientes() {return clienteService.getAllClientes();}

    @PostMapping
    @Operation(summary = "Añadir Cliente.", description = "Registra un cliente a la base de datos, requiriendo los siguientes datos: Nombre Cliente, Email Cliente, Direccion Cliente, Password Cliente, ID Reseñas y ID Pedidos.")
    public String addCliente(@RequestBody Cliente cliente) {return clienteService.addCliente(cliente); }

    @GetMapping("/{id}")
    @Operation(summary = "Obtener Cliente por ID.", description = "Busca un cliente con el ID entregado, y lo devuelve.")
    public String getClienteById(@PathVariable int id) {return clienteService.getClienteById(id); }

    @DeleteMapping("/{id}")
    @Operation(summary = "Eliminar Cliente.", description = "Busca un cliente con el ID entregado, y lo elimina.")
    public String deleteCliente(@PathVariable int id) {return clienteService.deleteCliente(id); }

    @PutMapping("/{id}")
    @Operation(summary = "Actualizar Cliente.", description = "Busca un cliente por su ID, y cambia sus datos por los entregados por el usuario.")
    public String updateCliente(@PathVariable int id, @RequestBody Cliente cliente) {
        return clienteService.updateCliente(id, cliente);
    }
}
