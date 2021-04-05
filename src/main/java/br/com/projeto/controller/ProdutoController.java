package br.com.projeto.controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.projeto.controller.dto.ProdutoDto;
import br.com.projeto.modelo.Compra;
import br.com.projeto.modelo.Produto;
import br.com.projeto.repository.CompraRepository;
import br.com.projeto.repository.ProdutoRepository;

@RestController
@RequestMapping("/produto")
public class ProdutoController {
	
	@Autowired
	private ProdutoRepository produtoRepository;
	
	@Autowired
	private CompraRepository compraRepository;
	 
	
	@GetMapping
	@RequestMapping(path = "listar")
	@CrossOrigin(origins = "*")
	public List<Produto> listar() {
		return produtoRepository.findAll();
	}
	
	@PostMapping
	@Transactional
	@RequestMapping(value = "/inserir")
	@CrossOrigin(origins = "*")
	public ResponseEntity<ProdutoDto> inserir(@RequestBody @Valid Produto produto, UriComponentsBuilder uriBuilder) {
		Produto prod = produtoRepository.save(produto);
		
		URI uri = uriBuilder.path("/produto/{id}").buildAndExpand(prod.getId()).toUri();
		return ResponseEntity.created(uri).body(new ProdutoDto(prod));
	}
	
	
	@RequestMapping(value="/atualizar/{id}", method = RequestMethod.PUT)
	@Transactional  
	@CrossOrigin(origins = "*")
	public ResponseEntity<ProdutoDto> atualizar(@PathVariable("id") Long id, @RequestBody @Valid Produto produto) {
		Produto p = new ProdutoDto(produto).updateProduto(produtoRepository, produto, id);
		if(p != null) {
			return ResponseEntity.ok(new ProdutoDto(p));
		}
		 
		return ResponseEntity.notFound().build();
	}
	
	@RequestMapping(value="/excluir/{id}", method = RequestMethod.DELETE)
	@Transactional
	@CrossOrigin(origins = "*")
	public ResponseEntity<?> deletar(@PathVariable Long id) {
		List<Compra> compras = compraRepository.listarComprasPeloIdProduto(id);
		
		if(compras == null || compras.isEmpty()) {
			Optional<Produto> optional = produtoRepository.findById(id);
			if (optional.isPresent()) {
				produtoRepository.deleteById(id);
				return ResponseEntity.ok(optional.get());
			}
		}
		
		return ResponseEntity.notFound().build();
	}

}







