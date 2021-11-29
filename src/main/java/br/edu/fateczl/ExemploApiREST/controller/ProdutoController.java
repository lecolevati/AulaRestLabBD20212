package br.edu.fateczl.ExemploApiREST.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.fateczl.ExemploApiREST.model.DTO.ProdutoDTO;
import br.edu.fateczl.ExemploApiREST.model.entity.Produto;
import br.edu.fateczl.ExemploApiREST.repository.ProdutoRepository;

@RestController
@RequestMapping("/api")
public class ProdutoController {
	
	@Autowired
	private ProdutoRepository pRep;
	
	@GetMapping("/produto")
	public List<ProdutoDTO> listaProdutos() {
		List<Produto> produtos = pRep.findAll();
		List<ProdutoDTO> produtosDTO = convertListProdutoListProdutoDTO(produtos);
		return produtosDTO;
	}
	
	@GetMapping("/produto/{idProduto}")
	public ResponseEntity<ProdutoDTO> consultaProduto(
			@PathVariable(value = "idProduto") int idProduto) {
		Produto produto = pRep.findById(idProduto).orElseThrow(
				() -> new ResourceNotFoundException(idProduto+" inválido"));
		ProdutoDTO produtoDTO = convertProdutoProdutoDTO(produto);
		return ResponseEntity.ok().body(produtoDTO);
	}
	
	@PostMapping("/produto")
	public ResponseEntity<String> adicionaProduto(
			@Valid @RequestBody Produto p) {
		pRep.save(p);
		String saida = "Produto adicionado com sucesso";
		return ResponseEntity.ok().body(saida);
	}

	@PutMapping("/produto")
	public ResponseEntity<String> atualizaProduto(
			@Valid @RequestBody Produto p) {
		pRep.save(p);
		String saida = "Produto atualizado com sucesso";
		return ResponseEntity.ok().body(saida);
	}

	@DeleteMapping("/produto")
	public ResponseEntity<String> excluiProduto(
			@Valid @RequestBody Produto p) {
		pRep.delete(p);
		String saida = "Produto excluido com sucesso";
		return ResponseEntity.ok().body(saida);
	}

	private List<ProdutoDTO> convertListProdutoListProdutoDTO(List<Produto> produtos) {
		List<ProdutoDTO> produtosDTO = new ArrayList<ProdutoDTO>();
		for (Produto p : produtos) {
			ProdutoDTO pDTO = new ProdutoDTO();
			pDTO.setId(p.getId());
			pDTO.setNome(p.getNome());
			pDTO.setValor(p.getValor());
			
			produtosDTO.add(pDTO);
		}
		return produtosDTO;
	}
	
	private ProdutoDTO convertProdutoProdutoDTO(Produto p) {
		ProdutoDTO pDTO = new ProdutoDTO();
		pDTO.setId(p.getId());
		pDTO.setNome(p.getNome());
		pDTO.setValor(p.getValor());
			
		return pDTO;
	}

}
