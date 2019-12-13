package com.example.demo.services;

import com.example.demo.domain.AssistenteSocial;
import com.example.demo.repository.AssistenteSocialRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AssistenteSocialService {

	@Autowired
	private AssistenteSocialRepository repository;

	public List<AssistenteSocial> findAll(){
		return repository.findAll();
	}

	public Optional<AssistenteSocial> findById(Long id){
		return repository.findById(id);
	}

	public Optional<AssistenteSocial> findByLoginAndSenha(String login, String senha){
		return repository.findByLoginAndSenha(login, senha);
	}

	public AssistenteSocial save(AssistenteSocial assistenteSocial) {
		return repository.save(assistenteSocial);
	}

	public void delete(Long id) {
		repository.deleteById(id);
	}
}
