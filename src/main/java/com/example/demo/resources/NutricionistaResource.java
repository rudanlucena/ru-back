package com.example.demo.resources;

import com.example.demo.domain.Aluno;
import com.example.demo.domain.AssistenteSocial;
import com.example.demo.domain.Nutricionista;
import com.example.demo.services.NutricionistaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value="/nutricionistas")
public class NutricionistaResource {
	
	@Autowired
	private NutricionistaService service;

	@GetMapping("/{id}")
	@CrossOrigin
	public ResponseEntity<Optional<Nutricionista>> findById(@PathVariable("id") long id){
		Optional<Nutricionista> nutricionista = service.findById(id);
		return ResponseEntity.ok().body(nutricionista);
	}

	@GetMapping
	@CrossOrigin
	public ResponseEntity<List<Nutricionista>> findAll(){
		List<Nutricionista> nutricionistas = service.findAll();
		return ResponseEntity.ok().body(nutricionistas);
	}


    @GetMapping("/{login}/{senha}")
    @CrossOrigin
    public ResponseEntity<Optional<Nutricionista>> findByLogin(@PathVariable("login") String login, @PathVariable("senha") String senha){
        Optional<Nutricionista> chefeCozinha = service.findByLoginAndSenha(login, senha);
        return ResponseEntity.ok().body(chefeCozinha);
    }


	@PostMapping
	@CrossOrigin
	public ResponseEntity<Void> save(@RequestBody Nutricionista nutricionista){
		nutricionista = service.save(nutricionista);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(nutricionista.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}


	@DeleteMapping("/{id}")
	@CrossOrigin
	public ResponseEntity<Void> delete(@PathVariable("id") long id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
}
