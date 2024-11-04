package com.ngo.tomada_inteligente.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ngo.tomada_inteligente.model.Tomada;

public interface TomadaRepository extends JpaRepository<Tomada, Integer> {
	
	Tomada findById(int id);

}
