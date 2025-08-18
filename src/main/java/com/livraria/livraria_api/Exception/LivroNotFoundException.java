package com.livraria.livraria_api.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class LivroNotFoundException extends Exception {

    public LivroNotFoundException(Long id) {
        super(String.format("Livro com ID %d não encontrado", id));
    }
}
