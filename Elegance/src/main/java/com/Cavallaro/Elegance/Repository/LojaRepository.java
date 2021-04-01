package com.Cavallaro.Elegance.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Cavallaro.Elegance.Model.Loja;

public interface LojaRepository extends JpaRepository <Loja, Long> {
	
	public List<Loja> findAllByNomeLojaContainingIgnoreCase (String tituloProduto);
}
