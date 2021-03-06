package com.Cavallaro.Elegance.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Cavallaro.Elegance.Model.Loja;

import com.Cavallaro.Elegance.Repository.LojaRepository;
import com.Cavallaro.Elegance.Service.LojaService;

@RestController
@RequestMapping("/loja")
@CrossOrigin ("*")
public class LojaController {

	@Autowired
	private LojaRepository repository;
	
	@Autowired
	private LojaService service;
	
	@GetMapping
	public ResponseEntity <List<Loja>> getAll(){
		return ResponseEntity.ok(repository.findAll());
	}
	
	@GetMapping("/{idLoja}")
	public ResponseEntity<Loja> getById(@PathVariable long idLoja){
		return repository.findById(idLoja).map(resp -> ResponseEntity.ok(resp))
				.orElse(ResponseEntity.notFound().build());
	}
	
	@PostMapping
	public ResponseEntity<Loja> post (@RequestBody Loja loja){
		return ResponseEntity.status(HttpStatus.CREATED)
				.body(repository.save(loja));
	}
	
	  @PutMapping
	public ResponseEntity<Loja> put (@RequestBody Loja loja){
		return ResponseEntity.ok(repository.save(loja));				
	}
	
	   @PutMapping("/LojaUsuario/loja/{Loja_fk}/usuario/{Usuario_fk}")
	public ResponseEntity<Loja> postLojaUsuario (@PathVariable long Loja_fk,@PathVariable long Usuario_fk){
		
		return ResponseEntity.status(HttpStatus.CREATED)
				.body(service.UsuarioLoja(Loja_fk, Usuario_fk));
	} 
	  
	  
	  @DeleteMapping("/{idLoja}")
		public void delete (@PathVariable long idLoja){
			repository.deleteById(idLoja);
		}
}
