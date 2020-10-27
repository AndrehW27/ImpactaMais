package com.zeroseis.impactamais.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.zeroseis.impactamais.model.Hospital;

@Repository
public interface HospitalRepository extends JpaRepository<Hospital, Long>{
	
	public List<Hospital> findByNomeContainingIgnoreCase(String nome);
	
	public Optional<Hospital> findAllByCidadeContainingIgnoreCase(String cidade);
	
}