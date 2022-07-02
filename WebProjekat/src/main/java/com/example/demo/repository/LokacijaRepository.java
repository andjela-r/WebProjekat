package com.example.demo.repository;

import com.example.demo.entity.Lokacija;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface LokacijaRepository extends JpaRepository<Lokacija, Long>{

    Optional<Lokacija> findById(Long aLong);
}
