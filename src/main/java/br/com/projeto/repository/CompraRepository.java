package br.com.projeto.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.projeto.modelo.Compra;
import br.com.projeto.modelo.Produto;

public interface CompraRepository extends JpaRepository<Compra, Long> {
	
	@Query("SELECT c FROM Compra c where c.idUsuario = ?1")
	public List<Compra> listarPeloIdUsuario(Long idUsuario) ;

	@Query("SELECT c FROM Compra c where c.produto.id = ?1")
	public List<Compra> listarComprasPeloIdProduto(Long idProduto) ;
}
