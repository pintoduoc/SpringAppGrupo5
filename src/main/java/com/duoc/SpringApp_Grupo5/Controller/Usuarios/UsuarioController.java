package com.duoc.SpringApp_Grupo5.Controller.Usuarios;

import com.duoc.SpringApp_Grupo5.Modelo.Usuarios.Usuario;
import com.duoc.SpringApp_Grupo5.Service.Usuarios.UsuarioService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/usuario")
@Tag(name = "Usuarios", description = "Operaciones para la clase 'Usuario'")

public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping
    @Operation(summary = "Obtener todos los usuarios", description = "Devuelve todos los usuarios registrados")
    public String getAllUsuarios() {return usuarioService.getAllUsuarios(); }

    @PostMapping
    @Operation(summary = "Añadir Usuario", description = "Registra un usuario a la base de datos. Requiere: nombre, email, contraseña y rol ")
    public String addUsuario(@RequestBody Usuario usuario) {return usuarioService.addUsuario(usuario); }

    @GetMapping("/{id}")
    @Operation(summary = "Buscar usuario", description = "Busca un usuario mediante la id ingresada")
    public String getUsuarioById(@PathVariable int id) {return usuarioService.getUsuarioById(id); }

    @DeleteMapping("/{id}")
    @Operation(summary = "Borrar usuario", description = "Borra un usuario mediante la id ingresada")
    public String deleteUsuario(@PathVariable int id) {return usuarioService.deleteUsuario(id); }

    @PutMapping("/{id}")
    @Operation(summary = "Actualizar usuario", description = "Actualiza un usuario. Requiere: id del usuario a actualizar, nuevo nombre, nuevo email, nueva contraseña, nuevo rol")
    public String updateUsuario(@PathVariable int id, @RequestBody Usuario usuario){
        return usuarioService.updateUsuario(id, usuario);
    }
}
