package com.example.demo.controller;

import com.example.demo.entity.Korisnik;
import com.example.demo.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
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





}
