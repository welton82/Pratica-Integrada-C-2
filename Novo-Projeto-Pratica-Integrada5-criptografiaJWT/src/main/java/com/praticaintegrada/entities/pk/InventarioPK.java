package com.praticaintegrada.entities.pk;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.praticaintegrada.entities.Local;
import com.praticaintegrada.entities.Patrimonio;
import com.praticaintegrada.entities.Usuario;

//usado para classe auxiliar(PK)
//classe auxiliar possuem dois primary key
@Embeddable
public class InventarioPK implements Serializable{
	private static final long serialVersionUID = 1L;
	
	//CLASSES AUXILIARES NÃO POSSUEM CONSTRUTORES
//	@ManyToOne
//	@JoinColumn(name = "local_id")
//	private Usuario local;
	
	@ManyToOne
	@JoinColumn(name = "local_id")
	private Local local;
	
	
	@ManyToOne
	@JoinColumn(name = "patrimonio_id")
	private Patrimonio patrimonio;
	
	
	
	
	
//	public Usuario getUsuario() {
//		return local;
//	}
//	public void setUsuario(Usuario local) {
//		this.local = local;
//	}
	
	public Local getLocal() {
		return local;
	}
	public void setLocal(Local local) {
		this.local = local;
	}
	public Patrimonio getPatrimonio() {
		return patrimonio;
	}
	
	public void setPatrimonio(Patrimonio patrimonio) {
		this.patrimonio = patrimonio;
	}
	
	
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((local == null) ? 0 : local.hashCode());
		result = prime * result + ((patrimonio == null) ? 0 : patrimonio.hashCode());
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
		InventarioPK other = (InventarioPK) obj;
		if (local == null) {
			if (other.local != null)
				return false;
		} else if (!local.equals(other.local))
			return false;
		if (patrimonio == null) {
			if (other.patrimonio != null)
				return false;
		} else if (!patrimonio.equals(other.patrimonio))
			return false;
		return true;
	}
	
	
}
