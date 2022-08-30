package com.praticaintegrada.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.praticaintegrada.entities.Inventario;
import com.praticaintegrada.services.InventarioService;

@RestController
@RequestMapping(value = "/inventarios")
public class InventarioResource {
	
	@Autowired
	private InventarioService service;
	
	@GetMapping
	public ResponseEntity<List<Inventario>> findAll(){
		List<Inventario> list = service.findAll();
		
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Inventario> findById(@PathVariable Long id){
		Inventario obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
}
