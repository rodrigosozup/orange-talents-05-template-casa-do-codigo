package br.com.zupacademy.rodrigoso.casadocodigo.dto;

import br.com.zupacademy.rodrigoso.casadocodigo.modelo.Livro;

public class LivroDTO {

	private Long id; 
	private String titulo; 
	
	public LivroDTO(Livro livro) {
		this.id = livro.getId(); 
		this.titulo = livro.getTitulo(); 
	}
	
	public Long getId() {
		return this.id; 
	}
	
	public String getTitulo() {
		return this.titulo; 
	}
}
