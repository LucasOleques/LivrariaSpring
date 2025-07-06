package com.livraria.livraria_api.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.livraria.livraria_api.dto.MensagemResponseDTO;
import com.livraria.livraria_api.entity.Livro;
import com.livraria.livraria_api.repository.LivroRepository;
import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;


@RestController
@RequestMapping("/api/v1/livro")
public class LivroController {

    private LivroRepository livroRepository;

    @Autowired
    public LivroController(LivroRepository livroRepository) {
        this.livroRepository = livroRepository;
    }

    @PostMapping
    public MensagemResponseDTO create (@RequestBody Livro livros) {
        Livro savedLivro = livroRepository.save(livros);
        return MensagemResponseDTO.builder()
        .message("Livro criado com ID" + savedLivro.getId())
        .build();
    }
}
