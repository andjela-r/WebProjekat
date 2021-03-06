package com.example.demo.repository;

import com.example.demo.entity.Menadzer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MenadzerRepository extends JpaRepository<Menadzer, Long>{


    boolean existsByKorisnickoIme(String username);
    Menadzer getById(Long id);

}
