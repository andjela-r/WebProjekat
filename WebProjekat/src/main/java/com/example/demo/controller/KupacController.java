package com.example.demo.controller;

import com.example.demo.dto.KomentarDto;
import com.example.demo.dto.LoginDto;
import com.example.demo.dto.RegisterDto;
import com.example.demo.entity.*;
import com.example.demo.service.KomentarService;
import com.example.demo.service.KupacService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Set;

@RestController
public class KupacController {

    @Autowired
    private KupacService kupacService;

    @Autowired
    private KomentarService komentarService;

    @PostMapping("/api/register")
    public ResponseEntity<String> register (@RequestBody RegisterDto registerDto, HttpSession session){

        if(registerDto.getUsername().isEmpty() || registerDto.getPassword().isEmpty()
                || registerDto.getIme().isEmpty() || registerDto.getPrezime().isEmpty()
                || registerDto.getDatumRodjenja().toString().isEmpty() || registerDto.getPol().toString().isEmpty())
            return new ResponseEntity("Nisu uneti neophodni podaci.", HttpStatus.BAD_REQUEST);

        Kupac newKupac = kupacService.register(registerDto);
        if (newKupac == null){
            return new ResponseEntity("Korisnicko ime je zauzeto!", HttpStatus.BAD_REQUEST);
        }
        session.setAttribute("korisnik", newKupac);
        return ResponseEntity.ok("Uspesno kreiran nalog!");
    }

    /*@RequestMapping(value="/api/update", method = RequestMethod.PUT)
    public void getKupac(@PathVariable String id, @RequestBody Kupac kupac){
        kupacService.updateKupac(id,kupac);
    }*/
    @RequestMapping(value = "/api/update/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Kupac> updateKupac(@PathVariable("id") long id, @RequestBody Kupac kupac) {
        System.out.println("Azuriras korsinika sa id:  " + id);

        Kupac currentUser = kupacService.getById(id);

        if (currentUser==null) {
            System.out.println("Korisnik sa id-em:  " + id + " nije pronadjen");
            return new ResponseEntity<Kupac>(HttpStatus.NOT_FOUND);
        }

        currentUser.setIme(kupac.getIme());
        currentUser.setPrezime(kupac.getPrezime());
        currentUser.setDatumRodjenja(kupac.getDatumRodjenja());
        currentUser.setLozinka(kupac.getLozinka());
        currentUser.setKorisnickoIme(kupac.getKorisnickoIme());
        currentUser.setPol(kupac.getPol());

        kupacService.updateKupac(currentUser);
        return new ResponseEntity<Kupac>(currentUser, HttpStatus.OK);
    }

    @GetMapping("/api/kupac/porudzbine")
    public ResponseEntity<Set<Porudzbina>> getPorudzbine(HttpSession session){
        Kupac loggedKupac = (Kupac) session.getAttribute("korisnik");
        if (loggedKupac == null) {
            return new ResponseEntity("Niste ulogovani.", HttpStatus.UNAUTHORIZED);
        }
        Set<Porudzbina> artikli = loggedKupac.getPorudzbina();
        return ResponseEntity.ok(artikli);
    }

    @PostMapping("/api/kipac/porudzbine/ostavi-komentar")
    public ResponseEntity<String> ostaviKomentar(@RequestBody KomentarDto komentarDto, HttpSession session){
        Kupac loggedKupac = (Kupac) session.getAttribute("korisnik");
        if(komentarDto.getTekst().isEmpty() || komentarDto.getOcena()==0)
            return new ResponseEntity("Nisu uneti neophodni podaci.", HttpStatus.BAD_REQUEST);
        Komentar newKomentar = komentarService.response(komentarDto, loggedKupac);

        session.setAttribute("created", newKomentar);
        return ResponseEntity.ok("Hvala na odgovoru.");
    }

}
