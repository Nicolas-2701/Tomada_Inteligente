package com.ngo.tomada_inteligente.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ngo.tomada_inteligente.model.Tomada;

@Repository
public interface TomadaRepository extends JpaRepository<Tomada, Integer> {
	
	Tomada findById(int id);

}
