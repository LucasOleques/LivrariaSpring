package com.livraria.livraria_api.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.livraria.livraria_api.dto.LivroDTO;
import com.livraria.livraria_api.dto.MensagemResponseDTO;
import com.livraria.livraria_api.exception.LivroNotFoundException;
import com.livraria.livraria_api.service.LivroService;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;



@RestController
@RequestMapping("/api/v1/livro")
public class LivroController {

    private LivroService livroService;

    @Autowired
    public LivroController(LivroService livroService) {
        this.livroService = livroService;
    }

    @PostMapping("/cadastrar")
    public MensagemResponseDTO criarMensagemResponseDTO (@RequestBody @Valid LivroDTO livroDTO) throws LivroNotFoundException {
        return livroService.criarMensagemResponseDTO(livroDTO);
    }

    @DeleteMapping("/remover/{id}")
    public MensagemResponseDTO deletar(@PathVariable Long id) throws LivroNotFoundException {
        return livroService.deletar(id);
    }

    @GetMapping("/listar")
    public Iterable<LivroDTO> listarTodos() {
        return livroService.listarTodos();
    }

    @GetMapping("/{id}")
    public LivroDTO encontrarId(@PathVariable Long id) throws LivroNotFoundException {
        return livroService.encontrarId(id);
    }

    @PutMapping("atualizar/{id}")
    public String atualizar(@PathVariable Long id, @RequestBody LivroDTO livroDTO) throws LivroNotFoundException {
        livroService.atualizar(id, livroDTO);
        return "Livro atualizado com sucesso!";
    }
}
