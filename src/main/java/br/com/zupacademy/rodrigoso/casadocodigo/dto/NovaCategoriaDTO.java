package br.com.zupacademy.rodrigoso.casadocodigo.dto;

import javax.validation.constraints.NotBlank;

import br.com.zupacademy.rodrigoso.casadocodigo.modelo.Categoria;
import br.com.zupacademy.rodrigoso.casadocodigo.utils.UniqueValue;

public class NovaCategoriaDTO {

	@NotBlank(message = "Preenchimento obrigatório")
	@UniqueValue(domainClass = Categoria.class, fieldName = "nome")
	private String nome;
	
	public NovaCategoriaDTO() {
	}
	
	public String getNome() {
		return this.nome; 
	}
	
	public Categoria paraCategoria() {
		return new Categoria(this.nome); 
	}
}
