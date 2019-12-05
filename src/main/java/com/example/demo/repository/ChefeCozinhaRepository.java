package com.example.demo.repository;

import com.example.demo.domain.Aluno;
import com.example.demo.domain.ChefeCozinha;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface ChefeCozinhaRepository extends JpaRepository<ChefeCozinha, Long> {
    Optional<ChefeCozinha> findByLoginAndSenha(String login, String senha);
}
