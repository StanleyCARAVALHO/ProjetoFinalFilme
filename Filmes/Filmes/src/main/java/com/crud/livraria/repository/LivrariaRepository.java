package com.crud.livraria.repository;

import org.springframework.data.repository.CrudRepository;

import com.crud.livraria.models.Livro;

public interface LivrariaRepository extends CrudRepository<Livro, String> {
	
	Livro findByCodigoLivro(long codigoLivro);
	Livro deleteByCodigoLivro(long codigoLivro);
	
}
