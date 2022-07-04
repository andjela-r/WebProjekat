package com.example.demo.controller;

import com.example.demo.dto.DostavljacDto;
import com.example.demo.entity.Dostavljac;
import com.example.demo.entity.Kupac;
import com.example.demo.entity.Porudzbina;
import com.example.demo.service.DostavljacService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.Set;

@RestController
public class DostavljacController {

    @Autowired
    private DostavljacService dostavljacService;

    @GetMapping("/api/dostavljac/porudzbine")
    public ResponseEntity<Set<Porudzbina>> mojePorudzbine(HttpSession session){
        Dostavljac loggedDostavljac = (Dostavljac) session.getAttribute("korisnik");
        if (loggedDostavljac == null) {
            return new ResponseEntity("Niste ulogovani.", HttpStatus.UNAUTHORIZED);
        }

        //Set<Porudzbina> cekaju = sve porudzbine sa STATUS.CEKA_DOSTAVLJACA TODO

        Set<Porudzbina> artikli = loggedDostavljac.getPorudzbinaDostavljac();
        return ResponseEntity.ok(artikli);
    }


}
