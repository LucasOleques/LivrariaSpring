package com.livraria.livraria_api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.livraria.livraria_api.dto.MensagemResponseDTO;
import com.livraria.livraria_api.entity.Livro;
import com.livraria.livraria_api.repository.LivroRepository;

@Service
public class LivroService {
    
    private LivroRepository livroRepository;

    @Autowired
    public LivroService(LivroRepository livroRepository){
        this.livroRepository = livroRepository;
    }

    public MensagemResponseDTO create (Livro livros) {
        Livro savedLivro = livroRepository.save(livros);
        return MensagemResponseDTO.builder()
        .message("Livro criado com ID " + savedLivro.getId_livro())
        .build();

    }
}
