package com.livraria.livraria_api.utills;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.github.javafaker.Faker;
import com.livraria.livraria_api.dto.LivroDTO;
import com.livraria.livraria_api.entity.Livro;
import static com.livraria.livraria_api.utills.AutorUtills.*;

public class LivroUtills {

    private static final Faker faker = Faker.instance();

    public static LivroDTO criarFakeLivroDTO() {
        return LivroDTO.builder()
                .id_livro(faker.number().randomNumber())
                .titulo(faker.book().title())
                .local_estoque("Prateleira")
                .quantidade_estoque(faker.number().numberBetween(1, 100))
                .autor(criarFakeAutorDTO())
                .build();
    }

    public static Livro criarFakeLivro(){
        return Livro.builder()
                .id_livro(faker.number().randomNumber())
                .titulo(faker.book().title())
                .local_estoque("Reserva")
                .quantidade_estoque(faker.number().numberBetween(1, 100))
                .autor(criarFakeAutor())
                .build();
    }

    public static String asJsonString(LivroDTO livroDTO) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
            objectMapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
            objectMapper.registerModules(new JavaTimeModule());

            return objectMapper.writeValueAsString(livroDTO);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}