package com.example.demo.repository;

import com.example.demo.domain.Horario;
import com.example.demo.domain.Jantar;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HorarioRepository extends JpaRepository<Horario, Long> {
}
