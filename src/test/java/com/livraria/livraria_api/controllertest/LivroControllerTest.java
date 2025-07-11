package com.livraria.livraria_api.controllertest;


import org.hamcrest.core.Is;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.when;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.web.PageableHandlerMethodArgumentResolver;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import static org.springframework.http.MediaType.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import java.net.URI;

import com.livraria.livraria_api.controller.LivroController;
import com.livraria.livraria_api.dto.LivroDTO;
import com.livraria.livraria_api.dto.MensagemResponseDTO;
import com.livraria.livraria_api.service.LivroService;
import static com.livraria.livraria_api.utills.LivroUtills.*;

@ExtendWith(MockitoExtension.class)
public class LivroControllerTest {

    private static final URI LIVRO_API_URL_PATH = URI.create("/api/v1/livro");

    private MockMvc mockMvc;

    @Mock
    private LivroService livroService;

    @InjectMocks
    private LivroController livroController;
    
    @BeforeEach
    void setUp() {
        mockMvc = MockMvcBuilders
                .standaloneSetup(livroController)
                .setCustomArgumentResolvers(new PageableHandlerMethodArgumentResolver())
                .setViewResolvers((viewName, locale) -> new MappingJackson2JsonView())
                .build();
    }

    @Test
    void testQuandoUmPOSTEhChamadaValidaEntaoUmLivroTemQueSerCriado() throws Exception {
        LivroDTO livroDTO = criarFakeLivroDTO();
        MensagemResponseDTO expectativaMensagemResponse = MensagemResponseDTO.builder()
                .mensagem("Livro criado com ID " + livroDTO.getId_livro())
                .build();

        when(livroService.criarMensagemResponseDTO(livroDTO)).thenReturn(expectativaMensagemResponse);

        mockMvc.perform(post(LIVRO_API_URL_PATH)
                .contentType("application/json")
                .content(asJsonString(livroDTO)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.mensagem", Is.is(expectativaMensagemResponse.getMensagem())));
    }

    @Test
    void testQuandoUmPOSTEhChamadaNaoValidaEntaoUmLivroTemQueSerCriado() throws Exception {
        LivroDTO livroDTO = criarFakeLivroDTO();
        livroDTO.setLocal_estoque("Estante");

        mockMvc.perform(post(LIVRO_API_URL_PATH)
                .contentType(APPLICATION_JSON)
                .content(asJsonString(livroDTO)))
                .andExpect(status().isBadRequest());
    }
}