package br.com.zupacademy.rodrigoso.casadocodigo.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.Length;

import br.com.zupacademy.rodrigoso.casadocodigo.modelo.Autor;
import br.com.zupacademy.rodrigoso.casadocodigo.utils.UniqueValue;

public class NovoAutorDTO {

	@NotBlank(message = "Preenchimento obrigatório")
	private String nome;
	@NotBlank(message = "Preenchimento obrigatório")
	@Email(message = "Email inválido")
	@UniqueValue(domainClass = Autor.class,fieldName = "email")
	private String email;
	@NotBlank(message = "Preenchimento obrigatório")
	@Length(max = 400, message = "Tamanho máximo de 400 caracteres ")
	private String descricao;

	public NovoAutorDTO() {

	}

	public String getNome() {
		return nome;
	}

	public String getEmail() {
		return email;
	}

	public String getDescricao() {
		return descricao;
	}

	public Autor paraAutor() {
		return new Autor(nome, email, descricao);
	}
}
