package com.example.demo.services;

import com.example.demo.domain.AuxilioTemporario;
import com.example.demo.domain.Cancelamento;
import com.example.demo.repository.AuxilioTemporarioRepository;
import com.example.demo.repository.CancelamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CancelamentoService {

    @Autowired
    private CancelamentoRepository repository;

    public Optional<Cancelamento> findByIdAluno(String uuid){
        return repository.findByAluno_Uuid(uuid);
    }
//
//    public List<AuxilioTemporario> findAll(){
//        return repository.findAll();
//    }

//    public List<AuxilioTemporario> findStatus(String status){
//        return repository.findByStatus(status);
//    }

    public Cancelamento save(Cancelamento cancelamento) {
        return repository.save(cancelamento);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}
