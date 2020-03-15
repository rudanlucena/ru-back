package com.example.demo.repository;

import com.example.demo.domain.Periodo;
import com.example.demo.domain.RegistroDiario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RegistroDiarioRepository extends JpaRepository<RegistroDiario, Long> {
}
