package com.example.demo.controller;

import com.example.demo.dto.LoginDto;
import com.example.demo.dto.RegisterDto;
import com.example.demo.entity.Korisnik;
import com.example.demo.entity.Kupac;
import com.example.demo.service.KupacService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
public class KupacController {

    @Autowired
    private KupacService kupacService;

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

}
