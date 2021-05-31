package br.com.zupacademy.rodrigoso.casadocodigo.modelo;

import java.time.LocalDate;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Future;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Range;

@Entity
public class Livro {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id; 
	@NotBlank
	private String titulo;
	@NotBlank
	@Size(max = 500)
	private String resumo;
	private String sumario;
	@Range(min = 20)
	private Double saldo;
	@NotNull
	@Range(min = 100)
	private int numeroDePaginas;
	@NotBlank
	private String isbn;
	@Future
	private LocalDate dataPublicacao;
	
	@ManyToOne
	@JoinColumn(name = "categoria_id")
	private Categoria categoria; 
	@ManyToOne
	@JoinColumn(name = "autor_id")
	private Autor autor; 
	
	public Livro(String titulo,String resumo, String sumario, Double saldo,int numeroDePaginas, 
			String isbn, LocalDate dataPublicacao,  Long categoriaId,Long autorId,Categoria categoria,Autor autor ) {
		this.titulo = titulo;
		this.resumo = resumo;
		this.sumario = sumario; 
		this.saldo = saldo;
		this.numeroDePaginas = numeroDePaginas;
		this.isbn = isbn;
		this.dataPublicacao  = dataPublicacao; 
		this.categoria = categoria; 
		this.autor = autor; 
		
	}
	
	private void setId(Long id) {
		this.id =id; 
	}
	
	
}
