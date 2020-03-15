package com.example.demo.services;

import com.example.demo.domain.Periodo;
import com.example.demo.domain.RegistroDiario;
import com.example.demo.repository.RegistroDiarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RegistroDiarioService {
    @Autowired
    private RegistroDiarioRepository repository;

    public List<RegistroDiario> findAll(){
        return repository.findAll();
    }

    public RegistroDiario save(RegistroDiario registro) {
        return repository.save(registro);
    }
}
