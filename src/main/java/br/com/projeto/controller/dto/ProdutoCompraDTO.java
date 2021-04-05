package br.com.projeto.controller.dto;

import javax.validation.constraints.NotNull;

public class ProdutoCompraDTO {

	@NotNull
	private Double descontoPercentual; 
	@NotNull
	private Long idProduto;
	@NotNull
	private Long idUsuario;
	@NotNull
	private Integer quantidade;
	
 
	public Double getDescontoPercentual() {
		return descontoPercentual;
	}

	public Long getIdProduto() {
		return idProduto;
	}

	public Long getIdUsuario() {
		return idUsuario;
	}

	public void setDescontoPercentual(Double descontoPercentual) {
		this.descontoPercentual = descontoPercentual;
	}

	public void setIdProduto(Long idProduto) {
		this.idProduto = idProduto;
	}

	public void setIdUsuario(Long idUsuario) {
		this.idUsuario = idUsuario;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}
 
	
 
}
