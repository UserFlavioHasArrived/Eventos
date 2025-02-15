package com.evento.services;

import com.evento.dtos.UsuarioDTO;
import com.evento.models.Usuario;
import com.evento.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {

    @Autowired
    UsuarioRepository usuarioRepository;

    public UsuarioDTO cadastrarUsuario(UsuarioDTO usuarioDTO) {
        Usuario usuario = conveterUsuarioDTOparaUsuario(usuarioDTO);
        usuario = usuarioRepository.save(usuario);
        return converterUsuarioParaUsuarioDTO(usuario);

    }
    public UsuarioDTO converterUsuarioParaUsuarioDTO(Usuario usuario) {
        UsuarioDTO usuarioDTO = new UsuarioDTO();
        usuarioDTO.setId(usuario.getId());
        usuarioDTO.setNome(usuario.getNome());
        usuarioDTO.setEmail(usuario.getEmail());
        usuarioDTO.setSenha(usuario.getSenha());
        usuarioDTO.setCpf(usuario.getCpf());
        usuarioDTO.setDataNascimento(usuario.getDataNascimento());
        usuarioDTO.setPerfil(usuario.getPerfil());
        usuarioDTO.setVerificado(usuario.isVerficado());
        return usuarioDTO;

    }

    public Usuario conveterUsuarioDTOparaUsuario(UsuarioDTO usuariodto) {
        Usuario usuario = new Usuario();
        usuario.setId(usuariodto.getId());
        usuario.setNome(usuariodto.getNome());
        usuario.setEmail(usuariodto.getEmail());
        usuario.setSenha(usuariodto.getSenha());
        usuario.setCpf(usuariodto.getCpf());
        usuario.setDataNascimento(usuariodto.getDataNascimento());
        usuario.setPerfil(usuariodto.getPerfil());
        usuario.setVerficado(usuariodto.isVerificado());
        return usuario;
    }
}
