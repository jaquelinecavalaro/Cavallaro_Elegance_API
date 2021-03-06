package com.Cavallaro.Elegance.Service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Cavallaro.Elegance.Model.Loja;
import com.Cavallaro.Elegance.Model.Usuario;
import com.Cavallaro.Elegance.Repository.LojaRepository;
import com.Cavallaro.Elegance.Repository.UsuarioRepository;

@Service
public class LojaService {

		@Autowired
		private LojaRepository repositoryLoja;
		
		@Autowired
		private UsuarioRepository repositoryUsuario;
		
		public Loja UsuarioLoja (long lojaId, long usuarioId) {
			
			Optional<Loja> lojaExistente = repositoryLoja.findById(lojaId);
			Optional<Usuario> usuarioExistente = repositoryUsuario.findById(usuarioId);
			
			if (lojaExistente.isPresent()&&usuarioExistente.isPresent()) {
				
				lojaExistente.get().getUsuario().add(usuarioExistente.get());
				
				repositoryLoja.save(lojaExistente.get());
				
				return repositoryLoja.save(lojaExistente.get());
		
	
				
			}
			
			return null;
		}
		
}
