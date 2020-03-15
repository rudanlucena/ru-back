package com.example.demo.resources;

import com.example.demo.domain.Aluno;
import com.example.demo.domain.Auxilio;
import com.example.demo.domain.Cancelamento;
import com.example.demo.services.AuxilioService;
import com.example.demo.services.CancelamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.Optional;

@RestController
@RequestMapping(value="/cancelamentos")
public class CancelamentoResource {

    @Autowired
    private CancelamentoService service;

    @PostMapping
    @CrossOrigin
    public ResponseEntity<Void> save(@RequestBody Cancelamento cancelamento){
        cancelamento = service.save(cancelamento);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(cancelamento.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @GetMapping("/{matricula}")
    @CrossOrigin
    public ResponseEntity<Optional<Cancelamento>> findByAluno(@PathVariable("uuid") String uuid){
        Optional<Cancelamento> cancelamento = service.findByIdAluno(uuid);
        return ResponseEntity.ok().body(cancelamento);
    }

	@DeleteMapping("/{id}")
	@CrossOrigin
	public ResponseEntity<Void> delete(@PathVariable("id") long id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
}
