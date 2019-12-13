package com.example.demo.resources;

import com.example.demo.domain.Aluno;
import com.example.demo.domain.AssistenteSocial;
import com.example.demo.domain.Nutricionista;
import com.example.demo.services.AssistenteSocialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value="/assistentes")
public class AssistenteSocialResource {
	
	@Autowired
	private AssistenteSocialService service;

	@GetMapping("/{id}")
	@CrossOrigin
	public ResponseEntity<Optional<AssistenteSocial>> findById(@PathVariable("id") long id){
		Optional<AssistenteSocial> assistenteSocial = service.findById(id);
		return ResponseEntity.ok().body(assistenteSocial);
	}

	@GetMapping
	@CrossOrigin
	public ResponseEntity<List<AssistenteSocial>> findAll(){
		List<AssistenteSocial> assistentes = service.findAll();
		return ResponseEntity.ok().body(assistentes);
	}

    @GetMapping("/{login}/{senha}")
    @CrossOrigin
    public ResponseEntity<Optional<AssistenteSocial>> findByLogin(@PathVariable("login") String login, @PathVariable("senha") String senha){
        Optional<AssistenteSocial> assistenteSocial = service.findByLoginAndSenha(login, senha);
        return ResponseEntity.ok().body(assistenteSocial);
    }


	@PostMapping
	@CrossOrigin
	public ResponseEntity<Void> save(@RequestBody AssistenteSocial assistenteSocial){
		assistenteSocial = service.save(assistenteSocial);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(assistenteSocial.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}


	@DeleteMapping("/{id}")
	@CrossOrigin
	public ResponseEntity<Void> delete(@PathVariable("id") long id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
}
