package com.duoc.SpringApp_Grupo5.Controller.Usuarios;

import com.duoc.SpringApp_Grupo5.Modelo.Usuarios.Usuario;
import com.duoc.SpringApp_Grupo5.Service.Usuarios.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping

public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping
    public String getAllUsuarios() {return usuarioService.getAllUsuarios(); }

    @PostMapping
    public String addUsuario(@RequestBody Usuario usuario) {return usuarioService.addUsuario(usuario); }

    @GetMapping("/{id}")
    public String getUsuarioById(@PathVariable int id) {return usuarioService.getUsuarioById(id); }

    @DeleteMapping("/{id}")
    public String deleteUsuario(@PathVariable int id) {return usuarioService.deleteUsuario(id); }

    @PutMapping("/{id}")
    public String updateUsuario(@PathVariable int id, @RequestBody Usuario usuario){
        return usuarioService.updateUsuario(id, usuario);
    }
}
