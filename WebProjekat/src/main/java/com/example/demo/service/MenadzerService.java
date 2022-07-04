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
import java.util.Set;

@Service
public class MenadzerService {

    @Autowired
    private MenadzerRepository menadzerRepository;
    @Autowired
    private ArtikliRepository artikliRepository;
    @Autowired
    private RestoranRepository restoranRepository;

    public Menadzer findById(Long id){
        return menadzerRepository.getById(id);
    }

    public Artikli createArtikal(ArtikalDto artikliDto, Korisnik loggedKorisnik){
        if(loggedKorisnik.getUloga() == Uloga.MENADZER) {
            Menadzer menadzer = (Menadzer) loggedKorisnik;

            Artikli artikli = new Artikli(
                    artikliDto.getNaziv(),
                    artikliDto.getCena(),
                    artikliDto.getTip(),
                    artikliDto.getKolicina(),
                    artikliDto.getOpis()
                    );
            if (artikliRepository.existsByNaziv(artikli.getNaziv())) {
                return null;
            }
            artikliRepository.save(artikli);


            Restoran restoran = menadzer.getRestoran();
            restoran.getArtikliRestoran().add(artikli);
            restoranRepository.save(restoran);

            return artikli;
        }
        return null;
    }

    public void radiRestoran(Korisnik loggedKorisnik){
        Menadzer menadzer = (Menadzer) loggedKorisnik;
        Restoran restoran = menadzer.getRestoran();
        restoran.setRadi(true);
        restoranRepository.save(menadzer.getRestoran());
    }


    //NE RADI
    public void deleteArtikal(Long id_artikla, Korisnik korisnik) {
        Menadzer menadzer = (Menadzer) korisnik;
        Set<Artikli> artikli =  menadzer.getRestoran().getArtikliRestoran();
        for(Artikli artikal : artikli){
            if(artikal.getId().equals(id_artikla)){
                menadzer.getRestoran().getArtikliRestoran().remove(artikal);

            }
        }
    }
}
