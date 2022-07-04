package com.example.demo.controller;

import com.example.demo.dto.MenadzerDto;
import com.example.demo.dto.ArtikalDto;
import com.example.demo.entity.*;
import com.example.demo.repository.KorisnikRepository;
import com.example.demo.repository.RestoranRepository;
import com.example.demo.service.ArtikliService;
import com.example.demo.service.KorisnikService;
import com.example.demo.service.MenadzerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.reactive.ReactiveSortingRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@RestController
public class MenadzerController {
    @Autowired
    private KorisnikService korisnikService;

    @Autowired
    private MenadzerService menadzerService;

    @Autowired
    private ArtikliService artikliService;

    @Autowired
    private RestoranRepository restoranRepository;

    @GetMapping("/api/menadzer/moj-restoran")
    public ResponseEntity<Restoran> getMyRestoran(HttpSession session){
        Menadzer loggedMenadzer = (Menadzer) session.getAttribute("korisnik");
        if (loggedMenadzer == null) {
            return new ResponseEntity("Niste ulogovani.", HttpStatus.UNAUTHORIZED);
        }
        Menadzer realMenadzer = menadzerService.findById(loggedMenadzer.getId());
        if(realMenadzer == null){
            return new ResponseEntity("Niste menadzer.", HttpStatus.UNAUTHORIZED);
        }
        Restoran restoran = realMenadzer.getRestoran();
        if (restoran == null) {
            return new ResponseEntity("Nemate dodeljeni restoran!", HttpStatus.FORBIDDEN);
        }

        return ResponseEntity.ok(restoran);
    }

    @GetMapping("/api/menadzer/porudzbine")
    public ResponseEntity<Set<Artikli>> getPorudzbine(HttpSession session){
        Menadzer loggedMenadzer = (Menadzer) session.getAttribute("korisnik");
        if (loggedMenadzer == null) {
            return new ResponseEntity("Niste ulogovani.", HttpStatus.UNAUTHORIZED);
        }
        Set<Artikli> restoranArtikli = loggedMenadzer.getRestoran().getArtikliRestoran();
        return ResponseEntity.ok(restoranArtikli);
    }

    @PostMapping("/api/menadzer/add-artikal")
    public ResponseEntity<String> addArtikal (@RequestBody ArtikalDto artikalDto, HttpSession session){
        Korisnik loggedKorisnik = (Korisnik) session.getAttribute("korisnik");
        if (loggedKorisnik == null) {
            return new ResponseEntity("Niste ulogovani.", HttpStatus.UNAUTHORIZED);
        }
        if(artikalDto.getNaziv().isEmpty() ||
                artikalDto.getTip().toString().isEmpty() ||
                artikalDto.getCena()== 0.0)

                //String.valueOf(artikalDto.getCena().isEmpty())
            return new ResponseEntity("Nisu uneti neophodni podaci.", HttpStatus.BAD_REQUEST);

        Artikli newArtikli = menadzerService.createArtikal(artikalDto, loggedKorisnik);
        if(newArtikli == null){
            return new ResponseEntity("Proverite korisnicko ime i restoran, nesto nije bas dobro :'(", HttpStatus.I_AM_A_TEAPOT);
            //kako resiti?
        }

        session.setAttribute("created", newArtikli);
        return ResponseEntity.ok("Uspesno kreiran artikal!");
    }

    @RequestMapping(value = "/api/menadzer/izmeni-artikal/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Artikli> updateArtikal(@PathVariable("id") long id, @RequestBody Artikli artikli) {

       Artikli currentArt = artikliService.getById(id);

        if (currentArt==null) {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
        currentArt.setNaziv(artikli.getNaziv());
        currentArt.setCena(artikli.getCena());
        currentArt.setKolicina(artikli.getKolicina());
        currentArt.setOpis(artikli.getOpis());
        currentArt.setTip(artikli.getTip());

        artikliService.updateArtikli(currentArt);
        return new ResponseEntity(currentArt, HttpStatus.OK);
    }

    @PutMapping("/api/restorani/otvaranje")
    public ResponseEntity<String> otvoriRestoran(HttpSession session){
        Korisnik loggedKorisnik = (Korisnik) session.getAttribute("korisnik");
        menadzerService.radiRestoran(loggedKorisnik);
        return ResponseEntity.ok("Uspesno otvoren restoran.");
    }

    //@Transactional
    @PutMapping("/api/restorani/delete-artikal/{id}")
    public ResponseEntity<String> deleteArtikal(@PathVariable Long id, HttpSession session) {
        Korisnik loggedKorisnik = (Korisnik) session.getAttribute("korisnik");
        menadzerService.brisanjeArtikla(id);
        return ResponseEntity.ok("Uspesno obrisan atrikal.");
    }
}
