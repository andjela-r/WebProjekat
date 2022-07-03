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
        Korisnik loggedMenadzer = (Korisnik) session.getAttribute("korisnik");
        if (loggedMenadzer == null) {
            return new ResponseEntity("Niste ulogovani.", HttpStatus.UNAUTHORIZED);
        }
        Optional<Korisnik> realMenadzer = korisnikService.findById(loggedMenadzer.getId());
        if(!realMenadzer.isPresent()){
            return new ResponseEntity("Niste menadzer.", HttpStatus.UNAUTHORIZED);
        }
        //Restoran restoran = realMenadzer.get().getRestoran();
        //Restoran restoran = restoranRepository.getById(loggedMenadzer.getRestoran().getId());

//        if (restoran == null) {
//            return new ResponseEntity("Nemate dodeljeni restoran!", HttpStatus.FORBIDDEN);
//        }

        return ResponseEntity.ok().build();
    }

    @GetMapping("/api/menadzer/porudzbine")
    public ResponseEntity<Set<Artikli>> getPorudzbine(HttpSession session){
        Menadzer loggedMenadzer = (Menadzer) session.getAttribute("korisnik");
        if (loggedMenadzer == null) {
            return new ResponseEntity("Niste ulogovani.", HttpStatus.UNAUTHORIZED);
        }

        return new ResponseEntity("Nije funkcionalno.", HttpStatus.BAD_REQUEST);
    }

    @PostMapping("/api/menadzer/add-artikal")
    public ResponseEntity<String> addArtikal (@RequestBody ArtikalDto artikalDto, HttpSession session){
        Korisnik loggedKorisnik = (Korisnik) session.getAttribute("korisnik");
        if (loggedKorisnik == null) {
            return new ResponseEntity("Niste ulogovani.", HttpStatus.UNAUTHORIZED);
        }
        if(artikalDto.getNaziv().isEmpty()
                || artikalDto.getTip().toString().isEmpty())
            return new ResponseEntity("Nisu uneti neophodni podaci.", HttpStatus.I_AM_A_TEAPOT);

        Artikli newArtikli = menadzerService.createArtikal(artikalDto, loggedKorisnik);
        if(newArtikli == null){
            return new ResponseEntity("Proverite korisnicko ime i restoran, nesto nije bas dobro :'(", HttpStatus.I_AM_A_TEAPOT);
            //kako resiti?
        }

        session.setAttribute("created", newArtikli);
        return ResponseEntity.ok("Uspesno kreiran artikal!");
    }

    @RequestMapping(value = "/api/updatea/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Artikli> updateArtikal(@PathVariable("id") long id, @RequestBody Artikli artikli) {
        System.out.println("Azuriras artikal sa id:  " + id);

       Artikli currentArt = artikliService.getById(id);

        if (currentArt==null) {
            System.out.println("Artikal sa id-em:  " + id + " nije pronadjen");
            return new ResponseEntity<Artikli>(HttpStatus.NOT_FOUND);
        }
        currentArt.setNaziv(artikli.getNaziv());
        currentArt.setCena(artikli.getCena());
        currentArt.setKolicina(artikli.getKolicina());
        currentArt.setOpis(artikli.getOpis());
        currentArt.setTip(artikli.getTip());

        artikliService.updateArtikli(currentArt);
        return new ResponseEntity<Artikli>(currentArt, HttpStatus.OK);
    }
}
