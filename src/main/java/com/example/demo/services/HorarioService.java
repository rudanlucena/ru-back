package com.example.demo.services;

import com.example.demo.domain.Auxilio;
import com.example.demo.domain.Horario;
import com.example.demo.domain.Periodo;
import com.example.demo.repository.AuxilioRepository;
import com.example.demo.repository.HorarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HorarioService {

    @Autowired
    private HorarioRepository repository;

    public Optional<Horario> findById(Long id){
        return repository.findById(id);
    }

    public List<Horario> findAll(){
        return repository.findAll();
    }

    public Horario save(Horario horario) {
        return repository.save(horario);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}
