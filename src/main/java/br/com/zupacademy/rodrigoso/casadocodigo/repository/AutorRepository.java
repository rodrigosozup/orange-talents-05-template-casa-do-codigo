package br.com.zupacademy.rodrigoso.casadocodigo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.zupacademy.rodrigoso.casadocodigo.modelo.Autor;

@Repository
public interface AutorRepository extends JpaRepository<Autor, Long>{

}
