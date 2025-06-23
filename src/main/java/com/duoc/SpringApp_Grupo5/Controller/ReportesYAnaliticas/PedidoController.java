package com.duoc.SpringApp_Grupo5.Controller.ReportesYAnaliticas;

import com.duoc.SpringApp_Grupo5.Assemblers.ReportesYAnaliticas.PedidoModelAssembler;
import com.duoc.SpringApp_Grupo5.Modelo.ReportesyAnaliticas.Pedido;
import com.duoc.SpringApp_Grupo5.Service.ReportesyAnaliticas.PedidoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pedido")
@Tag(name = "Pedidos", description = "Operaciones para la clase 'Pedido'.")

public class PedidoController {

    @Autowired
    private PedidoService pedidoService;

    @Autowired
    PedidoModelAssembler assembler;

    @GetMapping
    @Operation(summary = "Obtener Pedidos.", description = "Devuelve una lista de todos los pedidos registrados en la base de datos.")
    public CollectionModel<EntityModel<Pedido>> getAllPedidos() {
        List<Pedido> pedidos = pedidoService.getAllPedidos();
        return assembler.toCollectionModel(pedidos);
    }

    @PostMapping
    @Operation(summary = "Añadir Pedido.", description = "Registra un envio a la base de datos, requiriendo los siguientes datos: ID Cliente, Estado y ID Producto/s.")
    public EntityModel<Pedido> addPedido(@RequestBody Pedido pedido) {
        Pedido nuevo = pedidoService.addPedido(pedido);
        if (nuevo != null) {
            return assembler.toModel(nuevo);
        }else {
            return null;
        }
    }

    @GetMapping("/{id}")
    @Operation(summary = "Obtener Pedido por ID.", description = "Busca un pedido con el ID entregada, y lo devuelve.")
    public EntityModel<Pedido> getPedidoById(@PathVariable int id) {
        Pedido pedido = pedidoService.getPedidoById(id);
        if (pedido != null) {
            return assembler.toModel(pedido);
        }else {
            return null;
        }
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Eliminar Pedido.", description = "Busca un pedido con el ID entregada, y lo elimina.")
    public void deletePedido(@PathVariable int id) {
        pedidoService.deletePedido(id);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Actualizar Pedido.", description = "Busca un pedido con el ID entregada, y cambia sus datos por los entregados por el usuario.")
    public EntityModel<Pedido> updatePedido(@PathVariable int id, @RequestBody Pedido pedido) {
        Pedido nuevoPedido = pedidoService.updatePedido(id, pedido);
        if (nuevoPedido != null) {
            return assembler.toModel(nuevoPedido);
        }else {
            return null;
        }
    }
}
