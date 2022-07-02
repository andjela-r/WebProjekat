package com.example.demo.repository;

import com.example.demo.entity.Artikli;
import com.example.demo.entity.Korisnik;
import com.example.demo.entity.Restoran;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ArtikliRepository extends JpaRepository<Artikli, Long>{
   boolean existsByNaziv(String naziv);
   Artikli getById(Long id);

}
