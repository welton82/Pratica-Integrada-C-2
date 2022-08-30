																																																																																																																			package com.praticaintegrada.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.praticaintegrada.exception.ResourceNotFoundException;
import com.praticaintegrada.entities.Usuario;
import com.praticaintegrada.services.UsuarioService;

@RestController
@RequestMapping(value = "/usuarios")
public class UsuarioResource {
	
	@Autowired
	private UsuarioService service;
	
	private final PasswordEncoder encoder;
	
	public UsuarioResource(UsuarioService usuarioRep, PasswordEncoder encoder) {
		super();
		this.service = usuarioRep;
		this.encoder = encoder;
	}
	
	
	@GetMapping
	public ResponseEntity<List<Usuario>> findAll(){
		List<Usuario> list = service.findAll();
		
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Usuario> findById(@PathVariable Long id){
		Usuario obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
	
	
	//VALIDAR SENHA
	@GetMapping("/validarSenha")
	public ResponseEntity<Boolean> validarSenha(@RequestParam String login,
			@RequestParam String senha){
		ResponseEntity<Boolean> obj = service.validarSenha(login, senha);
		return obj;
	}
	
	//INSERIR
	@PostMapping("/inserir")
	public ResponseEntity<Usuario> inserir(@RequestBody Usuario usuario){
		service.inserir(usuario);
		return ResponseEntity.ok().body(usuario);
	}
	
	
	
	
}
