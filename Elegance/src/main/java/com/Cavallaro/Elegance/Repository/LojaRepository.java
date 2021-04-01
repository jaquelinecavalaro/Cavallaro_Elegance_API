package com.Cavallaro.Elegance.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.Cavallaro.Elegance.Model.Loja;

public interface LojaRepository extends JpaRepository <Loja, Long> {
	
	public List<Loja> findAllByNomeLojaContainingIgnoreCase (String tituloProduto);
	
	
	
	public List<Loja> findAllByPrecoLessThanEqual (float preco);
	
	public List<Loja> findAllByPrecoGreaterThanEqual (float preco);
	
	@Query(value = "select * from db_loja inner join tb_marca on  db_usuario.id = db_loja.marca_id where db_usuario.nome = :usuario", nativeQuery = true)
	public List<Loja> findAllProdutoByCategoriaDecicao(@Param("usuario") String usuario);
	
}
