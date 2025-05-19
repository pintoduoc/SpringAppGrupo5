package com.duoc.SpringApp_Grupo5.Controller.ReportesYAnaliticas;

import com.duoc.SpringApp_Grupo5.Modelo.ReportesyAnaliticas.Pedido;
import com.duoc.SpringApp_Grupo5.Service.ReportesyAnaliticas.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping

public class PedidoController {

    @Autowired
    private PedidoService pedidoService;

    @GetMapping
    public String getAllPedidos() {return pedidoService.getAllPedidos(); }

    @PostMapping
    public String addPedido(@RequestBody Pedido pedido) {return pedidoService.addPedido(pedido); }

    @GetMapping("/{id}")
    public String getPedidoById(@PathVariable int id) {return pedidoService.getPedidoById(id); }

    @DeleteMapping("/{id}")
    public String deletePedido(@PathVariable int id) {return pedidoService.deletePedido(id); }

    @PutMapping("/{id}")
    public String updatePedido(@PathVariable int id, @RequestBody Pedido pedido) {
        return pedidoService.updatePedido(id, pedido);
    }
}
