package br.com.zupacademy.rodrigoso.casadocodigo.component;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import br.com.zupacademy.rodrigoso.casadocodigo.dto.NovoAutorDTO;
import br.com.zupacademy.rodrigoso.casadocodigo.modelo.Autor;
import br.com.zupacademy.rodrigoso.casadocodigo.repository.AutorRepository;

@Component
public class ProibeEmailDuplicadoAutorValidator implements Validator{

	@Autowired
	private AutorRepository autorRepository; 
	
	@Override
	public boolean supports(Class<?> clazz) {
		return NovoAutorDTO.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		if(errors.hasErrors()) {
			return ; 
		}
		
		NovoAutorDTO autorDTO = (NovoAutorDTO) target; 
		Optional<Autor> autor = autorRepository.findByEmail(autorDTO.getEmail()); 
		
		if(autor.isPresent()) {
			errors.rejectValue("email", null,"Já existe um(a) Autor(a) "
					+ "com o mesmo email: "+autorDTO.getEmail());
		}
	}

}
