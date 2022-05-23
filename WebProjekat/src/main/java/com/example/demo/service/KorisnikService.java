package com.example.demo.service;

import com.example.demo.entity.*;
import com.example.demo.repository.KorisnikRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class KorisnikService {
    @Autowired
    private KorisnikRepository korisnikRepository;

    public Korisnik getById(Long aLong) {
        return korisnikRepository.getOne(aLong);
    }

    public  List<Korisnik> findAll() {
        return korisnikRepository.findAll();
    }

    public Korisnik login(String username, String password) {
        Korisnik korisnik = korisnikRepository.getByKorisnickoIme(username);
        if(korisnik == null || !korisnik.getLozinka().equals(password))
            return null;
        return  korisnik;
    }
    public boolean postoji(String username){
        return korisnikRepository.existsByKorisnickoIme(username);
    }

    public Korisnik register(String username, String pass, String ime, String prezime, Date datumRodjenja, Pol pol){
        Korisnik korisnik = new Korisnik();
        korisnik.setUloga(Uloga.KUPAC);
        korisnik.setIme(ime);
        korisnik.setPrezime(prezime);
        korisnik.setKorisnickoIme(username);
        korisnik.setLozinka(pass);
        korisnik.setDatumRodjenja(datumRodjenja);
        korisnik.setPol(pol);
        return korisnik;
    }

    public Korisnik save(Korisnik newKorisnik){
              return korisnikRepository.save(newKorisnik);

    }

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

    public Dostavljac createDostavljac(String username, String pass, String ime, String prezime, Date datumRodjenja, Pol pol){
        Dostavljac dostavljac = new Dostavljac();
        dostavljac.setUloga(Uloga.DOSTAVLJAC);
        dostavljac.setIme(ime);
        dostavljac.setPrezime(prezime);
        dostavljac.setKorisnickoIme(username);
        dostavljac.setLozinka(pass);
        dostavljac.setDatumRodjenja(datumRodjenja);
        dostavljac.setPol(pol);

        return dostavljac;

    }

//    String korisnickoIme,
//    String lozinka,
//    String ime,
//    String prezime,
//    Date datumRodjenja,
//    Pol pol,
//    Uloga uloga
//
//    public boolean updateKorisnik(
//            Long id,
//            String korisnickoIme,
//            String lozinka,
//            String ime,
//            String prezime,
//            Date datumRodjenja,
//            Pol pol,
//            Uloga uloga){
//        return false;
//    }
//    public boolean deleteKorisnik(Long id){
//        return false;
//    }
}
