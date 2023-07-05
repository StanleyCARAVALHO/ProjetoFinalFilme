package com.crud.livraria.models;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Livro implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	private long codigoLivro;
	
	private String titulo;
	private String autorNome;
	private String autorSobrenome;
	private String lançamento;
	private String bilheteria;
	
	private int edicao;
	private int numeroPaginas;

	public Livro() {
		// TODO Auto-generated constructor stub
	}

	public long getCodigoLivro() {
		return codigoLivro;
	}

	public void setCodigoLivro(long codigoLivro) {
		this.codigoLivro = codigoLivro;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getAutorNome() {
		return autorNome;
	}

	public void setAutorNome(String autorNome) {
		this.autorNome = autorNome;
	}

	public String getAutorSobrenome() {
		return autorSobrenome;
	}

	public void setAutorSobrenome(String autorSobrenome) {
		this.autorSobrenome = autorSobrenome;
	}

	public String getIsbn() {
		return lançamento;
	}

	public void setIsbn(String lançamento) {
		this.lançamento = lançamento;
	}

	public String getEditora() {
		return bilheteria;
	}

	public void setEditora(String Bilheteria) {
		this.bilheteria = Bilheteria;
	}

	public int getEdicao() {
		return edicao;
	}

	public void setEdicao(int edicao) {
		this.edicao = edicao;
	}

	public int getNumeroPaginas() {
		return numeroPaginas;
	}

	public void setNumeroPaginas(int numeroPaginas) {
		this.numeroPaginas = numeroPaginas;
	}

}
