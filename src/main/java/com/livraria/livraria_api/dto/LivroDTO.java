package com.livraria.livraria_api.dto;

import jakarta.validation.Valid;
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
public class LivroDTO {

    private Long id_livro;
    
    @NotBlank
    @Size(max = 200)
    private String titulo;

    @NotBlank
    @Size(max = 100)
    private String local_estoque;

    @NotNull
    private Integer quantidade_estoque;
    
    @Valid
    @NotNull
    private AutorDTO autor;

    /*
    @NotBlank
    @Size(max = 100)
    @Pattern(regexp = "(?:ISBN(?:-10)?:?)?(?=[0-9X]{10}$|(?=(?:[0-9]+[- ]){4})[0-9]{13}$)(?:97[89][- ]?)?[0-9]{1,5}[- ]?[0-9]+[- ]?[0-9]+[- ]?[0-9X]$", 
            message = "ISBN deve ser válido")
    private String isbn;
     */
}
