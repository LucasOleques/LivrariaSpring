package com.livraria.livraria_api.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Table(name = "livros")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Livro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String titulo;

    @ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE})
    @JoinColumn(name = "autor_id", nullable = false)
    private Autor autor;

    @Column(nullable = false)
    private String localEstoque;

    @Column(nullable = false)
    private Integer quantidadeEstoque;

    @Column(nullable = false)
    private LocalDate dataEntradaEstoque;
}