package com.example.demo.service;

import com.example.demo.dto.ArtikalDto;
import com.example.demo.dto.MenadzerDto;
import com.example.demo.entity.*;
import com.example.demo.repository.ArtikliRepository;
import com.example.demo.repository.MenadzerRepository;
import com.example.demo.repository.RestoranRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MenadzerService {

    @Autowired
    private MenadzerRepository menadzerRepository;
    @Autowired
    private ArtikliRepository artikliRepository;
    @Autowired
    private RestoranRepository restoranRepository;

    public Artikli createArtikal(ArtikalDto artikliDto, Korisnik loggedKorisnik){
        if(loggedKorisnik.getUloga() == Uloga.MENADZER) {
            Menadzer menadzer = (Menadzer) loggedKorisnik;
        //    Artikli artikal = artikliRepository.getById(artikliDto.getId());

            Artikli artikli = new Artikli(
                    artikliDto.getNaziv(),
                    artikliDto.getCena(),
                    artikliDto.getTip(),
                    artikliDto.getKolicina(),
                    artikliDto.getOpis()
                    );
            if (artikliRepository.existsByNaziv(artikli.getNaziv())) {
                return null; //menadzer postoji
            }
            artikliRepository.save(artikli);


            Restoran restoran = menadzer.getRestoran();
            restoran.getArtikliRestoran().add(artikli);
            restoranRepository.save(restoran);

            return artikli;
        }
        return null; //nije admin


       // public Optional<Menadzer> findById(Long id) {
       // return menadzerRepository.findById(id);
    }
}
