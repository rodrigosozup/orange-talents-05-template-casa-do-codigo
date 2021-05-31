package br.com.zupacademy.rodrigoso.casadocodigo.dto;

import java.time.LocalDate;
import java.util.Optional;

import javax.validation.constraints.Future;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Range;
import org.springframework.web.bind.MethodArgumentNotValidException;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;

import br.com.zupacademy.rodrigoso.casadocodigo.modelo.Autor;
import br.com.zupacademy.rodrigoso.casadocodigo.modelo.Categoria;
import br.com.zupacademy.rodrigoso.casadocodigo.modelo.Livro;
import br.com.zupacademy.rodrigoso.casadocodigo.repository.AutorRepository;
import br.com.zupacademy.rodrigoso.casadocodigo.repository.CategoriaRepository;
import br.com.zupacademy.rodrigoso.casadocodigo.utils.UniqueValue;

public class NovoLivroDTO {

	@NotBlank(message = "Preenchimento obrigatório")
	@UniqueValue(domainClass = Livro.class,fieldName = "titulo")
	private String titulo; 
	@NotBlank(message = "Preenchimento obrigatório")
	@Size(max = 500,  message = "Tamanho máximo de {max} caracteres")
	private String resumo; 
	private String sumario; 
	@Range(min =  20, message = "Mínimo de 20")
	private Double saldo; 
	@NotNull(message = "Preenchimento obrigatório")
	@Range(min =  100, message = "Mínimo de {min}")
	private int numeroDePaginas; 
	@NotBlank(message = "Preenchimento obrigatório")
	@UniqueValue(domainClass = Livro.class,fieldName = "isbn")
	private String isbn; 
	@Future
	@JsonFormat(pattern = "dd/MM/yyyy" , shape = Shape.STRING)
	private LocalDate dataPublicacao; 
	@NotNull(message = "Preenchimento obrigatório")
	private Long categoriaId; 
	@NotNull(message = "Preenchimento obrigatório")
	private Long autorId; 
	
	
	public NovoLivroDTO() {
		
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


	public LocalDate getDataPublicacao() {
		return dataPublicacao;
	}


	public Long getCategoriaId() {
		return categoriaId;
	}


	public Long getAutorId() {
		return autorId;
	}


	public Livro paraLivro(CategoriaRepository categoriaRepository, AutorRepository autorRepository) {
		Categoria categoria = buscarCategoria(categoriaRepository); 
		Autor autor = buscarAutor(autorRepository); 
		return new Livro(titulo, resumo,sumario,  saldo, numeroDePaginas, isbn,dataPublicacao,
				categoriaId, autorId, categoria,autor); 
	}

	private Categoria buscarCategoria(CategoriaRepository categoriaRepository) {
		Optional<Categoria> categoria = categoriaRepository.findById(categoriaId); 
		if(categoria.isPresent()) {
			return categoria.get(); 
		}
		throw new IllegalArgumentException("Categoria de id: "+ categoriaId +" não encontrada"); 
	}
	
	private Autor buscarAutor(AutorRepository autorRepository) {
		Optional<Autor> autor = autorRepository.findById(autorId); 
		if(autor.isPresent()) {
			return autor.get(); 
		}
		throw new IllegalArgumentException("Autor(a) de id: "+ autorId +" não encontrado(a)"); 
	}
}
