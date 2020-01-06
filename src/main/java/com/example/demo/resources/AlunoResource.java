package com.example.demo.resources;

import java.net.URI;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.example.demo.domain.Auxilio;
import com.example.demo.domain.Periodo;
import com.example.demo.services.AuxilioService;
import com.example.demo.services.PeriodoService;
import org.apache.tomcat.jni.Local;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.example.demo.domain.Aluno;
import com.example.demo.services.AlunoService;

@RestController
@RequestMapping(value="/alunos")
public class AlunoResource {
	
	@Autowired
	private AlunoService service;

    @Autowired
    private PeriodoService periodoService;

    @Autowired
    private AuxilioService auxilioService;
	
	@GetMapping
	@CrossOrigin
	public ResponseEntity<List<Aluno>> findAll(){
		List<Aluno> alunos = service.findAll();
		return ResponseEntity.ok().body(alunos);
	}

	@GetMapping("/{matricula}")
	@CrossOrigin
	public ResponseEntity<Optional<Aluno>> findByMatricula(@PathVariable("matricula") String matricula){
		Optional<Aluno> aluno = service.findByMatricula(matricula);
		return ResponseEntity.ok().body(aluno);
	}

    @PostMapping("/{matricula}/auxilio")
    @CrossOrigin
    public ResponseEntity<Optional<Aluno>> adicionarAuxilio(@PathVariable("matricula") String matricula, @RequestBody Auxilio auxilio){
	    //recuperar aluno
        Optional<Periodo> p = periodoService.findById(1L);
        auxilio.setPeriodo(p.get());
        //ssetar periodo padrão


        Optional<Aluno> aluno = service.findByMatricula(matricula);
        if(aluno.get().getAuxilio()!=null){
        	aluno.get().getAuxilio().setAlmoco(auxilio.isAlmoco());
			aluno.get().getAuxilio().setJantar(auxilio.isJantar());
		}
        else{
			auxilio = auxilioService.save(auxilio);
			aluno.get().setAuxilio(auxilio);
		}

        service.save(aluno.get());
        return ResponseEntity.ok().body(aluno);
    }

    @GetMapping("/{matricula}/{senha}")
    @CrossOrigin
    public ResponseEntity<Optional<Aluno>> findByLogin(@PathVariable("matricula") String matricula, @PathVariable("senha") String senha){
        Optional<Aluno> aluno = service.findByLogin(matricula, senha);
        return ResponseEntity.ok().body(aluno);
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
	
	/*@PostMapping
	@CrossOrigin
	public ResponseEntity<Void> save(@RequestBody Aluno aluno){
		aluno = service.save(aluno);

		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(aluno.getMatricula()).toUri();
		return ResponseEntity.created(uri).build();
	}*/

	@PostMapping
	@CrossOrigin
	public ResponseEntity<List<Aluno>> saveAll(@RequestBody List<Aluno> alunos){
		alunos = service.saveAll(alunos);
		return ResponseEntity.ok(alunos);

		//URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(aluno.getMatricula()).toUri();
		//return ResponseEntity.created(null).build();
	}

	@DeleteMapping("/{matricula}")
	@CrossOrigin
	public ResponseEntity<Void> delete(@PathVariable("matricula") String matricula) {
		service.delete(matricula);
		return ResponseEntity.noContent().build();
	}
}
