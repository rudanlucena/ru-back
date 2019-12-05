package com.example.demo.resources;

import com.example.demo.domain.Auxilio;
import com.example.demo.domain.Periodo;
import com.example.demo.services.AuxilioService;
import com.example.demo.services.PeriodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping(value="/auxilios")
public class AuxilioResource {
	
	@Autowired
	private AuxilioService service;
	


	/*@GetMapping("/{matricula}")
	@CrossOrigin
	public ResponseEntity<Optional<Aluno>> findByMatricula(@PathVariable("matricula") String matricula){
		Optional<Aluno> aluno = service.findByMatricula(matricula);
		return ResponseEntity.ok().body(aluno);
	}

    @GetMapping("/{matricula}/{senha}")
    @CrossOrigin
    public ResponseEntity<Optional<Aluno>> findByLogin(@PathVariable("matricula") String matricula, @PathVariable("senha") String senha){
        Optional<Aluno> aluno = service.findByLogin(matricula, senha);
        return ResponseEntity.ok().body(aluno);
    }*/

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
	public ResponseEntity<Void> save(@RequestBody Auxilio auxilio){
		auxilio = service.save(auxilio);

		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(auxilio.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}


	/*@DeleteMapping("/{matricula}")
	@CrossOrigin
	public ResponseEntity<Void> delete(@PathVariable("matricula") String matricula) {
		service.delete(matricula);
		return ResponseEntity.noContent().build();
	}*/
}
