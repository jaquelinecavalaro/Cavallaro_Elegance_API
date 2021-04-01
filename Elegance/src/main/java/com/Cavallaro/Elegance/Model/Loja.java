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
	
	@OneToMany(mappedBy = "loja" , cascade = CascadeType.ALL)
	@JsonIgnoreProperties({"loja","nomeLoja", "descricao"})
	private List <Produto> produto;
	
	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinTable(name = "lojaUsuario", joinColumns = @JoinColumn(name = "loja_fk"),
	inverseJoinColumns = @JoinColumn (name = "usuario_fk"))
	@JsonIgnoreProperties ({"nome","usuario","senha","lojaUsuario"})
	private List<Usuario> usuarios = new ArrayList<>();
	
	/*
     * EXPLICACAO URI:
     * 
     *     /lojaUsuario -> nome da tabela associativa
     *     /usuarios -> nome da lista de jogos dentro da classe Loja
     *     /lojaUsuario -> nome da lista de plataformas dentro da classe Usuario
     * 
     * */

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

	public List<Usuario> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

	public List<Produto> getProduto() {
		return produto;
	}

	public void setProduto(List<Produto> produto) {
		this.produto = produto;
	}

	
	
}
