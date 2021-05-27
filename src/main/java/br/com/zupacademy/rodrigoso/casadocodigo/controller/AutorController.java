package br.com.zupacademy.rodrigoso.casadocodigo.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.zupacademy.rodrigoso.casadocodigo.dto.NovoAutorDTO;
import br.com.zupacademy.rodrigoso.casadocodigo.modelo.Autor;
import br.com.zupacademy.rodrigoso.casadocodigo.repository.AutorRepository;

@RestController
@RequestMapping("/autores")
public class AutorController {

	@Autowired
	private AutorRepository autorRepository;

	@PostMapping
	@Transactional
	public ResponseEntity<?> cadastrar(@RequestBody @Valid NovoAutorDTO autorDTO) {
		Autor autor = autorDTO.paraAutor();
		autorRepository.save(autor);
		return ResponseEntity.ok().build();
	}
}
