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

import com.praticaintegrada.entities.Patrimonio;
import com.praticaintegrada.exception.ResourceNotFoundException;
import com.praticaintegrada.services.PatrimonioService;

@RestController
@RequestMapping(value = "/patrimonios")
public class PatrimonioResource {
	
	@Autowired
	private PatrimonioService service;
	
	@GetMapping
	public ResponseEntity<List<Patrimonio>> findAll(){
		List<Patrimonio> list = service.findAll();
		
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Patrimonio> findById(@PathVariable Long id){
		Patrimonio obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
	
	@PostMapping("/inserir")
	public  ResponseEntity<Patrimonio> save(@RequestBody Patrimonio patrimonio) {
		service.save(patrimonio);
		return ResponseEntity.ok().body(patrimonio);
	}
	@PutMapping("/alterar/{id}")
	public ResponseEntity<Patrimonio> alterar(@PathVariable Long id, @RequestBody Patrimonio patrimonio){
		service.alterar(id, patrimonio);
		return ResponseEntity.ok().body(patrimonio);
	}
}
