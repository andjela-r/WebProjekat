package com.example.demo.service;

import com.example.demo.dto.DostavljacDto;
import com.example.demo.dto.MenadzerDto;
import com.example.demo.entity.*;
import com.example.demo.repository.DostavljacRepository;
import com.example.demo.repository.KorisnikRepository;
import com.example.demo.repository.MenadzerRepository;
import com.example.demo.repository.RestoranRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminService {

    @Autowired
    private KorisnikRepository korisnikRepository;

    @Autowired
    private MenadzerRepository menadzerRepository;

    @Autowired
    private DostavljacRepository dostavljacRepository;

    @Autowired
    private RestoranRepository restoranRepository;

    /*Prikazi sve korisnike*/
    public List<Korisnik> findAll(Korisnik loggedKorisnik){
        if(loggedKorisnik.getUloga() == Uloga.ADMIN) {
            return korisnikRepository.findAll();
        }
        return null;
    }

    /*Kreiraj novog menadzera*/
    public Menadzer createMenadzer(MenadzerDto menadzerDto, Korisnik loggedKorisnik){
        if(loggedKorisnik.getUloga() == Uloga.ADMIN) {
            Restoran restoran = restoranRepository.getById(menadzerDto.getIdRestoran());
            if (restoran == null) {
                return null;
            }
            Menadzer menadzer = new Menadzer(menadzerDto.getUsername(),
                    menadzerDto.getPassword(),
                    menadzerDto.getIme(),
                    menadzerDto.getPrezime(),
                    menadzerDto.getDatumRodjenja(),
                    menadzerDto.getPol(),
                    Uloga.MENADZER,
                    restoran);
            if (menadzerRepository.existsByKorisnickoIme(menadzer.getKorisnickoIme())) {
                return null; //menadzer postoji
            }
            menadzerRepository.save(menadzer);
            return menadzer;
        }
        return null; //nije admin
    }

    /*Kreiraj novog dostavljaca*/
    public Dostavljac createDostavljac(DostavljacDto dostavljacDto, Korisnik loggedKorisnik){
        if(loggedKorisnik.getUloga() == Uloga.ADMIN) {
            Dostavljac dostavljac = new Dostavljac(dostavljacDto.getUsername(),
                    dostavljacDto.getPassword(),
                    dostavljacDto.getIme(),
                    dostavljacDto.getPrezime(),
                    dostavljacDto.getDatumRodjenja(),
                    dostavljacDto.getPol(),
                    Uloga.KUPAC);
            if (dostavljacRepository.existsByKorisnickoIme(dostavljac.getKorisnickoIme())) {
                return null; //dostavljac postoji
            }
            dostavljacRepository.save(dostavljac);
            return dostavljac;
        }
        return null; //nije admin
    }

}
