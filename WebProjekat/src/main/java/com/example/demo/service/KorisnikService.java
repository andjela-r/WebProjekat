package com.example.demo.service;

import com.example.demo.dto.ArtikalDto;
import com.example.demo.dto.KomentarDto;
import com.example.demo.entity.*;
import com.example.demo.repository.KomentarRepository;
import com.example.demo.repository.KorisnikRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import static com.example.demo.entity.STATUS.*;

@Service
public class KorisnikService {
    @Autowired
    private KorisnikRepository korisnikRepository;

    @Autowired
    private KomentarRepository komentarRepository;

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

    public Optional<Korisnik> findById(Long id) {
        return korisnikRepository.findById(id);
    }

   /* public Komentar createKomentar(KomentarDto komDto, Korisnik loggedKorisnik) {
        Kupac kupac = (Kupac) loggedKorisnik;
        Set<Porudzbina> porudzbine = kupac.getPorudzbina();
        if (loggedKorisnik.getUloga() == Uloga.KUPAC && porudzbine.getStatus() == DOSTAVLJENO) {
            Komentar kom = new Komentar(
                    komDto.getTekst(),
                    komDto.getOcena()
            );
            komentarRepository.save(kom);
            return kom;
        }
        return null;
    }*/
}
