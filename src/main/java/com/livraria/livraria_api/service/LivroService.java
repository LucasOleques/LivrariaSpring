package com.livraria.livraria_api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.livraria.livraria_api.dto.LivroDTO;
import com.livraria.livraria_api.dto.MensagemResponseDTO;
import com.livraria.livraria_api.entity.Livro;
import com.livraria.livraria_api.mapper.LivroMapper;
import com.livraria.livraria_api.repository.LivroRepository;

@Service
public class LivroService {
    
    private LivroRepository livroRepository;

    private final LivroMapper livroMapper = LivroMapper.INSTANCE;
    
    @Autowired
    public LivroService(LivroRepository livroRepository){
        this.livroRepository = livroRepository;
    }

    public MensagemResponseDTO criarMensagemResponseDTO (LivroDTO livroDto) {
        Livro livroSalvo = livroMapper.toModel(livroDto);

        Livro savedLivro = livroRepository.save(livroSalvo);
        return MensagemResponseDTO.builder()
        .mensagem("Livro criado com ID " + savedLivro.getId_livro())
        .build();

    }
}
