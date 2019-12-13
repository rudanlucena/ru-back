package com.example.demo.services;

import com.example.demo.domain.Nutricionista;
import com.example.demo.repository.NutricionistaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NutricionistaService {

	@Autowired
	private NutricionistaRepository repository;

	public Optional<Nutricionista> findById(Long id){
		return repository.findById(id);
	}

	public List<Nutricionista> findAll(){
		return repository.findAll();
	}

	public Optional<Nutricionista> findByLoginAndSenha(String login, String senha){
		return repository.findByLoginAndSenha(login, senha);
	}

	public Nutricionista save(Nutricionista nutricionista) {
		return repository.save(nutricionista);
	}

	public void delete(Long id) {
		repository.deleteById(id);
	}
}
