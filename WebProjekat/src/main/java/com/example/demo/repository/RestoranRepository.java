package com.example.demo.repository;

import com.example.demo.entity.Lokacija;
import com.example.demo.entity.Restoran;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RestoranRepository extends JpaRepository<Restoran, Long>{
    Restoran getById(Long id);
    List<Restoran> findAll();
    List<Restoran> findByNaziv(String naziv);
    List<Restoran> findByTip(String tip);
    List<Restoran> findByLokacija(Lokacija lokacija);
    void deleteById(Long id);


  /*  Restoran findByIme(String ime);
    Restoran findByTip(String tip);
    Restoran findByLokacija(Lokacija lokacija);*/
}
