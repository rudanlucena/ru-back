package com.example.demo.resources;

import java.net.URI;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import com.example.demo.domain.*;
import com.example.demo.services.*;
import org.apache.tomcat.jni.Local;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
@RequestMapping(value="/alunos")
public class AlunoResource {
	
	@Autowired
	private AlunoService service;

    @Autowired
    private PeriodoService periodoService;

    @Autowired
    private AuxilioService auxilioService;

	@Autowired
	private AuxilioTemporarioService auxilioTemporarioService;

	@Autowired
	private RegistroDiarioService registroDiarioService;
	
	@GetMapping
	@CrossOrigin
	public ResponseEntity<List<Aluno>> findAll(){
		List<Aluno> alunos = service.findAll();
		return ResponseEntity.ok().body(alunos);
	}

	@GetMapping("/bolsistas")
	@CrossOrigin
	public ResponseEntity<List<Aluno>> findBolsistas(){
		List<Aluno> alunos = service.findBolsistas();
		return ResponseEntity.ok().body(alunos);
	}

	@GetMapping("/{matricula}")
	@CrossOrigin
	public ResponseEntity<Optional<Aluno>> findByMatricula(@PathVariable("matricula") String matricula){

		LocalTime inicioAlmoco = LocalTime.of(8, 00);
		LocalTime iniciojantar = LocalTime.of(17, 00);
		LocalTime horaAtual = LocalTime.now();
		LocalDate dataAtual = LocalDate.now();

		RegistroDiario rd = new RegistroDiario();
		rd.setDataRegistro(dataAtual);

		Optional<Aluno> aluno = service.findByMatricula(matricula);
		//auxilioPermanente
		if(aluno.get()!=null ){
			if(aluno.get().getAuxilio()!=null) {
				//almoço
				if (horaAtual.isAfter(inicioAlmoco) && horaAtual.isBefore(iniciojantar)) {
					if (aluno.get().getAuxilio().isAlmoco()) {
						rd.setRefeicao("almoço");
						rd.setAluno(aluno.get());
						registroDiarioService.save(rd);
						return ResponseEntity.ok().body(aluno);
					}

					return ResponseEntity.notFound().build();
				}
				//jantar
				else if (horaAtual.isAfter(iniciojantar)) {
					if (aluno.get().getAuxilio().isJantar()) {
						rd.setRefeicao("jantar");
						rd.setAluno(aluno.get());
						registroDiarioService.save(rd);
						return ResponseEntity.ok().body(aluno);
					}
					return ResponseEntity.notFound().build();
				}
			}
		}

		Optional<AuxilioTemporario> auxTemp = auxilioTemporarioService.findByUuid(aluno.get().getUuid());
		if(auxTemp.get()!=null){
			if(auxTemp.get().getFim().isAfter(dataAtual)){
				if(horaAtual.isAfter(inicioAlmoco) && horaAtual.isBefore(iniciojantar)){
					if(auxTemp.get().isAlmoco()){
						rd.setRefeicao("almoço");
						rd.setAluno(aluno.get());
						registroDiarioService.save(rd);
						return ResponseEntity.ok().body(aluno);
					}

					return ResponseEntity.notFound().build();
				}
				else if(horaAtual.isAfter(iniciojantar)){
					if(auxTemp.get().isJantar()) {
						rd.setRefeicao("jantar");
						rd.setAluno(aluno.get());
						registroDiarioService.save(rd);
						return ResponseEntity.ok().body(aluno);
					}
					return ResponseEntity.notFound().build();
				}
			}
		}

		return ResponseEntity.notFound().build();
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

        if(!auxilio.isAlmoco() && !auxilio.isJantar()){
        	aluno.get().setAuxilio(null);
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

	@PutMapping
	@CrossOrigin
	public ResponseEntity<Aluno> atualizar(@RequestBody Aluno aluno){
		aluno = service.save(aluno);
		return ResponseEntity.ok(aluno);

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
