package com.livraria.livraria_api.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class MensagemResponseDTO {

    private String mensagem;
}
