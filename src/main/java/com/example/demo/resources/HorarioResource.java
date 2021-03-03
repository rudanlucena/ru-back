package com.example.demo.resources;

import com.example.demo.domain.Horario;
import com.example.demo.domain.Periodo;
import com.example.demo.services.HorarioService;
import com.example.demo.services.PeriodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value="/horarios")
public class HorarioResource {
    @Autowired
    private HorarioService service;

    @GetMapping()
    @CrossOrigin
    public ResponseEntity<Horario> findPeriodo(){
        List<Horario> horarios = service.findAll();
        Horario p = horarios.get(0);
        return ResponseEntity.ok().body(p);
    }

    @PostMapping
    @CrossOrigin
    public ResponseEntity<Void> save(@RequestBody Horario horario){
        horario.setId(1);
        horario = service.save(horario);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(horario.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }
}
