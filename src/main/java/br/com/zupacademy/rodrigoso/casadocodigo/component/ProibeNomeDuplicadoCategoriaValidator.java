package br.com.zupacademy.rodrigoso.casadocodigo.component;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import br.com.zupacademy.rodrigoso.casadocodigo.dto.NovaCategoriaDTO;
import br.com.zupacademy.rodrigoso.casadocodigo.modelo.Categoria;
import br.com.zupacademy.rodrigoso.casadocodigo.repository.CategoriaRepository;

@Component
public class ProibeNomeDuplicadoCategoriaValidator implements Validator{

	@Autowired
	private CategoriaRepository categoriaRepository; 
	
	@Override
	public boolean supports(Class<?> clazz) {
		return NovaCategoriaDTO.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		if(errors.hasErrors()) {
			return ; 
		}
		
		NovaCategoriaDTO categoriaDTO = (NovaCategoriaDTO) target; 
		Optional<Categoria> categoria = categoriaRepository.findByNome(categoriaDTO.getNome()); 
		
		if(categoria.isPresent()) {
			errors.rejectValue("nome", null,"Já existe uma Categoria "
					+ "com o mesmo nome: "+categoriaDTO.getNome());
		}
	}

}
