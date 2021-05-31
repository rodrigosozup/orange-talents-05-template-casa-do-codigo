package br.com.zupacademy.rodrigoso.casadocodigo.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.zupacademy.rodrigoso.casadocodigo.dto.NovoLivroDTO;
import br.com.zupacademy.rodrigoso.casadocodigo.modelo.Livro;
import br.com.zupacademy.rodrigoso.casadocodigo.repository.AutorRepository;
import br.com.zupacademy.rodrigoso.casadocodigo.repository.CategoriaRepository;
import br.com.zupacademy.rodrigoso.casadocodigo.repository.LivroRepository;

@RestController
@RequestMapping("/livros")
public class LivroController {

	@Autowired
	private LivroRepository livroRepository; 
	@Autowired
	private CategoriaRepository categoriaRepository; 
	@Autowired
	private AutorRepository autorRepository; 
	
	@PostMapping
	@Transactional
	public ResponseEntity<?> cadastrar(@RequestBody @Valid NovoLivroDTO livroDTO) {
		Livro livro = livroDTO.paraLivro(categoriaRepository, autorRepository);
		livroRepository.save(livro);
		return ResponseEntity.ok().build();
	}
}