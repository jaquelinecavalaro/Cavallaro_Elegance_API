package com.Cavallaro.Elegance.Model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "db_usuario")
public class Usuario {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idUsuario;
	
	@NotNull
	@Size (max = 45)
	private String nome;
	
	@NotNull
	@Size (max = 45)
	private String usuario;
	
	@NotNull
	@Size (max = 45)
	private String senha;
	
	
	@ManyToMany(mappedBy = "usuarios", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JsonIgnoreProperties ({"nomeLoja","descricao", "usuarios", "produto"})
	private List<Loja> LojaUsuario = new ArrayList<>();


	public long getIdUsuario() {
		return idUsuario;
	}


	public void setIdUsuario(long idUsuario) {
		this.idUsuario = idUsuario;
	}


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public String getUsuario() {
		return usuario;
	}


	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}


	public String getSenha() {
		return senha;
	}


	public void setSenha(String senha) {
		this.senha = senha;
	}


	public List<Loja> getLojaUsuario() {
		return LojaUsuario;
	}


	public void setLojaUsuario(List<Loja> lojaUsuario) {
		LojaUsuario = lojaUsuario;
	}






	
	
}
