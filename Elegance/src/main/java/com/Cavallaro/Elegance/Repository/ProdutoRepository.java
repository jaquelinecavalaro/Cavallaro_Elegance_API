package com.Cavallaro.Elegance.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Cavallaro.Elegance.Model.Produto;

public interface ProdutoRepository extends JpaRepository <Produto, Long>{

	public List<Produto> findAllByTituloProdutoContainingIgnoreCase (String tituloProduto);
}
