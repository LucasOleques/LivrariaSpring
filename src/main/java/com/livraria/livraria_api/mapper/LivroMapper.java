package com.livraria.livraria_api.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.livraria.livraria_api.dto.LivroDTO;
import com.livraria.livraria_api.entity.Livro;

@Mapper
public interface LivroMapper {

    LivroMapper INSTANCE = Mappers.getMapper(LivroMapper.class);

    Livro toModel(LivroDTO livroDTO);

    LivroDTO toDTO(Livro livro);

    Iterable<LivroDTO> toDTOList(Iterable<Livro> livros);
}