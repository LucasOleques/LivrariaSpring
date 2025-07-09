package com.livraria.livraria_api.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.persistence.*;

@Entity
@Table(name = "autor")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Autor {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_autor;

    @Column(nullable = false, unique = true)
    private String nome_autor;

    @Column(nullable = false)
    private Integer idade_autor;
}
