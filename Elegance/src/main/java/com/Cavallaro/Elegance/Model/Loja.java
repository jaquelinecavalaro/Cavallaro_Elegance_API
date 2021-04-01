package com.Cavallaro.Elegance.Model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;



@Entity
@Table(name = "db_loja")
public class Loja {

	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private long idLoja;
	
	@NotNull
	@Size (max = 45)
	private String nomeLoja;
	
	@NotNull
	@Size (max = 100)
	private String descricao;
	
	//vamos criar o manytomany, essa sera minha principal tabela
	
	
	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinTable(name = "LojaUsuario", joinColumns = @JoinColumn(name = "Loja_fk"),
	inverseJoinColumns = {@JoinColumn (name = "Usuario_fk")})
	@JsonIgnoreProperties ({"nome", "usuario", "senha, LojaUsuario"})
	private List<Usuario> usuario = new ArrayList<>();
	
	
	@OneToMany(mappedBy = "Loja" , cascade = CascadeType.ALL)
	@JsonIgnoreProperties("Loja")
	private List <Produto> produto;

	public long getIdLoja() {
		return idLoja;
	}

	public void setIdLoja(long idLoja) {
		this.idLoja = idLoja;
	}

	public String getNomeLoja() {
		return nomeLoja;
	}

	public void setNomeLoja(String nomeLoja) {
		this.nomeLoja = nomeLoja;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public List<Usuario> getUsuario() {
		return usuario;
	}

	public void setUsuario(List<Usuario> usuario) {
		this.usuario = usuario;
	}

	public List<Produto> getProduto() {
		return produto;
	}

	public void setProduto(List<Produto> produto) {
		this.produto = produto;
	}

	
	
}
