package com.Cavallaro.Elegance.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Cavallaro.Elegance.Model.Usuario;

public interface UsuarioRepository extends JpaRepository <Usuario, Long>{

	public List <Usuario> findAllByNomeContainingIgnoreCase(String nome);
}
