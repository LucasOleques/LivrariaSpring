package com.livraria.livraria_api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.livraria.livraria_api.dto.LivroDTO;
import com.livraria.livraria_api.dto.MensagemResponseDTO;
import com.livraria.livraria_api.entity.Livro;
import com.livraria.livraria_api.exception.LivroNotFoundException;
import com.livraria.livraria_api.mapper.LivroMapper;
import com.livraria.livraria_api.repository.LivroRepository;

@Service
public class LivroService {

    private LivroRepository livroRepository;

    private final LivroMapper livroMapper = LivroMapper.INSTANCE;

    @Autowired
    public LivroService(LivroRepository livroRepository) {
        this.livroRepository = livroRepository;
    }

    public MensagemResponseDTO criarMensagemResponseDTO(LivroDTO livroDto) {
        Livro livroSalvo = livroMapper.toModel(livroDto);

        Livro savedLivro = livroRepository.save(livroSalvo);
        return MensagemResponseDTO.builder()
                .mensagem("Livro criado com ID " + savedLivro.getId_livro())
                .build();

    }

    public MensagemResponseDTO deletar(Long id) {
        livroRepository.deleteById(id);
        return MensagemResponseDTO.builder()
                .mensagem("Livro com ID " + id + " deletado com sucesso")
                .build();
    }

    public LivroDTO encontrarId(Long id) throws LivroNotFoundException {
        Livro livro = livroRepository.findById(id)
                .orElseThrow(() -> new LivroNotFoundException(id));

        return livroMapper.toDTO(livro);
    }

    public Iterable<LivroDTO> listarTodos() {
        Iterable<Livro> livros = livroRepository.findAll();
        return livroMapper.toDTOList(livros);
    }

    public void atualizar(Long id, LivroDTO livroDTO) throws LivroNotFoundException {
        Livro livro = livroRepository.findById(id)
                .orElseThrow(() -> new LivroNotFoundException(id));

        livroMapper.toModel(livroDTO);
        livroRepository.save(livro);
    }
}
