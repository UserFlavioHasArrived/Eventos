package com.evento.services;

import com.evento.dtos.ProdutoraDTO;

import com.evento.exceptions.BussinesException;
import com.evento.models.Produtora;
import com.evento.repositories.ProdutoraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProdutoraService {
   @Autowired
    private ProdutoraRepository produtoraRepository;

    public ProdutoraDTO cadastrarProdutora(ProdutoraDTO produtoraDTO){
        Produtora produtora = converterProdutoraDTOParaProdutora(produtoraDTO);
        produtora = produtoraRepository.save(produtora);
        return converterProdutoraParaProdutoraDTO(produtora);
    }

    ProdutoraDTO converterProdutoraParaProdutoraDTO(Produtora produtora) {
        ProdutoraDTO produtoraDTO = new ProdutoraDTO();
        produtoraDTO.setId(produtora.getId());
        produtoraDTO.setNome(produtora.getNome());
        produtoraDTO.setCpfCnpj(produtora.getCpfCnpj());
        return produtoraDTO;
    }

    public Produtora converterProdutoraDTOParaProdutora(ProdutoraDTO produtoraDTO) {
        Produtora produtora = new Produtora();
        produtora.setId(produtoraDTO.getId());
        produtora.setNome(produtoraDTO.getNome());
        produtora.setCpfCnpj(produtoraDTO.getCpfCnpj());
        return produtora;
    }
    public void deletarProdutora(Long id){
        produtoraRepository.deleteById(id);
    }
    public ProdutoraDTO buscarProdutoraDTOPorId(Long id){
        Produtora produtora = buscarProdutoraPorId(id);
        return converterProdutoraParaProdutoraDTO(produtora);
    }
    public Produtora buscarProdutoraPorId(Long id){
        Produtora produtora = produtoraRepository.findById(id)
                .orElseThrow(() ->
                        new BussinesException("Produtora não encontrada"));
        return produtora;
    }
    public ProdutoraDTO atualizarProdutora(ProdutoraDTO produtoraDTO){
        //Busca a produtora pelo id para ter certeza que ela existe
        produtoraRepository.findById(produtoraDTO.getId())
                .orElseThrow(() ->
                        new BussinesException("Produtora não encontrada"));
        //Converte o DTO para a entidade
        Produtora produtora = converterProdutoraDTOParaProdutora(produtoraDTO);
        //atualiza a produtora no banco
        produtoraRepository.save(produtora);
        //convete a entidade para o DTO
        return converterProdutoraParaProdutoraDTO(produtora);
    }
    public ProdutoraDTO buscarProdutoraPorNome(String nome){
        Produtora produtora = produtoraRepository.findByNome(nome)
                .orElseThrow(() ->
                        new BussinesException("Produtora não encontrada"));
        return converterProdutoraParaProdutoraDTO(produtora);
    }

}
