package com.example.demo.service;

import com.example.demo.entity.Dostavljac;
import com.example.demo.entity.Pol;
import com.example.demo.entity.Uloga;
import com.example.demo.repository.DostavljacRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class DostavljacService {

    @Autowired
    private DostavljacRepository dostavljacRepository;

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
}
