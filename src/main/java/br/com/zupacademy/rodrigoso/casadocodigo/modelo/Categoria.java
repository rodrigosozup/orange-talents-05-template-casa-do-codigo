package br.com.zupacademy.rodrigoso.casadocodigo.modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

@Entity
public class Categoria {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NotBlank
	private String nome;

	@Deprecated
	public Categoria() {
		
	}
	
	public Categoria(String nome) {
		this.nome = nome;
	}

	private void setId(Long id) {
		this.id = id;
	}

}
