package com.example.demo.repository;

import com.example.demo.domain.Jantar;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JantarRepository extends JpaRepository<Jantar, Long> {
}
