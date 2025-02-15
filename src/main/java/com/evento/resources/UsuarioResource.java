package com.evento.resources;

import com.evento.dtos.UsuarioDTO;
import com.evento.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioResource {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping()
    public String buscarUsuarios(){
        return "Buscando Usuários";
    }
    @PostMapping()
    public ResponseEntity<UsuarioDTO> cadastrarUsuario(@RequestBody UsuarioDTO usuariodto){
        return ResponseEntity.ok(usuariodto);
    }
}
