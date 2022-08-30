package com.praticaintegrada.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.praticaintegrada.enuns.CadastroStatus;

@Entity
@Table(name = "patrimonio")
public class Patrimonio implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	//@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idTombamento;
	
	private String nomeClasse;
	private Long idTombamentoAnterior;
	private String nomeMarca;
	private String observacao;
	private String nomeEspecie;
	private Date dataLocacao;
	private Boolean estadoConsevacao;
	private Double valorAquisicao;
	private Double valorAnual;
	//colocar muitos patrimonios para um local
	//@Transient//impede que o JPA tente interpretar o set
	//@JsonIgnore
	@ManyToOne
	/*@JoinTable(name = "patrimonio_local", 
	joinColumns = @JoinColumn(name = "patrimonio_id"),
	inverseJoinColumns = @JoinColumn(name = "local_id"))*/
	//private Set<Local> locais = new HashSet<>();
	@JoinColumn(name = "local_id")
	private Local local;
	
	private Integer cadastroStatus;
	
	@ManyToOne
	@JoinColumn(name = "usuario_id")
	private Usuario usuario;
	
	public Patrimonio() {
		
	}

	public Patrimonio(Long idTombamento, Long idTombamentoAnterior, String nomeClasse, String nomeMarca,
			String observacao, String nomeEspecie, Date dataLocacao, Boolean estadoConsevacao, Double valorAquisicao,
			Double valorAnual,CadastroStatus cadastroStatus, Usuario usuario) {
		super();
		this.idTombamento = idTombamento;
		this.idTombamentoAnterior = idTombamentoAnterior;
		this.nomeClasse = nomeClasse;
		this.nomeMarca = nomeMarca;
		this.observacao = observacao;
		this.nomeEspecie = nomeEspecie;
		this.dataLocacao = dataLocacao;
		this.estadoConsevacao = estadoConsevacao;
		this.valorAquisicao = valorAquisicao;
		this.valorAnual = valorAnual;
		setCadastroStatus(cadastroStatus);
		this.usuario = usuario;
	}

	public Long getIdTombamento() {
		return idTombamento;
	}

	public void setIdTombamento(Long idTombamento) {
		this.idTombamento = idTombamento;
	}

	public Long getIdTombamentoAnterior() {
		return idTombamentoAnterior;
	}

	public void setIdTombamentoAnterior(Long idTombamentoAnterior) {
		this.idTombamentoAnterior = idTombamentoAnterior;
	}

	public String getNomeClasse() {
		return nomeClasse;
	}

	public void setNomeClasse(String nomeClasse) {
		this.nomeClasse = nomeClasse;
	}

	public String getNomeMarca() {
		return nomeMarca;
	}

	public void setNomeMarca(String nomeMarca) {
		this.nomeMarca = nomeMarca;
	}

	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

	public String getNomeEspecie() {
		return nomeEspecie;
	}

	public void setNomeEspecie(String nomeEspecie) {
		this.nomeEspecie = nomeEspecie;
	}

	public Date getDataLocacao() {
		return dataLocacao;
	}

	public void setDataLocacao(Date dataLocacao) {
		this.dataLocacao = dataLocacao;
	}

	public Boolean getEstadoConsevacao() {
		return estadoConsevacao;
	}

	public void setEstadoConsevacao(Boolean estadoConsevacao) {
		this.estadoConsevacao = estadoConsevacao;
	}

	public Double getValorAquisicao() {
		return valorAquisicao;
	}

	public void setValorAquisicao(Double valorAquisicao) {
		this.valorAquisicao = valorAquisicao;
	}

	public Double getValorAnual() {
		return valorAnual;
	}

	public void setValorAnual(Double valorAnual) {
		this.valorAnual = valorAnual;
	}

	
	
	public CadastroStatus getCadastroStatus() {
		return CadastroStatus.valueOf(cadastroStatus);
	}

	public void setCadastroStatus(CadastroStatus cadastroStatus) {
		if(cadastroStatus != null) {
			this.cadastroStatus = cadastroStatus.getCode();
		}
	}

	public Local getLocais() {
		return local;
	}

	public void setLocais(Local locais) {
		this.local = locais;
	}
	
	
	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idTombamento == null) ? 0 : idTombamento.hashCode());
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
		Patrimonio other = (Patrimonio) obj;
		if (idTombamento == null) {
			if (other.idTombamento != null)
				return false;
		} else if (!idTombamento.equals(other.idTombamento))
			return false;
		return true;
	}

	
	
	
	
	
}
