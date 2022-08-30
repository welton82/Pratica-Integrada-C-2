package com.praticaintegrada.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.praticaintegrada.entities.Local;
import com.praticaintegrada.services.LocalService;

@RestController
@RequestMapping(value = "/locais")
public class LocalResource {
	
	@Autowired
	private LocalService service;
	
	//LISTA QUANDO CHAMA '/LOCAIS'
	@GetMapping
	public ResponseEntity<List<Local>> findAll(){
		List<Local> list = service.findAll();
		
		return ResponseEntity.ok().body(list);
	}
	
	//BUSCA POR ID
	@GetMapping(value = "/{id}")
	public ResponseEntity<Local> findById(@PathVariable Long id){
		Local obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
	
	//INSERIR
	@PostMapping("/inserir")
	public ResponseEntity<Local> inserirLocal(@RequestBody Local local) {
		service.inserirLocal(local);
		return ResponseEntity.ok().body(local);
	
	}
	
	//ALTERAR
	@PutMapping("/alterar/{id}")
	public ResponseEntity<Local> alterar(@PathVariable Long id, @RequestBody Local local){
		service.alterarLocal(id, local);
		return ResponseEntity.ok().body(local);
	}
	
}
