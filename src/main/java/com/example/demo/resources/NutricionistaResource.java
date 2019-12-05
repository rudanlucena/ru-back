package com.example.demo.resources;

import com.example.demo.domain.Nutricionista;
import com.example.demo.services.NutricionistaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.Optional;

@RestController
@RequestMapping(value="/nutricionistas")
public class NutricionistaResource {
	
	@Autowired
	private NutricionistaService service;
	


	/*@GetMapping("/{matricula}")
	@CrossOrigin
	public ResponseEntity<Optional<Aluno>> findByMatricula(@PathVariable("matricula") String matricula){
		Optional<Aluno> aluno = service.findByMatricula(matricula);
		return ResponseEntity.ok().body(aluno);
	}*/

    @GetMapping("/{login}/{senha}")
    @CrossOrigin
    public ResponseEntity<Optional<Nutricionista>> findByLogin(@PathVariable("login") String login, @PathVariable("senha") String senha){
        Optional<Nutricionista> assistenteSocial = service.findByLoginAndSenha(login, senha);
        return ResponseEntity.ok().body(assistenteSocial);
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