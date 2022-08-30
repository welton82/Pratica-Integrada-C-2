package com.praticaintegrada.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.praticaintegrada.exception.ResourceNotFoundException;
import com.praticaintegrada.entities.Local;
import com.praticaintegrada.repositories.LocalRepository;

@Service
public class LocalService {
	
	@Autowired
	private LocalRepository repository;
	
	//LISTA AUTOMOTICAMENTE
	public List<Local>findAll(){
		return repository.findAll();
	}
	//BUSCA POR ID
	public Local findById(Long id) {
		Optional<Local> obj = repository.findById(id);
		return obj.get();
	}
	
	
	
	//INSERIR LOCAL
		
		public Local inserirLocal(@RequestBody Local local) {
			return repository.save(local);
			
		}
		
	//ALTERAR LOCAL
		
		public ResponseEntity<Local>alterarLocal(@PathVariable Long id, @RequestBody Local local){
			Local loc = repository.findById(id).orElseThrow( () -> new ResourceNotFoundException("Local Não Existe: " + id));
			
			loc.setId(local.getId());
			loc.setNome(local.getNome());
			loc.setReferenciaUnidade(local.getReferenciaUnidade());
			
			Local atualizado = repository.save(loc);
			return ResponseEntity.ok(atualizado);
		}
}
