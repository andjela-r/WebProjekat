package com.example.demo.controller;

import com.example.demo.dto.MenadzerDto;
import com.example.demo.dto.ArtikalDto;
import com.example.demo.entity.Artikli;
import com.example.demo.entity.Korisnik;
import com.example.demo.entity.Menadzer;
import com.example.demo.entity.Restoran;
import com.example.demo.repository.KorisnikRepository;
import com.example.demo.repository.RestoranRepository;
import com.example.demo.service.KorisnikService;
import com.example.demo.service.MenadzerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.reactive.ReactiveSortingRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

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
                || artikalDto.getTip().toString().isEmpty()
                || artikalDto.getOpis().isEmpty())
            return new ResponseEntity("Nisu uneti neophodni podaci.", HttpStatus.BAD_REQUEST);

        Artikli newArtikli = menadzerService.createArtikal(artikalDto, loggedKorisnik);
        if(newArtikli == null){
            return new ResponseEntity("Proverite korisnicko ime i restoran, nesto nije bas dobro :'(", HttpStatus.I_AM_A_TEAPOT);
            //kako resiti?
        }

        session.setAttribute("created", newArtikli);
        return ResponseEntity.ok("Uspesno kreiran artikal!");
    }
}
