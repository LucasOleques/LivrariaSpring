package com.livraria.livraria_api.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Table(name = "livros")
@Data
public class Livro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String titulo;

    @Column(nullable = false)
    private String autor;

    @Column(nullable = false)
    private String localEstoque;

    @Column(nullable = false)
    private Integer quantidadeEstoque;

    @Column(nullable = false)
    private LocalDate dataEntradaEstoque;
}