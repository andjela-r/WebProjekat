package com.example.demo.service;

import com.example.demo.entity.Korisnik;
import com.example.demo.entity.Pol;
import com.example.demo.entity.Uloga;
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

//    public Korisnik save(KorisnikDTO korisnik){
//        //
////              Korisnik korisnikEntitet = new Korisnik (premapirane stvari + id + uloga)
//                return korisnikRepository.save(korisnikEntitet);

//    }

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
