package com.duoc.SpringApp_Grupo5.Controller.ReportesYAnaliticas;

import com.duoc.SpringApp_Grupo5.Assemblers.ReportesYAnaliticas.ClienteModelAssembler;
import com.duoc.SpringApp_Grupo5.Modelo.ReportesyAnaliticas.Cliente;
import com.duoc.SpringApp_Grupo5.Service.ReportesyAnaliticas.ClienteService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cliente")
@Tag(name = "Clientes", description = "Operaciones para la clase 'Cliente'.")

public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @Autowired
    ClienteModelAssembler assembler;

    @GetMapping
    @Operation(summary = "Obtener clientes.", description = "Devuele todos los clientes registrados.")
    public CollectionModel<EntityModel<Cliente>> getAllClientes() {
        List<Cliente> clientes = clienteService.getAllClientes();
        return assembler.toCollectionModel(clientes);
    }

    @PostMapping
    @Operation(summary = "Añadir Cliente.", description = "Registra un cliente a la base de datos, requiriendo los siguientes datos: Nombre Cliente, Email Cliente, Direccion Cliente, Password Cliente, ID Reseñas y ID Pedidos.")
    public EntityModel<Cliente> addCliente(@RequestBody Cliente cliente) {
        Cliente nuevo = clienteService.addCliente(cliente);
        if (nuevo != null) {
            return assembler.toModel(nuevo);
        }else {
            return null;
        }
    }

    @GetMapping("/{id}")
    @Operation(summary = "Obtener Cliente por ID.", description = "Busca un cliente con el ID entregado, y lo devuelve.")
    public EntityModel<Cliente> getClienteById(@PathVariable int id) {
        Cliente cliente = clienteService.getClienteById(id);
        if (cliente != null) {
            return assembler.toModel(cliente);
        }else {
            return null;
        }
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Eliminar Cliente.", description = "Busca un cliente con el ID entregado, y lo elimina.")
    public void deleteCliente(@PathVariable int id) {
        clienteService.deleteCliente(id);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Actualizar Cliente.", description = "Busca un cliente por su ID, y cambia sus datos por los entregados por el usuario.")
    public EntityModel<Cliente> updateCliente(@PathVariable int id, @RequestBody Cliente cliente) {
        Cliente nuevoCliente = clienteService.updateCliente(id, cliente);
        if (nuevoCliente != null) {
            return assembler.toModel(nuevoCliente);
        }else{
            return null;
        }
    }
}
