package com.example.demo.repository;

import com.example.demo.domain.Aluno;
import com.example.demo.domain.Auxilio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface AuxilioRepository extends JpaRepository<Auxilio, Long> {

}
