package com.duoc.SpringApp_Grupo5.Controller.ReportesYAnaliticas;

import com.duoc.SpringApp_Grupo5.Modelo.ReportesyAnaliticas.Pedido;
import com.duoc.SpringApp_Grupo5.Service.ReportesyAnaliticas.PedidoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/pedido")
@Tag(name = "Pedidos", description = "Operaciones para la clase 'Pedido'.")

public class PedidoController {

    @Autowired
    private PedidoService pedidoService;

    @GetMapping
    @Operation(summary = "Obtener Pedidos.", description = "Devuelve una lista de todos los pedidos registrados en la base de datos.")
    public String getAllPedidos() {return pedidoService.getAllPedidos(); }

    @PostMapping
    @Operation(summary = "Añadir Pedido.", description = "Registra un envio a la base de datos, requiriendo los siguientes datos: ID Cliente, Estado y ID Producto/s.")
    public String addPedido(@RequestBody Pedido pedido) {return pedidoService.addPedido(pedido); }

    @GetMapping("/{id}")
    @Operation(summary = "Obtener Pedido por ID.", description = "Busca un pedido con el ID entregada, y lo devuelve.")
    public String getPedidoById(@PathVariable int id) {return pedidoService.getPedidoById(id); }

    @DeleteMapping("/{id}")
    @Operation(summary = "Eliminar Pedido.", description = "Busca un pedido con el ID entregada, y lo elimina.")
    public String deletePedido(@PathVariable int id) {return pedidoService.deletePedido(id); }

    @PutMapping("/{id}")
    @Operation(summary = "Actualizar Pedido.", description = "Busca un pedido con el ID entregada, y cambia sus datos por los entregados por el usuario.")
    public String updatePedido(@PathVariable int id, @RequestBody Pedido pedido) {
        return pedidoService.updatePedido(id, pedido);
    }
}
