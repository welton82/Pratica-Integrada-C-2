package com.praticaintegrada.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.praticaintegrada.entities.pk.InventarioPK;
@Entity
@Table(name = "inventario")
public class Inventario implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@EmbeddedId
	private InventarioPK id = new InventarioPK();
	
	private Date dataInventario;
	//private Local  sala;
		
	public Inventario() {
		
	}

	public Inventario(Local local, Patrimonio patrimonio, Date dataInventario) {
		super();
		this.dataInventario = dataInventario;
		//id.setUsuario(usuario);
		id.setLocal(local);
		id.setPatrimonio(patrimonio);
		
	}
	
	//@JsonIgnore //REFERENTE À CLASSE CADASTRO
//	public Usuario getUsuario() {
//		return id.getUsuario();
//	}
//	public void setUsuario(Usuario usuario) {
//		id.setUsuario(usuario);
//	}
	//@JsonIgnore //REFERENTE À CLASSE Local
	public Local getLocal() {
		return id.getLocal();
	}
	public void setLocal(Local local) {
		id.setLocal(local);
	}
	
	public Patrimonio getPatrimonio() {
		return id.getPatrimonio();
	}
	public void setPatrimonio(Patrimonio patrimonio) {
		id.setPatrimonio(patrimonio);
		//this.sala = id.getPatrimonio().getLocais();
	}
	
	public Date getDataInventario() {
		return dataInventario;
	}

	public void setDataInventario(Date dataInventario) {
		this.dataInventario = dataInventario;
	}

//	public Local getLocal() {
//		this.sala;
//	}
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
		Inventario other = (Inventario) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
	
}
