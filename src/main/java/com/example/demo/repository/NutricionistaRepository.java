package com.example.demo.repository;

import com.example.demo.domain.Nutricionista;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface NutricionistaRepository extends JpaRepository<Nutricionista, Long> {
    Optional<Nutricionista> findByLoginAndSenha(String login, String senha);
}
