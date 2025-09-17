package com.livraria.livraria_api.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
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

    @Size(max = 20, message = "O campo local_estoque deve ter no máximo 20 caracteres")
    @NotBlank(message = "O campo local_estoque não pode ser vazio")
    @NotNull(message = "O campo local_estoque não pode ser nulo")
    @Pattern(regexp = "^(?i)(reserva|prateleira)$", 
            message = "O campo local_estoque deve ser 'Reserva' ou 'Prateleira'")
    private String local_estoque;

    @NotNull
    private Integer quantidade_estoque;

    @NotBlank
    @Size(max = 100)
    @Pattern(regexp = "(?:ISBN(?:-10)?:?)?(?=[0-9X]{10}$|(?=(?:[0-9]+[- ]){4})[0-9]{13}$)(?:97[89][- ]?)?[0-9]{1,5}[- ]?[0-9]+[- ]?[0-9]+[- ]?[0-9X]$", 
            message = "ISBN deve ser válido")
    private String isbn;
    
    @Valid
    @NotNull
    private AutorDTO autor;

}
