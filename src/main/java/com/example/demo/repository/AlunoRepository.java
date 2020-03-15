package com.example.demo.repository;

import com.example.demo.domain.Auxilio;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.domain.Aluno;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public interface AlunoRepository extends JpaRepository<Aluno, String> {
    Optional<Aluno> findByMatricula(String matricula);
    List<Aluno> findAlunosByAuxilioNotNull();
    Optional<Aluno> findByMatriculaAndSenha(String matricula, String senha);
}
