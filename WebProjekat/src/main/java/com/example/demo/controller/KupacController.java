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



}
