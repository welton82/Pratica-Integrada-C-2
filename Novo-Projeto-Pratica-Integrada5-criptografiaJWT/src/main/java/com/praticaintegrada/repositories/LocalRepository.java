package com.praticaintegrada.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.praticaintegrada.entities.Local;

//NÃO HÁ NECESSIDADE DE COLOCAR O REPOSITORY POIS JPA ESTA REGISTRADO COMO 
//COMPONENT DO SPRING
@Repository
public interface LocalRepository extends JpaRepository<Local, Long>{
	
}
