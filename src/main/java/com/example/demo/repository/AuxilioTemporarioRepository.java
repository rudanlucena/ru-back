package com.example.demo.repository;

import com.example.demo.domain.Aluno;
import com.example.demo.domain.AuxilioTemporario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public interface AuxilioTemporarioRepository extends JpaRepository<AuxilioTemporario, Long> {
    //Optional<Aluno> findByMatricula(String matricula);
    List<AuxilioTemporario> findByStatus(String status);
    Optional<AuxilioTemporario> findByAluno_Uuid(String id);

    List<AuxilioTemporario> findByAluno_Id(long id);
    //Optional<Aluno> findByMatriculaAndSenha(String matricula, String senha);
}
