package com.example.demo.service;

import com.example.demo.entity.Kupac;
import com.example.demo.entity.Pol;
import com.example.demo.entity.Uloga;
import com.example.demo.repository.KupacRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Date;
import java.util.List;

@Service
public class KupacService {

    @Autowired
    private KupacRepository kupacRepository;

    public Kupac getById(Long aLong) {
        return kupacRepository.getOne(aLong);
    }

    public List<Kupac> findAll() {
        return kupacRepository.findAll();
    }

    public Kupac login(String username, String password) {
        Kupac kupac = kupacRepository.getByKorisnickoIme(username);
        if(kupac == null || !kupac.getLozinka().equals(password))
            return null;
        return  kupac;
    }
    public boolean postoji(String username){
        return kupacRepository.existsByKorisnickoIme(username);
    }

    public Kupac register(String username, String pass, String ime, String prezime, Date datumRodjenja, Pol pol){
        Kupac kupac = new Kupac();
        kupac.setUloga(Uloga.KUPAC);
        kupac.setIme(ime);
        kupac.setPrezime(prezime);
        kupac.setKorisnickoIme(username);
        kupac.setLozinka(pass);
        kupac.setDatumRodjenja(datumRodjenja);
        kupac.setPol(pol);
        return kupac;
    }

    public void updateKupac(Kupac kupac){
        kupacRepository.save(kupac);
    }

    public Kupac save(Kupac newKorisnik){
        return kupacRepository.save(newKorisnik);

    }
}
