package br.com.zupacademy.rodrigoso.casadocodigo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.zupacademy.rodrigoso.casadocodigo.modelo.Categoria;

@Repository
public interface CategoriaRepository extends JpaRepository<Categoria, Long>{

	Optional<Categoria> findByNome(String nome);

}
