package com.example.demo.repository;

import com.example.demo.domain.Almoco;
import com.example.demo.domain.AssistenteSocial;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AlmocoRepository extends JpaRepository<Almoco, Long> {

}
