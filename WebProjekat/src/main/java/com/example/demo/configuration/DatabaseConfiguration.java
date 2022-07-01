package com.example.demo.configuration;

import com.example.demo.entity.*;
import com.example.demo.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.*;

@Configuration
public class DatabaseConfiguration {

    @Autowired
    private ArtikliRepository artikliRepository;

    @Autowired
    private DostavljacRepository dostavljacRepository;

    @Autowired
    private KomentarRepository komentarRepository;

    @Autowired
    private KorisnikRepository korisnikRepository;

    @Autowired
    private KupacRepository kupacRepository;

    @Autowired
    private LokacijaRepository lokacijaRepository;

    @Autowired
    private MenadzerRepository menadzerRepository;

    @Autowired
    private PorudzbinaRepository porudzbinaRepository;

    @Autowired
    private RestoranRepository restoranRepository;

    @Autowired
    private TipKupcaRepository tipKupcaRepository;



    @Bean
    public boolean instantiate() {
        TipKupca tipKupca = new TipKupca(
                "Zlatni",
                0.3,
                200

        );

        tipKupcaRepository.save(tipKupca);

        TipKupca tipKupca1 = new TipKupca(
                "Srebrni",
                0.2,
                100

        );

        tipKupcaRepository.save(tipKupca1);

        TipKupca tipKupca2 = new TipKupca(
                "Bronzani",
                0.1,
                50

        );

        tipKupcaRepository.save(tipKupca2);

       Korisnik korisnik = new Korisnik(
               "mile021", "1234",
               "Milorad", "Milic",
               new Date(2000, Calendar.JULY, 4 ),
               Pol.Muski,
               Uloga.ADMIN
               );
       korisnikRepository.save(korisnik);

        Lokacija lokacija = new Lokacija(
                11.4, 13.7,
                "Nikole Pasica 13"
        );
        lokacijaRepository.save(lokacija);

        Restoran restoran = new Restoran();
        restoran.setLokacija(lokacija);
        restoran.setNaziv("Tortilla Casa");
        restoran.setTip("Meksicka hrana");
        restoranRepository.save(restoran);

        Menadzer korisnik1 = new Menadzer(
                "jole", "1a34",
                "Jovan", "Jovic",
                new Date(2001, Calendar.MAY, 10 ),
                Pol.Muski,
                Uloga.MENADZER
        );
        korisnik1.setRestoran(restoran);
        korisnikRepository.save(korisnik1);

        Korisnik korisnik2 = new Korisnik(
                "maja", "1134",
                "Maja", "Munjic",
                new Date(2000, Calendar.OCTOBER, 7 ),
                Pol.Zenski,
                Uloga.DOSTAVLJAC
        );
        korisnikRepository.save(korisnik2);

        Korisnik korisnik3 = new Korisnik(
                "lela12", "999",
                "Leposava", "Lepa",
                new Date( ),
                Pol.Zenski,
                Uloga.KUPAC
        );
        korisnikRepository.save(korisnik3);

        Kupac kupac = new Kupac(
                "djolence", "1134",
                "Djole", "Djokic",
                new Date(2000, Calendar.OCTOBER, 7 ),
                Pol.Muski,
                Uloga.KUPAC
        );
        kupacRepository.save(kupac);




        Artikli artikli = new Artikli(
                "Pileca kobasica",
                120.99,
                TIP.JELO,
                2000,
                "Moras probati!!!"
        );

        artikliRepository.save(artikli);

        Artikli artikli1 = new Artikli(
                "Paradajz sok",
                399.99,
                TIP.PICE,
                1000,
                "Bogato daj pare"
        );

        artikliRepository.save(artikli1);

       return true;
    }
}