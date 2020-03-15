package com.example.demo.services;

import com.example.demo.domain.Auxilio;
import com.example.demo.domain.AuxilioTemporario;
import com.example.demo.repository.AuxilioRepository;
import com.example.demo.repository.AuxilioTemporarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AuxilioTemporarioService {

	@Autowired
	private AuxilioTemporarioRepository repository;

	public Optional<AuxilioTemporario> findById(Long id){
		return repository.findById(id);
	}

	public Optional<AuxilioTemporario> findByUuid(String Uuid){
		return repository.findByAluno_Uuid(Uuid);
	}



	public List<AuxilioTemporario> findAll(){
		return repository.findAll();
	}

	public List<AuxilioTemporario> findStatus(String status){
		return repository.findByStatus(status);
	}

	public AuxilioTemporario save(AuxilioTemporario auxilio) {
		return repository.save(auxilio);
	}

	public void delete(Long id) {
		repository.deleteById(id);
	}
}
