package com.example.demo.service;

import com.example.demo.entity.Korisnik;
import com.example.demo.entity.Lokacija;
import com.example.demo.entity.Restoran;
import com.example.demo.repository.LokacijaRepository;
import com.example.demo.repository.RestoranRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class RestoranService {

    @Autowired
    private RestoranRepository restoranRepository;

    @Autowired
    private LokacijaRepository lokacijaRepository;

    public Restoran getById(Long id) {
        return restoranRepository.getOne(id);
    }

    public List<Restoran> getAllRestoran(){ return restoranRepository.findAll(); }
    /*public String findByIme(String restoran){
        restoran;
    }*/
    public List<Restoran> findByNaziv(String naziv){
        return restoranRepository.findByNaziv(naziv);
    }
    public List<Restoran> findByTip(String tip){
        return restoranRepository.findByTip(tip);
    }
    public List<Restoran> getByLokacija(Long id_lokacija){
        Lokacija lokacija = lokacijaRepository.findById(id_lokacija).get();
        return restoranRepository.findByLokacija(lokacija);
    }
}
