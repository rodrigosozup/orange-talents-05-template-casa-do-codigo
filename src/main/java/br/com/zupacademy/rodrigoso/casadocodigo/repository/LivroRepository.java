package br.com.zupacademy.rodrigoso.casadocodigo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.zupacademy.rodrigoso.casadocodigo.modelo.Livro;

@Repository
public interface LivroRepository extends JpaRepository<Livro, Long>{

}
