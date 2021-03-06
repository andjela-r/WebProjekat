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

    @Autowired
    private StavkaPorudzbineRepository stavkaPorudzbineRepository;

    @Bean
    public boolean instantiate() {
        TipKupca zlatniTipKupca = new TipKupca(
                "Zlatni",
                0.3,
                200
        );
        tipKupcaRepository.save(zlatniTipKupca);

        TipKupca srebrniTipKupca = new TipKupca(
                "Srebrni",
                0.2,
                100
        );
        tipKupcaRepository.save(srebrniTipKupca);

        TipKupca bronzaniTipKupca = new TipKupca(
                "Bronzani",
                0.1,
                50
        );
        tipKupcaRepository.save(bronzaniTipKupca);

        //ADMIN
        Korisnik admin = new Korisnik(
                "admin", "1234",
                "Milorad", "Milic",
                new Date(2000, Calendar.JULY, 4 ),
                Pol.Muski,
                Uloga.ADMIN
        );
        korisnikRepository.save(admin);

        //LOKACIJE
        Lokacija lokacija = new Lokacija(
                45.25131544463255, 19.837983008598467,
                "Bulevar Oslobo??enja 91, Novi Sad"
        );
        lokacijaRepository.save(lokacija);

        Lokacija lokacija1 = new Lokacija(
                45.249121680493715, 19.84314663497258,
                "Sremska 9, Novi Sad"
        );
        lokacijaRepository.save(lokacija1);

        Lokacija lokacija2 = new Lokacija(
                45.24878334532537, 19.841264549073696,
                "Maksima Gorkog 1a, Novi Sad"
        );
        lokacijaRepository.save(lokacija2);

        Lokacija lokacija3 = new Lokacija(
                56.24878334532537, 23.841264549073696,
                "Nikole Pa??i??a 39, Kragujevac"
        );
        lokacijaRepository.save(lokacija3);

        //RESTORANI

        Restoran camelot = new Restoran();
        camelot.setLokacija(lokacija1);
        camelot.setNaziv("The Camelot Novi Sad");
        camelot.setTip("Gastro pub");
        camelot.setOcena(3.5);
        camelot.setRadi(true);
        restoranRepository.save(camelot);

        Restoran tortillaCasa = new Restoran();
        tortillaCasa.setLokacija(lokacija);
        tortillaCasa.setNaziv("Tortilla Casa");
        tortillaCasa.setTip("Meksi??ka hrana");
        camelot.setOcena(4.0);
        tortillaCasa.setRadi(true);
        restoranRepository.save(tortillaCasa);

        Restoran fresh = new Restoran();
        fresh.setLokacija(lokacija2);
        fresh.setNaziv("Sushi Fresh");
        fresh.setTip("Sushi");
        fresh.setOcena(2.6);
        fresh.setRadi(false);
        restoranRepository.save(fresh);

        Menadzer menadzer = new Menadzer(
                "menadzer", "1234",
                "Jovan", "Jovic",
                new Date(2001, Calendar.MAY, 10 ),
                Pol.Muski,
                Uloga.MENADZER
        );
        menadzer.setRestoran(camelot);
        menadzerRepository.save(menadzer);

        Menadzer menadzer1 = new Menadzer(
                "menadzer1", "1234",
                "Jovana", "Jovanovi??",
                new Date(1996, Calendar.SEPTEMBER, 13 ),
                Pol.Zenski,
                Uloga.MENADZER
        );
        menadzerRepository.save(menadzer1);

        //DOSTAVLJAC
        Dostavljac dostavljac = new Dostavljac(
                "dostavljac", "1234",
                "Maja", "Munji??",
                new Date(2000, Calendar.OCTOBER, 7 ),
                Pol.Zenski,
                Uloga.DOSTAVLJAC
        );
        dostavljacRepository.save(dostavljac);

        Dostavljac dostavljac1 = new Dostavljac(
                "dostavljac1", "1234",
                "Jovan", "Milo??evi??",
                new Date(1998, Calendar.MARCH, 24 ),
                Pol.Muski,
                Uloga.DOSTAVLJAC
        );
        dostavljacRepository.save(dostavljac1);

        //KUPCI
        Kupac kupac = new Kupac(
                "kupac", "1234",
                "Leposava", "Mili??",
                new Date(1999, Calendar.MAY, 1),
                Pol.Zenski,
                Uloga.KUPAC
        );
        kupac.setBrojBodova(150);
        kupac.setTipKupca(srebrniTipKupca);
        kupacRepository.save(kupac);

        Kupac kupac1 = new Kupac(
                "kupac1", "1234",
                "??ole", "??oki??",
                new Date(2000, Calendar.OCTOBER, 7 ),
                Pol.Muski,
                Uloga.KUPAC
        );
        kupac1.setBrojBodova(98);
        kupac1.setTipKupca(bronzaniTipKupca);
        kupacRepository.save(kupac1);

        Kupac kupac2 = new Kupac(
                "kupac2", "1234",
                "Milica", "Simonovi??",
                new Date(1985, Calendar.JANUARY, 21 ),
                Pol.Zenski,
                Uloga.KUPAC
        );
        kupac2.setBrojBodova(251);
        kupac2.setTipKupca(zlatniTipKupca);
        kupacRepository.save(kupac2);

        //ARTIKLI
        Artikli artikliCamelot = new Artikli(
                "The Camelot klub sendvi??",
                690.00,
                TIP.JELO,
                600,
                "Kifla, ??ampinjoni, slanina, paprika, pavlaka, ke??ap, sir gauda, paradajz, dimljeni vrat, kulen, pomfrit."
        );
        artikliRepository.save(artikliCamelot);

        Artikli artikliCamelot1 = new Artikli(
                "Pivarska rebarca sa medom",
                1550.00,
                TIP.JELO,
                800,
                "Rebarca u pivu, tartar sos, podvarak, za??inski krompir, lepinja."
        );
        artikliRepository.save(artikliCamelot1);

        Artikli artikliCamelot2 = new Artikli(
                "Limunada",
                230.00,
                TIP.PICE,
                0.3,
                "Osve??avaju??e pi??e od ce??enog limuna."
        );
        artikliRepository.save(artikliCamelot2);

        camelot.getArtikliRestoran().add(artikliCamelot);
        camelot.getArtikliRestoran().add(artikliCamelot1);
        camelot.getArtikliRestoran().add(artikliCamelot2);
        restoranRepository.save(camelot);

        Artikli artikliTortilla = new Artikli(
                "Burrito Acapulco",
                430.00,
                TIP.JELO,
                700,
                "Piletina, pirina?? sa limetom i per??unom, crni pasulj, kukuruz, paradajz, zelena, pavlaka, sir."
        );
        artikliRepository.save(artikliTortilla);

        Artikli artikliTortilla1 = new Artikli(
                "Taquitos pile??i",
                420.00,
                TIP.JELO,
                500,
                "9 kom. + pomfrit + 2 sosa po izboru."
        );
        artikliRepository.save(artikliTortilla1);

        Artikli artikliTortilla2 = new Artikli(
                "Fanta",
                170.00,
                TIP.PICE,
                0.25,
                "Gazirano pi??e sa aromom narand??e."
        );
        artikliRepository.save(artikliTortilla2);
        tortillaCasa.getArtikliRestoran().add(artikliTortilla);
        tortillaCasa.getArtikliRestoran().add(artikliTortilla1);
        tortillaCasa.getArtikliRestoran().add(artikliTortilla2);
        restoranRepository.save(tortillaCasa);

        Artikli artikliFresh = new Artikli(
                "Philadelfia Maxi Rolls",
                710.00,
                TIP.JELO,
                200,
                "8 komada. Losos, avokado, krastavac, krem sir, tobiko red."
        );
        artikliRepository.save(artikliFresh);

        Artikli artikliFresh1 = new Artikli(
                "Tempura kraba Premium Rolnice",
                750.00,
                TIP.JELO,
                250,
                "10 komada. Kraba, avokado, krastavac, wasabi majonez."
        );
        artikliRepository.save(artikliFresh1);

        Artikli artikliFresh2 = new Artikli(
                "Ce??eni Miks",
                350.00,
                TIP.PICE,
                0.3,
                "Limun, narand??a, grejpfrut."
        );
        artikliRepository.save(artikliFresh2);

        fresh.getArtikliRestoran().add(artikliFresh);
        fresh.getArtikliRestoran().add(artikliFresh1);
        fresh.getArtikliRestoran().add(artikliFresh2);
        restoranRepository.save(fresh);

        StavkaPorudzbine stavka = new StavkaPorudzbine(
                artikliCamelot,
                150
        );
        stavkaPorudzbineRepository.save(stavka);

        Porudzbina gotovaPorudzbina = new Porudzbina(
                camelot,
                dostavljac,
                new Date(2022, Calendar.JUNE, 4),
                500.0,
                STATUS.DOSTAVLJENO,
                kupac
        );
        gotovaPorudzbina.getStavka().add(stavka);
        kupac.getPorudzbina().add(gotovaPorudzbina);
        //kupacRepository.save(kupac);
        dostavljac.getPorudzbinaDostavljac().add(gotovaPorudzbina);

        porudzbinaRepository.save(gotovaPorudzbina);
        dostavljacRepository.save(dostavljac);

     /*   Komentar komentar1 = new Komentar();
        komentar1.setRestoran(camelot);
        komentar1.setKupac(kupac);
        komentar1.setTekst("Sve odlicno i prelepo");
        komentar1.setOcena(5);
        komentarRepository.save(komentar1);

      //  camelot.setKomentar(komentar1);
        //.save(camelot);

        Komentar komentar2 = new Komentar();
        komentar2.setRestoran(camelot);
        komentar2.setKupac(kupac1);
        komentar2.setTekst("Bilo hladno i bez veze");
        komentar2.setOcena(2);
        komentarRepository.save(komentar2);

        Komentar komentar3 = new Komentar();
        komentar3.setRestoran(tortillaCasa);
        komentar3.setKupac(kupac);
        komentar3.setTekst("njami");
        komentar3.setOcena(4);
        komentarRepository.save(komentar3);

        Komentar komentar4 = new Komentar();
        komentar4.setRestoran(tortillaCasa);
        komentar4.setKupac(kupac2);
        komentar4.setTekst("Kasnilo pola sata");
        komentar4.setOcena(4);
        komentarRepository.save(komentar4);

        Komentar komentar5 = new Komentar();
        komentar5.setRestoran(fresh);
        komentar5.setKupac(kupac2);
        komentar5.setTekst("Preljepo");
        komentar5.setOcena(5);
        komentarRepository.save(komentar5);

        Komentar komentar6 = new Komentar();
        komentar6.setRestoran(fresh);
        komentar6.setKupac(kupac2);
        komentar6.setTekst("Ukusno ali preslano");
        komentar6.setOcena(4);
        komentarRepository.save(komentar6);

        Komentar komentar7 = new Komentar();
        komentar7.setRestoran(camelot);
        komentar7.setKupac(kupac2);
        komentar7.setTekst("Vrlo misterioznog ukusa");
        komentar7.setOcena(5);
        komentarRepository.save(komentar7);
*/

        return true;
    }
}