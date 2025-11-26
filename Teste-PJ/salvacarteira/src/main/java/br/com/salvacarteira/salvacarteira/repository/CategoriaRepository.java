package br.com.salvacarteira.salvacarteira.repository;

import br.com.salvacarteira.salvacarteira.model.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {
    // O Spring Data JPA cria os métodos CRUD automaticamente
}