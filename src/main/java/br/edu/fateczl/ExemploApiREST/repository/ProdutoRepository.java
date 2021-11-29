package br.edu.fateczl.ExemploApiREST.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.fateczl.ExemploApiREST.model.entity.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Integer>{
	
//	@Procedure(name = "Produto.spXxxx")
//	String spXxxx(@Param("Param1") int param1, @Param("Param2") int param2,
//			@Param("Param3") String param3, @Param("Param4") int param4);
//	
//	Produto fnYyyy(int id);
	
}
