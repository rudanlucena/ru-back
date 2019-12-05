package com.example.demo.repository;

import com.example.demo.domain.Auxilio;
import com.example.demo.domain.Periodo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface PeriodoRepository extends JpaRepository<Periodo, Long> {
    
}
