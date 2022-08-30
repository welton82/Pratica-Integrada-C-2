package com.praticaintegrada.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.praticaintegrada.entities.Patrimonio;
import com.praticaintegrada.exception.ResourceNotFoundException;
import com.praticaintegrada.repositories.PatrimonioRepository;

@Service
public class PatrimonioService {
	
	@Autowired
	private PatrimonioRepository repository;
	
	public List<Patrimonio>findAll(){
		return repository.findAll();
	}
	
	public Patrimonio findById(Long id) {
		Optional<Patrimonio> obj = repository.findById(id);
		return obj.get();
	}
	
	//SALVAR
	public ResponseEntity<Patrimonio> save(@RequestBody Patrimonio patrimonio) {
		repository.save(patrimonio);
		return ResponseEntity.ok().body(patrimonio);
	}
	public void alterar(@PathVariable Long idTombamento, @RequestBody Patrimonio patrimonio){
		
		Patrimonio pat = repository.findById(idTombamento).orElseThrow(
					() -> new ResourceNotFoundException("Patrimônio inexistente! id: " + idTombamento)
				);
		
		pat.setIdTombamento(patrimonio.getIdTombamento());
		pat.setIdTombamentoAnterior(patrimonio.getIdTombamentoAnterior());
		pat.setNomeClasse(patrimonio.getNomeClasse());
		pat.setNomeMarca(patrimonio.getNomeMarca());
		pat.setObservacao(patrimonio.getObservacao());
		pat.setNomeEspecie(patrimonio.getNomeEspecie());
		pat.setDataLocacao(patrimonio.getDataLocacao());
		pat.setEstadoConsevacao(patrimonio.getEstadoConsevacao());
		pat.setValorAquisicao(patrimonio.getValorAquisicao());
		pat.setValorAnual(patrimonio.getValorAnual());
		try {
			repository.save(pat);
		}catch(Exception e) {
			System.out.println("DEU ERRO PARA SALVAR\n\n\n" + e.getMessage());
		}
		
	}
}
