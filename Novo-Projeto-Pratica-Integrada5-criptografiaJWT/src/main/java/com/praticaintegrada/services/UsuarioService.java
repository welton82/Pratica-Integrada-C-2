package com.praticaintegrada.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.praticaintegrada.exception.ResourceNotFoundException;
import com.praticaintegrada.entities.Usuario;
import com.praticaintegrada.repositories.UsuarioRepository;

@Service
public class UsuarioService {
	
	@Autowired
	private UsuarioRepository repository;
	
	private final PasswordEncoder encoder;
	
	
	public UsuarioService(UsuarioRepository usuarioRep, PasswordEncoder encoder) {
		super();
		this.repository = usuarioRep;
		this.encoder = encoder;
	}
	
	public List<Usuario>findAll(){
		return repository.findAll();
	}
	
	public Usuario findById(Long id) {
		Optional<Usuario> obj = repository.findById(id);
		return obj.get();
	}
	
	
	
	
	public ResponseEntity<Usuario> consultarUsuario(@PathVariable Long id){
		
		Usuario usuario = repository.findById(id).orElseThrow(
				() -> new ResourceNotFoundException("Usuário Não encontrado: " + id)
			);
		
		return ResponseEntity.ok(usuario);
	}
	
	
	//VALIDAR SENHA
		
		public ResponseEntity<Boolean>validarSenha(@RequestParam String login,
				@RequestParam String senha){
			
			
			Boolean valid = false;
			Optional<Usuario> usuario = repository.findByLogin(login);
			if(usuario.isEmpty()) {
				return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(valid);
			}
			
			Usuario usu = usuario.get();
			valid = encoder.matches(senha, usu.getSenha());
			
			HttpStatus status = (valid) ? HttpStatus.OK : HttpStatus.UNAUTHORIZED; 
			
			
			return ResponseEntity.status(status).body(valid);
		}
		
		
		//INSERIR USUARIO
		
		public ResponseEntity<Usuario> inserir(@RequestBody Usuario usuario) {
			
			usuario.setSenha(encoder.encode(usuario.getSenha()));
			repository.save(usuario);
			return ResponseEntity.ok().body(usuario);
		}
		
}
