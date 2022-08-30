package com.praticaintegrada.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
@Entity
@Table(name="usuario")
public class Usuario implements Serializable{
	private static final long serialVersionUID = 1L;
	
	/*https://lucid.app/lucidchart/40b32d60-d84b-4212-894f-
	  0a879dcc5aef/edit?invitationId=inv_b5b07fe3-de4b-4303-8056-9b0ba9f641a9&page=0_0#
	  */
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String nome;
	private String login;
	private String senha;
	
//	@JsonIgnore
//	@OneToMany(mappedBy = "usuario")//usuario do OBJ cadastro
//	private List<Cadastro>cadastros = new ArrayList<>();
	
	
//	@JsonIgnore
//	@OneToMany(mappedBy = "patrimonio")//usuario do OBJ patrimonio
	
//	@JsonIgnore
	@OneToMany
	@JoinTable(name = "patrimonio_usuario", 
	joinColumns = @JoinColumn(name = "usuario_id"),
	inverseJoinColumns = @JoinColumn(name = "patrimonio_id"))
	
	//@OneToMany(mappedBy = "usuario")//usuario do OBJ cadastro
	private List<Patrimonio>patrimonios = new ArrayList<>();
	
	public Usuario() {
		
	}
	public Usuario(Long id, String nome, String login, String senha) {
		super();
		this.id = id;
		this.nome = nome;
		this.login = login;
		this.senha = senha;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	
//	public List<Cadastro> getCadastros() {
//		return cadastros;
//	}
	public List<Patrimonio> getPatrimonio() {
		return patrimonios;
	}
	
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Usuario other = (Usuario) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
	
}
