package com.example.demo.services;

import com.example.demo.domain.Aluno;
import com.example.demo.domain.Auxilio;
import com.example.demo.domain.Periodo;
import com.example.demo.repository.AlunoRepository;
import com.example.demo.repository.AuxilioRepository;
import com.example.demo.repository.PeriodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AuxilioService {

	@Autowired
	private AuxilioRepository repository;

	public Optional<Auxilio> findById(Long id){
		return repository.findById(id);
	}

	public Auxilio save(Auxilio auxilio) {
		return repository.save(auxilio);
	}

	public void delete(Long id) {
		repository.deleteById(id);
	}
}
