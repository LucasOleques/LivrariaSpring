package com.livraria.livraria_api.utills;

import com.github.javafaker.Faker;
import com.livraria.livraria_api.dto.AutorDTO;
import com.livraria.livraria_api.entity.Autor;

public class AutorUtills {

    private static final Faker faker = Faker.instance();
    
    public static AutorDTO criarFakeAutorDTO() {
        return AutorDTO.builder()
                .id_autor(faker.number().randomNumber())
                .nome_autor(faker.name().fullName())
                .idade_autor(faker.number().numberBetween(18, 100))
                .build();
    }

    public static Autor criarFakeAutor() {
        return Autor.builder()
                .id_autor(faker.number().randomNumber())
                .nome_autor(faker.name().fullName())
                .idade_autor(faker.number().numberBetween(18, 100))
                .build();
    }
}