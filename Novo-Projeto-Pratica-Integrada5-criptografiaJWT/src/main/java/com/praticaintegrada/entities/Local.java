package com.praticaintegrada.entities;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "local")
public class Local implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	//@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String nome;
	private String referenciaUnidade;
	//cococar apenas um para muitos
	//@Transient//impede que o JPA tente interpretar o set
	@JsonIgnore
	@ManyToMany(mappedBy = "local")
	private Set<Patrimonio> patrimonios = new HashSet<>();
	
	public Local() {
		
	}
	public Local(Long id, String nome, String referenciaUnidade) {
		super();
		this.id = id;
		this.nome = nome;
		this.referenciaUnidade = referenciaUnidade;
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

	public String getReferenciaUnidade() {
		return referenciaUnidade;
	}

	public void setReferenciaUnidade(String referenciaUnidade) {
		this.referenciaUnidade = referenciaUnidade;
	}

	public Set<Patrimonio> getPatrimonios() {
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
		Local other = (Local) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	

	
	/*21340   5
	 * 22791  2
	 * 22341   3
	 * 21790   4*/
	
	
}
