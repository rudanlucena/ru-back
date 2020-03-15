package com.example.demo.services;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.domain.Aluno;
import com.example.demo.repository.AlunoRepository;

@Service
public class AlunoService {
	@Autowired
	private AlunoRepository repository;

	public List<Aluno> findAll(){
		return repository.findAll();
	}

	public List<Aluno> findBolsistas(){

		return repository.findAlunosByAuxilioNotNull();
	}

	public Optional<Aluno> findByMatricula(String matricula){
		return repository.findByMatricula(matricula);
	}

    public Optional<Aluno> findByLogin(String matricula, String senha){
        return repository.findByMatriculaAndSenha(matricula, senha);
    }

	public Aluno save(Aluno aluno) {
		return repository.save(aluno);
	}

	public List<Aluno> saveAll(List<Aluno> alunos) {
		return repository.saveAll(alunos);
	}
	
	public void delete(String matricula) {
		repository.deleteById(matricula);
	}
}
