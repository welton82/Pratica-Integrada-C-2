package com.praticaintegrada.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.praticaintegrada.entities.Inventario;
import com.praticaintegrada.repositories.InventarioRepository;

@Service
public class InventarioService {
	
	@Autowired
	private InventarioRepository repository;
	
	public List<Inventario>findAll(){
		return repository.findAll();
	}
	
	public Inventario findById(Long id) {
		Optional<Inventario> obj = repository.findById(id);
		return obj.get();
	}
}
