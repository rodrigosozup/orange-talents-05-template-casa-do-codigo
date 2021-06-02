package br.com.zupacademy.rodrigoso.casadocodigo.dto;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import br.com.zupacademy.rodrigoso.casadocodigo.modelo.Livro;

public class DetalhesLivroDTO {

	private Long id; 
	private String titulo;
	private String resumo;
	private String sumario;
	private Double saldo;
	private int numeroDePaginas;
	private String isbn;
	private String dataPublicacao;
	private String nomeCategoria; 
	private String nomeAutor; 
	private String descricaoAutor; 
	
	public DetalhesLivroDTO(Livro livro) {
		this.id = livro.getId(); 
		this.titulo = livro.getTitulo(); 
		this.resumo = livro.getResumo(); 
		this.sumario = livro.getSumario(); 
		this.saldo =  livro.getSaldo(); 
		this.numeroDePaginas = livro.getNumeroDePaginas(); 
		this.isbn = livro.getIsbn(); 
		this.dataPublicacao = livro.getDataPublicacao().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")); 
		this.nomeCategoria = livro.getCategoria().getNome(); 
		this.nomeAutor = livro.getAutor().getNome(); 
		this.descricaoAutor = livro.getAutor().getDescricao(); 
	}

	public Long getId() {
		return id;
	}

	public String getTitulo() {
		return titulo;
	}

	public String getResumo() {
		return resumo;
	}

	public String getSumario() {
		return sumario;
	}

	public Double getSaldo() {
		return saldo;
	}

	public int getNumeroDePaginas() {
		return numeroDePaginas;
	}

	public String getIsbn() {
		return isbn;
	}

	public String getDataPublicacao() {
		return dataPublicacao;
	}

	public String getNomeCategoria() {
		return nomeCategoria;
	}

	public String getNomeAutor() {
		return nomeAutor;
	}

	public String getDescricaoAutor() {
		return descricaoAutor;
	}
	
}
