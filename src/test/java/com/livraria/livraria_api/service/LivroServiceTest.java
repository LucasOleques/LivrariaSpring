package com.livraria.livraria_api.service;

import static org.mockito.Mockito.*;

import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.livraria.livraria_api.dto.LivroDTO;
import com.livraria.livraria_api.entity.Livro;
import com.livraria.livraria_api.repository.LivroRepository;
import com.livraria.livraria_api.utills.LivroUtills;

@ExtendWith(MockitoExtension.class)
public class LivroServiceTest {
    
    @Mock
    private LivroRepository livroRepository;

    @InjectMocks
    private LivroService livroService;

    @Test
    void quandoUmIdExisteRetornarLivro() {
        Livro livroExperado = LivroUtills.criarFakeLivro();

        when(livroRepository.findById(livroExperado.getId_livro())).thenReturn(Optional.of(livroExperado));

        LivroDTO livroDTO = livroService.encontrarId(livroExperado.getId_livro());

        Assertions.assertEquals(livroExperado.getTitulo(),livroDTO.getTitulo());
        Assertions.assertEquals(livroExperado.getQuantidade_estoque(),livroDTO.getQuantidade_estoque());    
    }
}
