package com.example.demo.repository;

import com.example.demo.domain.Cancelamento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CancelamentoRepository extends JpaRepository<Cancelamento, Long> {
    Optional<Cancelamento> findByAluno_Uuid(String string);
}
