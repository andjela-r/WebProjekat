package com.example.demo.service;

import com.example.demo.entity.Korisnik;
import com.example.demo.entity.Uloga;
import com.example.demo.repository.KorisnikRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminService {

    @Autowired
    private KorisnikRepository korisnikRepository;

    public List<Korisnik> findAll(Korisnik loggedKorisnik){
        if(loggedKorisnik.getUloga() == Uloga.ADMIN) {
            return korisnikRepository.findAll();
        }
        return null;
    }



}
