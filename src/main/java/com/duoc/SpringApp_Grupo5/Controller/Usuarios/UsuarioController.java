package com.duoc.SpringApp_Grupo5.Controller.Usuarios;

import com.duoc.SpringApp_Grupo5.Assemblers.Usuarios.UsuarioModelAssembler;
import com.duoc.SpringApp_Grupo5.Modelo.Usuarios.Usuario;
import com.duoc.SpringApp_Grupo5.Service.GestionInventario.ProductoService;
import com.duoc.SpringApp_Grupo5.Service.Usuarios.UsuarioService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuario")
@Tag(name = "Usuarios", description = "Operaciones para la clase 'Usuario'")

public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    UsuarioModelAssembler assembler;
    @Autowired
    private ProductoService productoService;

    @GetMapping
    @Operation(summary = "Obtener todos los usuarios", description = "Devuelve todos los usuarios registrados")
    public CollectionModel<EntityModel<Usuario>> getAllUsuarios() {
        List<Usuario> usuarios = usuarioService.getAllUsuarios();
        return assembler.toCollectionModel(usuarios);
    }

    @PostMapping
    @Operation(summary = "Añadir Usuario", description = "Registra un usuario a la base de datos. Requiere: nombre, email, contraseña y rol ")
    public EntityModel<Usuario> addUsuario(@RequestBody Usuario usuario) {
        Usuario nuevo = usuarioService.addUsuario(usuario);
        if (nuevo != null) {
            return assembler.toModel(nuevo);
        } else {
            return null;
        }
    }

    @GetMapping("/{id}")
    @Operation(summary = "Buscar usuario", description = "Busca un usuario mediante la id ingresada")
    public EntityModel<Usuario> getUsuarioById(@PathVariable int id) {
        Usuario usuario = usuarioService.getUsuarioById(id);
        if (usuario != null) {
            return assembler.toModel(usuario);
        } else {
            return null;
        }
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Borrar usuario", description = "Borra un usuario mediante la id ingresada")
    public void deleteUsuario(@PathVariable int id) {
        productoService.deleteProducto(id);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Actualizar usuario", description = "Actualiza un usuario. Requiere: id del usuario a actualizar, nuevo nombre, nuevo email, nueva contraseña, nuevo rol")
    public EntityModel<Usuario> updateUsuario(@PathVariable int id, @RequestBody Usuario usuario){
        Usuario nuevoUsuario = usuarioService.updateUsuario(id, usuario);
        if (nuevoUsuario != null) {
            return assembler.toModel(nuevoUsuario);
        } else {
            return null;
        }
    }
}
