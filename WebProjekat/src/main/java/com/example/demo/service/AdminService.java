package com.example.demo.service;

import com.example.demo.dto.DostavljacDto;
import com.example.demo.dto.MenadzerDto;
import com.example.demo.dto.RestoranDto;
import com.example.demo.entity.*;
import com.example.demo.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    @Autowired
    private LokacijaRepository lokacijaRepository;

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
    /*Kreiraj novi restoran*/
    public Restoran createRestoran(RestoranDto restoranDto, Korisnik loggedKorisnik){
        if(loggedKorisnik.getUloga() == Uloga.ADMIN) {
            Long id_menadzera = restoranDto.getId_menadzera();
            Optional<Menadzer> noviMenadzer = menadzerRepository.findById(id_menadzera);

            Long id_lokacija = restoranDto.getId_lokacija();
            Optional<Lokacija> novaLokacija = lokacijaRepository.findById(id_lokacija);


            Restoran restoran = new Restoran(restoranDto.getNaziv(),
                    restoranDto.getTip(),
                    novaLokacija.get());

            noviMenadzer.get().setRestoran(restoran);
            menadzerRepository.save(noviMenadzer.get());
            //restoranRepository.save(restoran);
            return restoran;
        }
        return null; //nije admin
    }

    public void deleteRestoran(Long id_restorana){
        restoranRepository.deleteById(id_restorana);
    }

    public List<Korisnik> findByIme(String ime){
        return korisnikRepository.findByIme(ime);
    }
    public List<Korisnik> findByPrezime(String prezime){
        return korisnikRepository.findByPrezime(prezime);
    }
    public List<Korisnik> findByKorisnickoIme(String korisnickoIme){
        return korisnikRepository.findByKorisnickoIme(korisnickoIme);
    }
}
