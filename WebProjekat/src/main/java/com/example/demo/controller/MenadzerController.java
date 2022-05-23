package com.example.demo.controller;

import com.example.demo.dto.MenadzerDto;
import com.example.demo.entity.Menadzer;
import com.example.demo.service.MenadzerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

@RestController
public class MenadzerController {
    @Autowired
    private MenadzerService menadzerService;

    @PostMapping("/api/add-menadzer")
    public ResponseEntity<String> addMenadzer (@RequestBody MenadzerDto menadzerDto, HttpSession session){

        if(menadzerDto.getUsername().isEmpty() || menadzerDto.getPassword().isEmpty()
                || menadzerDto.getIme().isEmpty() || menadzerDto.getPrezime().isEmpty()
                || menadzerDto.getDatumRodjenja().toString().isEmpty() || menadzerDto.getPol().toString().isEmpty()
                || menadzerDto.getIdRestoran().toString().isEmpty())
            return new ResponseEntity("Nisu uneti neophodni podaci.", HttpStatus.BAD_REQUEST);

        Menadzer newMenadzer = menadzerService.createMenadzer(menadzerDto);
        if(newMenadzer == null){
            return new ResponseEntity("Proverite korisnicko ime i restoran, nesto nije bas dobro :'(", HttpStatus.I_AM_A_TEAPOT);
            //kako resiti?
        }

        session.setAttribute("korisnik", newMenadzer);
        return ResponseEntity.ok("Uspesno kreiran nalog za menadzera!");
    }
}
