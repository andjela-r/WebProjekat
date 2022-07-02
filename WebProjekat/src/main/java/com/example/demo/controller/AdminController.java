package com.example.demo.controller;

import com.example.demo.dto.DostavljacDto;
import com.example.demo.dto.MenadzerDto;
import com.example.demo.dto.RestoranDto;
import com.example.demo.entity.Dostavljac;
import com.example.demo.entity.Korisnik;
import com.example.demo.entity.Menadzer;
import com.example.demo.entity.Restoran;
import com.example.demo.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
public class AdminController {

     @Autowired
     private AdminService adminService;

    @GetMapping("/api/admin/korisnici")
    public ResponseEntity<List<Korisnik>> getAll(HttpSession session){
        Korisnik loggedKorisnik = (Korisnik) session.getAttribute("korisnik");
        if (loggedKorisnik == null) {
            return new ResponseEntity("Niste ulogovani.", HttpStatus.UNAUTHORIZED);
        }
        List<Korisnik> lista = adminService.findAll(loggedKorisnik);
        if (lista == null) {
            return new ResponseEntity("Nemate dozvolu da ovo uradite!", HttpStatus.FORBIDDEN);
        }

        return ResponseEntity.ok(lista);
    }

    @PostMapping("/api/admin/add-menadzer")
    public ResponseEntity<String> addMenadzer (@RequestBody MenadzerDto menadzerDto, HttpSession session){
        Korisnik loggedKorisnik = (Korisnik) session.getAttribute("korisnik");
        if (loggedKorisnik == null) {
            return new ResponseEntity("Niste ulogovani.", HttpStatus.UNAUTHORIZED);
        }
        if(menadzerDto.getUsername().isEmpty() || menadzerDto.getPassword().isEmpty()
                || menadzerDto.getIme().isEmpty() || menadzerDto.getPrezime().isEmpty()
                || menadzerDto.getDatumRodjenja().toString().isEmpty() || menadzerDto.getPol().toString().isEmpty()
                || menadzerDto.getIdRestoran().toString().isEmpty())
            return new ResponseEntity("Nisu uneti neophodni podaci.", HttpStatus.BAD_REQUEST);

        Menadzer newMenadzer = adminService.createMenadzer(menadzerDto, loggedKorisnik);
        if(newMenadzer == null){
            return new ResponseEntity("Proverite korisnicko ime i restoran, nesto nije bas dobro :'(", HttpStatus.I_AM_A_TEAPOT);
            //kako resiti?
        }

        session.setAttribute("created", newMenadzer);
        return ResponseEntity.ok("Uspesno kreiran nalog za menadzera!");
    }

    @PostMapping("/api/admin/add-dostavljac")
    public ResponseEntity<String> addDostavljac (@RequestBody DostavljacDto dostavljacDto, HttpSession session){
        Korisnik loggedKorisnik = (Korisnik) session.getAttribute("korisnik");
        if (loggedKorisnik == null) {
            return new ResponseEntity("Niste ulogovani.", HttpStatus.UNAUTHORIZED);
        }
        if(dostavljacDto.getUsername().isEmpty() || dostavljacDto.getPassword().isEmpty()
                || dostavljacDto.getIme().isEmpty() || dostavljacDto.getPrezime().isEmpty()
                || dostavljacDto.getDatumRodjenja().toString().isEmpty() || dostavljacDto.getPol().toString().isEmpty())
            return new ResponseEntity("Nisu uneti neophodni podaci.", HttpStatus.BAD_REQUEST);

        Dostavljac newDostavljac = adminService.createDostavljac(dostavljacDto, loggedKorisnik);
        if(newDostavljac == null){
            return new ResponseEntity("Korisnicko ime je zauzeto.", HttpStatus.BAD_REQUEST);
        }

        session.setAttribute("created", newDostavljac);
        return ResponseEntity.ok("Uspesno kreiran nalog za dostavljaca!");
    }

    @PostMapping("api/admin/add-restoran")
    public ResponseEntity<String> addRestoran (@RequestBody RestoranDto restoranDto, HttpSession session){
        Korisnik loggedKorisnik = (Korisnik) session.getAttribute("korisnik");
        if (loggedKorisnik == null) {
            return new ResponseEntity("Niste ulogovani.", HttpStatus.UNAUTHORIZED);
        }
        if(restoranDto.getNaziv().isEmpty() || restoranDto.getTip().isEmpty())
            return new ResponseEntity("Nisu uneti neophodni podaci.", HttpStatus.BAD_REQUEST);

        Restoran newRestoran = adminService.createRestoran(restoranDto, loggedKorisnik);

        if(newRestoran == null)
            return new ResponseEntity("Nemate dozvolu da ovo uradite!", HttpStatus.FORBIDDEN);

        session.setAttribute("created", newRestoran);
        return ResponseEntity.ok("Uspesno kreiran restoran!");
    }




}
