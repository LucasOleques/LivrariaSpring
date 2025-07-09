package com.livraria.livraria_api.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AutorDTO {

    private Long id_autor;

    @NotBlank
    @Size(max = 200)
    private String nome_autor;

    @NotNull
    private Integer idade_autor;
}
