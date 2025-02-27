package br.com.zupacademy.rodrigoso.casadocodigo.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.zupacademy.rodrigoso.casadocodigo.dto.NovaCategoriaDTO;
import br.com.zupacademy.rodrigoso.casadocodigo.modelo.Categoria;
import br.com.zupacademy.rodrigoso.casadocodigo.repository.CategoriaRepository;

@RestController
@RequestMapping("/categorias")
public class CategoriaController {

	@Autowired
	private CategoriaRepository categoriaRepository;
	
	@PostMapping
	@Transactional
	public ResponseEntity<?> cadastrar(@RequestBody @Valid NovaCategoriaDTO categoriaDTO) {
		Categoria categoria = categoriaDTO.paraCategoria();
		categoriaRepository.save(categoria);
		return ResponseEntity.ok().build();
	}
}
