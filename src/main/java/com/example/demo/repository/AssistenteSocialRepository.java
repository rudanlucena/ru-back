package com.example.demo.repository;

import com.example.demo.domain.AssistenteSocial;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface AssistenteSocialRepository extends JpaRepository<AssistenteSocial, Long> {
    Optional<AssistenteSocial> findByLoginAndSenha(String login, String senha);
}
