package com.example.demo.services;

import com.example.demo.domain.Auxilio;
import com.example.demo.domain.ChefeCozinha;
import com.example.demo.repository.AuxilioRepository;
import com.example.demo.repository.ChefeCozinhaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ChefeCozinhaService {

	@Autowired
	private ChefeCozinhaRepository repository;

	public Optional<ChefeCozinha> findById(Long id){
		return repository.findById(id);
	}

	public Optional<ChefeCozinha> findByLoginAndSenha(String login, String senha){
		return repository.findByLoginAndSenha(login, senha);
	}

	public ChefeCozinha save(ChefeCozinha chefeCozinha) {
		return repository.save(chefeCozinha);
	}

	public void delete(Long id) {
		repository.deleteById(id);
	}
}
