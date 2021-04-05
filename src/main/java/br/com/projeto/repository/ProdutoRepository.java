package br.com.projeto.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.projeto.modelo.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {

	 
}
