package com.example.demo.repository;

import com.example.demo.entity.Artikli;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArtikliRepository extends JpaRepository<Artikli, Long>{
}
