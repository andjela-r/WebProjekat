package com.example.demo.service;

import com.example.demo.entity.*;
import com.example.demo.repository.MenadzerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class MenadzerService {

    @Autowired
    private MenadzerRepository menadzerRepository;

    public Menadzer createMenadzer(String username, String pass, String ime, String prezime, Date datumRodjenja, Pol pol, Restoran restoran){
        Menadzer menadzer = new Menadzer();
        menadzer.setUloga(Uloga.MENADZER);
        menadzer.setIme(ime);
        menadzer.setPrezime(prezime);
        menadzer.setKorisnickoIme(username);
        menadzer.setLozinka(pass);
        menadzer.setDatumRodjenja(datumRodjenja);
        menadzer.setPol(pol);
        menadzer.setRestoran(restoran);

        return menadzer;
    }

    public Menadzer save(Menadzer newMenadzer){
        return menadzerRepository.save(newMenadzer);

    }

}
