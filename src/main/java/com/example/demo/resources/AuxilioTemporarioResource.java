package com.example.demo.resources;

import com.example.demo.domain.AssistenteSocial;
import com.example.demo.domain.Auxilio;
import com.example.demo.domain.AuxilioTemporario;
import com.example.demo.services.AlunoService;
import com.example.demo.services.AuxilioService;
import com.example.demo.services.AuxilioTemporarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value="/auxiliosTemporarios")
public class AuxilioTemporarioResource {
	
	@Autowired
	private AuxilioTemporarioService service;

	@Autowired
	private AlunoService alunoService;



	@GetMapping("/{id}")
	@CrossOrigin
	public ResponseEntity<Optional<AuxilioTemporario>> findById(@PathVariable("id") long id){
		Optional<AuxilioTemporario> auxilioTemporario = service.findById(id);
		return ResponseEntity.ok().body(auxilioTemporario);
	}

	@GetMapping("/aluno/{id}")
	@CrossOrigin
	public ResponseEntity<List<AuxilioTemporario>> findByAluno(@PathVariable("id") long id){
		List<AuxilioTemporario> auxilioTemporario = service.findByAluno_id(id);
		return ResponseEntity.ok().body(auxilioTemporario);
	}


	@GetMapping
	@CrossOrigin
	public ResponseEntity<List<AuxilioTemporario>> findAll(){
		List<AuxilioTemporario> auxiliosTemporarios = service.findAll();
		return ResponseEntity.ok().body(auxiliosTemporarios);
	}

	@GetMapping("/status/{status}")
	@CrossOrigin
	public ResponseEntity<List<AuxilioTemporario>> findPendentes(@PathVariable("status") String status){
		List<AuxilioTemporario> auxiliosTemporarios = service.findStatus(status);
		return ResponseEntity.ok().body(auxiliosTemporarios);
	}
	
	@PostMapping
	@CrossOrigin
	public ResponseEntity<Void> save(@RequestBody AuxilioTemporario auxilio){
		auxilio = service.save(auxilio);

		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(auxilio.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}


	@DeleteMapping("/{id}")
	@CrossOrigin
	public ResponseEntity<Void> delete(@PathVariable("id") Long id) {
		Optional<AuxilioTemporario> aux = service.findById(id);
		if(aux.isPresent()){
			aux.get().setStatus("indeferido");
		}
		//service.delete(id);
		return ResponseEntity.noContent().build();
	}
}
