package com.example.demo.services;

import com.example.demo.domain.Aluno;
import com.example.demo.domain.Periodo;
import com.example.demo.repository.AlunoRepository;
import com.example.demo.repository.PeriodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PeriodoService {
	@Autowired
	private PeriodoRepository repository;

	public Optional<Periodo> findById(Long id){
		return repository.findById(id);
	}

	public Periodo save(Periodo periodo) {
		return repository.save(periodo);
	}
	
	public void delete(Long id) {
		repository.deleteById(id);
	}
}
