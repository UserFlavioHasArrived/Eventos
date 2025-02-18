package com.evento.resources;

import com.evento.dtos.UsuarioDTO;
import com.evento.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioResource {

    @GetMapping()
    public String buscarUsuarios(){
        return "Buscando usuarios";
    }

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping("/{id}")
    public String buscarusuario(){
        return "Buscando usuarios";
    }

    @PostMapping()
    public ResponseEntity<UsuarioDTO> cadastrarUsuario(@RequestBody UsuarioDTO usuarioDTO){
        UsuarioDTO usuario = usuarioService.cadastrarUsuario(usuarioDTO);
        return ResponseEntity.ok(usuarioDTO);
    }

    public UsuarioResource(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarUsuario(@PathVariable Long id) {
        usuarioService.deletarUsuario(id);
        return ResponseEntity.noContent().build();
    }
    @PutMapping()
    public ResponseEntity<UsuarioDTO> atualizarUsuario(@RequestBody UsuarioDTO usuarioDTO) {
        UsuarioDTO usuario = usuarioService.atualizarUsuario(usuarioDTO);
        return ResponseEntity.ok(usuarioService.atualizarUsuario(usuarioDTO));
    }
    @GetMapping("/buscar")
    public ResponseEntity<UsuarioDTO> buscarUsuarioPorEmail(@RequestParam String email) {
        return ResponseEntity.ok(usuarioService.buscarUsuarioPorEmail(email));
    }
}