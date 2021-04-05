package br.com.projeto.modelo;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Compra {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private Long idUsuario;
	
	@ManyToOne(cascade = CascadeType.ALL)
	private Produto produto;
	
	@Column(name="desconto_percentual")
	private Double descontoPercentual;
	
	@Column(name="valor_sem_desconto")
	private Double valorSemDesconto;
	
	@Column(name="valor_com_desconto")
	private Double valorComDesconto;
	
	private int quantidade;
	
	public Compra() {
		// TODO Auto-generated constructor stub
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
 
	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public Double getDescontoPercentual() {
		return descontoPercentual;
	}

	public void setDescontoPercentual(Double descontoPercentual) {
		this.descontoPercentual = descontoPercentual;
	}

	public Double getValorSemDesconto() {
		return valorSemDesconto;
	}

	public void setValorSemDesconto(Double valorSemDesconto) {
		this.valorSemDesconto = valorSemDesconto;
	}

	public Double getValorComDesconto() {
		return valorComDesconto;
	}

	public void setValorComDesconto(Double valorComDesconto) {
		this.valorComDesconto = valorComDesconto;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public Long getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(Long idUsuario) {
		this.idUsuario = idUsuario;
	}

	 
	 
 
	 

}
