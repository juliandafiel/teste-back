package br.com.projeto.controller.dto;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;

import br.com.projeto.modelo.Produto;
import br.com.projeto.repository.ProdutoRepository;

public class ProdutoDto {

	private String nome;
	private String descricao;
	private String imagem;
	private Double valor;
	private int qtdEstoque;
	
	public ProdutoDto(Produto produto) {
		this.nome = produto.getNome();
		this.descricao = produto.getDescricao();
		this.imagem = produto.getImagem();
		this.valor = produto.getValor();
		this.qtdEstoque = produto.getQtdEstoque();
	}
 
	 

	public static List<ProdutoDto> converter(List<Produto> produtos) {
		return produtos.stream().map(ProdutoDto::new).collect(Collectors.toList());
	}



	public String getNome() {
		return nome;
	}



	public void setNome(String nome) {
		this.nome = nome;
	}



	public String getDescricao() {
		return descricao;
	}



	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}



	public String getImagem() {
		return imagem;
	}



	public void setImagem(String imagem) {
		this.imagem = imagem;
	}



	public Double getValor() {
		return valor;
	}



	public void setValor(Double valor) {
		this.valor = valor;
	}



	public int getQtdEstoque() {
		return qtdEstoque;
	}



	public void setQtdEstoque(int qtdEstoque) {
		this.qtdEstoque = qtdEstoque;
	}

 


	public Produto updateProduto(ProdutoRepository produtoRepository, @Valid Produto produto, Long id) {
		
		Optional<Produto> prod = produtoRepository.findById(id);
		
		if (prod.isPresent()) {
			Produto p = prod.get();
			p.setDescricao(produto.getDescricao());
			p.setImagem(produto.getImagem());
			p.setNome(produto.getNome());
			p.setQtdEstoque(produto.getQtdEstoque());
			p.setValor(produto.getValor());
			return p;
		}
		return null;
			
	}
 
 
 
	
}
