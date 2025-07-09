package com.livraria.livraria_api.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.livraria.livraria_api.dto.LivroDTO;
import com.livraria.livraria_api.dto.MensagemResponseDTO;
import com.livraria.livraria_api.service.LivroService;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;


@RestController
@RequestMapping("/api/v1/livro")
public class LivroController {

    private LivroService livroService;

    @Autowired
    public LivroController(LivroService livroService) {
        this.livroService = livroService;
    }

    @PostMapping
    public MensagemResponseDTO create (@RequestBody @Valid LivroDTO livroDTO) {
        return livroService.create(livroDTO);
    }
}
