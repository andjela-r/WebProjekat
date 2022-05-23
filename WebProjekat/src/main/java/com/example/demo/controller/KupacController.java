package com.example.demo.controller;

import com.example.demo.dto.LoginDto;
import com.example.demo.dto.RegisterDto;
import com.example.demo.entity.Korisnik;
import com.example.demo.entity.Kupac;
import com.example.demo.service.KupacService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import javax.servlet.http.HttpSession;
import java.util.List;

public class KupacController {

    @Autowired
    private KupacService kupacService;

    @GetMapping("/api/kupci")
    public ResponseEntity<List<Kupac>> getAll(HttpSession session){
        return ResponseEntity.ok(kupacService.findAll());
    }

    @GetMapping("/api/kupac/{id}")
    public ResponseEntity<Kupac> getById(@PathVariable(name = "id") Long id, HttpSession session){
        return ResponseEntity.ok(kupacService.getById(id));
    }

    @PostMapping("/api/login")
    public ResponseEntity<String> login (@RequestBody LoginDto loginDto, HttpSession session){
        // proverimo da li su podaci validni
        if(loginDto.getUsername().isEmpty() || loginDto.getPassword().isEmpty())
            return new ResponseEntity("Lose uneti kredencijali.", HttpStatus.BAD_REQUEST);

        Korisnik loggedKupac = kupacService.login(loginDto.getUsername(), loginDto.getPassword());
        if (loggedKupac == null)
            return new ResponseEntity<>("Kupac ne postoji!", HttpStatus.NOT_FOUND);

        session.setAttribute("kupac", loggedKupac);
        return ResponseEntity.ok("Uspesno logovanje!");
    }

    @PostMapping("/api/register")
    public ResponseEntity<String> register (@RequestBody RegisterDto registerDto, HttpSession session){

        if(registerDto.getUsername().isEmpty() || registerDto.getPassword().isEmpty()
                || registerDto.getIme().isEmpty() || registerDto.getPrezime().isEmpty())
            return new ResponseEntity("Nisu uneti neophodni podaci.", HttpStatus.BAD_REQUEST);

        if(kupacService.postoji(registerDto.getUsername())){
            return new ResponseEntity<>("Kupac ime je zauzeto!", HttpStatus.BAD_REQUEST);
        }

        Kupac newKupac = kupacService.register(
                registerDto.getUsername(),
                registerDto.getPassword(),
                registerDto.getIme(),
                registerDto.getPrezime(),
                registerDto.getDatumRodjenja(),
                registerDto.getPol()
        );

        session.setAttribute("korisnik", newKupac);
        kupacService.save(newKupac);
        return ResponseEntity.ok("Uspesno kreiran nalog!");
    }

    @PostMapping("api/logout")
    public ResponseEntity Logout(HttpSession session){
        Kupac loggedKupac = (Kupac) session.getAttribute("kupac");

        if (loggedKupac == null)
            return new ResponseEntity("Forbidden", HttpStatus.FORBIDDEN);

        session.invalidate();
        return new ResponseEntity("Uspesno ste izlogovani!", HttpStatus.OK);
    }

}
