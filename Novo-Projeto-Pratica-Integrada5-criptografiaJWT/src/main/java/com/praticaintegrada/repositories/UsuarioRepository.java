package com.praticaintegrada.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.praticaintegrada.entities.Usuario;

//NÃO HÁ NECESSIDADE DE COLOCAR O REPOSITORY POIS JPA ESTA REGISTRADO COMO 
//COMPONENT DO SPRING
@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long>{
	public Optional<Usuario> findByLogin(String login);
}
