package com.evento.services;

import com.evento.dtos.CidadeDTO;
import com.evento.exceptions.BussinesException;
import com.evento.models.Cidade;
import com.evento.repositories.CidadeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CidadeService {
    @Autowired
    private CidadeRepository cidadeRepository;

    private static final String MSG_CIDADE = "Cidade não encontrada!";

    public CidadeDTO cadastrarCidade(CidadeDTO cidadeDTO) {
        Cidade cidade = converterCidadeDTOParaCidade(cidadeDTO);
        cidadeRepository.save(cidade);
        return converterCidadeParaCidadeDTO(cidade);
    }
    public Cidade atualizarCidadeDTOPorId(CidadeDTO cidadeDTO) {
        return new Cidade(cidadeDTO.getId(), cidadeDTO.getNome(), cidadeDTO.getEstado());
    }
    public CidadeDTO converterCidadeParaCidadeDTO(Cidade cidade) {
        CidadeDTO cidadeDTO = new CidadeDTO();
        cidadeDTO.setId(cidade.getId());
        cidadeDTO.setNome(cidade.getNome());
        cidadeDTO.setEstado(cidade.getEstado());
        return cidadeDTO;
    }
    public Cidade converterCidadeDTOParaCidade(CidadeDTO cidadeDTO) {
        Cidade cidade = new Cidade();
        cidade.setId(cidadeDTO.getId());
        cidade.setNome(cidadeDTO.getNome());
        cidade.setEstado(cidadeDTO.getEstado());
        return cidade;
    }
    public void deletarCidade(Long id) {
        cidadeRepository.deleteById(id);
    }
    public CidadeDTO buscarCidadePorId(Long id) {
        Cidade cidade = cidadeRepository.findById(id).orElseThrow(() ->
                new BussinesException(MSG_CIDADE));
        return converterCidadeParaCidadeDTO(cidade);

    }//Buscar Cidade por Id para ter certeza que a cidade existe
    public CidadeDTO atualizarCidade(CidadeDTO cidadeDTO) {
        cidadeRepository.findById(cidadeDTO.getId()).orElseThrow();
                new BussinesException(MSG_CIDADE);//Converte a cidadeDTO para cidade
        Cidade cidade = converterCidadeDTOParaCidade(cidadeDTO);//Atualiza a cidade no banco
        cidadeRepository.save(cidade);//Converte a entidade para o DTO
        return converterCidadeParaCidadeDTO(cidade);
    }



}


