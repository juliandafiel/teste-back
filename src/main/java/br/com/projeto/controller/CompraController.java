package br.com.projeto.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.projeto.controller.dto.ProdutoCompraDTO;
import br.com.projeto.modelo.Compra;
import br.com.projeto.modelo.Produto;
import br.com.projeto.modelo.Usuario;
import br.com.projeto.repository.CompraRepository;
import br.com.projeto.repository.ProdutoRepository;
import br.com.projeto.repository.UsuarioRepository;

@RestController
@RequestMapping("/compra")
public class CompraController {
	
	@Autowired
	private ProdutoRepository produtoRepository;
	
	@Autowired
	private CompraRepository compraRepository;
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	 
	
	@GetMapping
	@RequestMapping(path = "listar")
	@CrossOrigin(origins = "*")
	public List<Compra> listar() {
		return compraRepository.findAll();
	}
	
	
	@GetMapping
	@RequestMapping(path = "listar/{idUsuario}")
	@CrossOrigin(origins = "*")
	public List<Compra> listarPeloIdUsuario(@PathVariable("idUsuario") Long idUsuario) {
		return compraRepository.listarPeloIdUsuario(idUsuario);
	}
	
	@RequestMapping(value = "/comprar", method = RequestMethod.POST)
	@CrossOrigin(origins = "*")
	public ResponseEntity<Compra> comprar(@RequestBody @Valid ProdutoCompraDTO produtoCompraDTO) {
		Optional<Produto> produto = produtoRepository.findById(produtoCompraDTO.getIdProduto());
		Optional<Usuario> usuario = usuarioRepository.findById(produtoCompraDTO.getIdUsuario());
		Compra compra = new Compra();
		
		
		if(produto.isPresent() && usuario.isPresent()) {
			compra.setDescontoPercentual(produtoCompraDTO.getDescontoPercentual());
			compra.setValorSemDesconto(produto.get().getValor()*produtoCompraDTO.getQuantidade());
			compra.setValorComDesconto(produto.get().getValor()*produtoCompraDTO.getQuantidade() * (1-produtoCompraDTO.getDescontoPercentual()));
			compra.setProduto(produto.get());
			compra.setIdUsuario(usuario.get().getId());
			compra.setQuantidade(produtoCompraDTO.getQuantidade());
			compraRepository.save(compra);
			
			return ResponseEntity.ok(compra);
		}
		 
		return ResponseEntity.notFound().build();
	}
	
	
	
	@RequestMapping(value = "/comprar-produtos", method = RequestMethod.POST)
	@CrossOrigin(origins = "*")
	public ResponseEntity<Compra[]> comprarProdutos(@RequestBody @Valid ProdutoCompraDTO[] produtoCompraDTOs) {
		
		ArrayList<Compra> compras = new ArrayList<Compra>();
		for(ProdutoCompraDTO produtoCompraDTO : produtoCompraDTOs) {
			Optional<Produto> produto = produtoRepository.findById(produtoCompraDTO.getIdProduto());
			Optional<Usuario> usuario = usuarioRepository.findById(produtoCompraDTO.getIdUsuario());
			Compra compra = new Compra();
		
			if(produto.isPresent() && usuario.isPresent()) {
				compra.setDescontoPercentual(produtoCompraDTO.getDescontoPercentual());
				compra.setValorSemDesconto(produto.get().getValor()*produtoCompraDTO.getQuantidade());
				compra.setValorComDesconto(produto.get().getValor()*produtoCompraDTO.getQuantidade() * (1-produtoCompraDTO.getDescontoPercentual()));
				compra.setProduto(produto.get());
				compra.setQuantidade(produtoCompraDTO.getQuantidade());
				compra.setIdUsuario(usuario.get().getId());
				compraRepository.save(compra);
				compras.add(compra);
			}
		}
		if(!compras.isEmpty()) {
			return ResponseEntity.ok(compras.toArray(new Compra[] {}));
		}
		 
		return ResponseEntity.notFound().build();
	}
	
	  
	

}







