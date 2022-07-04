package com.example.demo.service;

import com.example.demo.dto.KomentarDto;
import com.example.demo.entity.Komentar;
import com.example.demo.entity.Korisnik;
import com.example.demo.entity.Kupac;
import com.example.demo.repository.KomentarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class KomentarService {

    @Autowired
    private KomentarRepository komentarRepository;

    public Komentar response(KomentarDto komentarDto, Korisnik loggedKupac){
        Kupac kupac = (Kupac) loggedKupac;
        Komentar komentar = new Komentar(
                komentarDto.getTekst(),
                komentarDto.getOcena()
        );

        komentar.setKupac(kupac);
        //komentar.setRestoran(restoran); Dobavljanje restorana, nemamo id! :(
        komentarRepository.save(komentar);

        return komentar;
    }
}
