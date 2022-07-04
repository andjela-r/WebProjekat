package com.example.demo.repository;

import com.example.demo.entity.Artikli;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public interface ArtikliRepository extends JpaRepository<Artikli, Long>{
   boolean existsByNaziv(String naziv);

}
