package com.livraria.livraria_api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.livraria.livraria_api.entity.Livro;

public interface RepositorioLivro extends JpaRepository<Livro , Long> {
    
}