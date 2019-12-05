package com.example.demo.resources;

import com.example.demo.domain.Auxilio;
import com.example.demo.domain.ChefeCozinha;
import com.example.demo.services.AuxilioService;
import com.example.demo.services.ChefeCozinhaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.Optional;

@RestController
@RequestMapping(value="/cozinheiras")
public class ChefeCozinhaResource {
	
	@Autowired
	private ChefeCozinhaService service;
	


	/*@GetMapping("/{matricula}")
	@CrossOrigin
	public ResponseEntity<Optional<Aluno>> findByMatricula(@PathVariable("matricula") String matricula){
		Optional<Aluno> aluno = service.findByMatricula(matricula);
		return ResponseEntity.ok().body(aluno);
	}*/

    @GetMapping("/{login}/{senha}")
    @CrossOrigin
    public ResponseEntity<Optional<ChefeCozinha>> findByLogin(@PathVariable("login") String login, @PathVariable("senha") String senha){
        Optional<ChefeCozinha> chefeCozinha = service.findByLoginAndSenha(login, senha);
        return ResponseEntity.ok().body(chefeCozinha);
    }

	/*@GetMapping("/comensais")
	@CrossOrigin
	public ResponseEntity<List<Aluno>> findByIntervalo(){
		List<Aluno> alunos = service.findAll();

		List<Aluno> comensais = new ArrayList<>();
		LocalDate hoje = LocalDate.now();

		for(Aluno aluno: alunos){
			if((aluno.getInicio().isAfter(hoje) || aluno.getInicio().isEqual(hoje)) && (aluno.getVencimento().isBefore(hoje) || aluno.getVencimento().isEqual(hoje) )){
				comensais.add(aluno);
			}
		}

		return ResponseEntity.ok().body(comensais);
	}*/
	
	@PostMapping
	@CrossOrigin
	public ResponseEntity<Void> save(@RequestBody ChefeCozinha chefeCozinha){
		chefeCozinha = service.save(chefeCozinha);

		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(chefeCozinha.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}


	@DeleteMapping("/{id}")
	@CrossOrigin
	public ResponseEntity<Void> delete(@PathVariable("id") long id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
}
