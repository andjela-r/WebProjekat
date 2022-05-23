package com.example.demo.controller;

import com.example.demo.dto.LoginDto;
import com.example.demo.dto.MenadzerDto;
import com.example.demo.dto.RegisterDto;
import com.example.demo.entity.Dostavljac;
import com.example.demo.entity.Korisnik;
import com.example.demo.entity.Menadzer;
import com.example.demo.service.KorisnikService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
public class KorisnikController {
    @Autowired
    private KorisnikService korisnikService;

    @GetMapping("/api/korisnici")
    public ResponseEntity<List<Korisnik>> getAll(HttpSession session){
        return ResponseEntity.ok(korisnikService.findAll());
    }

    @GetMapping("/api/korisnik/{id}")
    public ResponseEntity<Korisnik> getById(@PathVariable(name = "id") Long id, HttpSession session){
        return ResponseEntity.ok(korisnikService.getById(id));
    }

    @PostMapping("/api/login")
    public ResponseEntity<String> login (@RequestBody LoginDto loginDto, HttpSession session){
        // proverimo da li su podaci validni
        if(loginDto.getUsername().isEmpty() || loginDto.getPassword().isEmpty())
            return new ResponseEntity("Lose uneti kredencijali.", HttpStatus.BAD_REQUEST);

        Korisnik loggedKorisnik = korisnikService.login(loginDto.getUsername(), loginDto.getPassword());
        if (loggedKorisnik == null)
            return new ResponseEntity<>("Korisnik ne postoji!", HttpStatus.NOT_FOUND);

        session.setAttribute("korisnik", loggedKorisnik);
        return ResponseEntity.ok("Uspesno logovanje!");
    }
//
//    @PostMapping("/api/register")
//    public ResponseEntity<String> register (@RequestBody RegisterDto registerDto, HttpSession session){
//
//        if(registerDto.getUsername().isEmpty() || registerDto.getPassword().isEmpty()
//                || registerDto.getIme().isEmpty() || registerDto.getPrezime().isEmpty())
//            return new ResponseEntity("Nisu uneti neophodni podaci.", HttpStatus.BAD_REQUEST);
//
//        if(korisnikService.postoji(registerDto.getUsername())){
//            return new ResponseEntity<>("Korisnicko ime je zauzeto!", HttpStatus.BAD_REQUEST);
//      }
//
//        Korisnik newKorisnik = korisnikService.register(
//                registerDto.getUsername(),
//                registerDto.getPassword(),
//                registerDto.getIme(),
//                registerDto.getPrezime(),
//                registerDto.getDatumRodjenja(),
//                registerDto.getPol()
//        );
//
//        session.setAttribute("korisnik", newKorisnik);
//        korisnikService.save(newKorisnik);
//        return ResponseEntity.ok("Uspesno kreiran nalog!");
//    }
//
//    @PostMapping("/api/add-menadzer")
//    public ResponseEntity<String> addMenadzer (@RequestBody MenadzerDto menadzerDto, HttpSession session){
//
//        if(menadzerDto.getUsername().isEmpty() || menadzerDto.getPassword().isEmpty()
//                || menadzerDto.getIme().isEmpty() || menadzerDto.getPrezime().isEmpty())
//            return new ResponseEntity("Nisu uneti neophodni podaci.", HttpStatus.BAD_REQUEST);
//
//        if(korisnikService.postoji(menadzerDto.getUsername())){
//            return new ResponseEntity<>("Korisnicko ime je zauzeto!", HttpStatus.BAD_REQUEST);
//        }
//
//        Menadzer newMenadzer = korisnikService.createMenadzer(
//                menadzerDto.getUsername(),
//                menadzerDto.getPassword(),
//                menadzerDto.getIme(),
//                menadzerDto.getPrezime(),
//                menadzerDto.getDatumRodjenja(),
//                menadzerDto.getPol(),
//                menadzerDto.getRestoran()
//        );
//
//        session.setAttribute("korisnik", newMenadzer);
//        korisnikService.save(newMenadzer);
//        return ResponseEntity.ok("Uspesno kreiran nalog za menadzera!");
//    }
//
//    @PostMapping("/api/add-dostavljac")
//    public ResponseEntity<String> addDostavljac (@RequestBody RegisterDto registerDto, HttpSession session){
//
//        if(registerDto.getUsername().isEmpty() || registerDto.getPassword().isEmpty()
//                || registerDto.getIme().isEmpty() || registerDto.getPrezime().isEmpty())
//            return new ResponseEntity("Nisu uneti neophodni podaci.", HttpStatus.BAD_REQUEST);
//
//        if(korisnikService.postoji(registerDto.getUsername())){
//            return new ResponseEntity<>("Korisnicko ime je zauzeto!", HttpStatus.BAD_REQUEST);
//        }
//
//        Dostavljac newDostavljac = korisnikService.createDostavljac(
//                registerDto.getUsername(),
//                registerDto.getPassword(),
//                registerDto.getIme(),
//                registerDto.getPrezime(),
//                registerDto.getDatumRodjenja(),
//                registerDto.getPol()
//        );
//
//        session.setAttribute("korisnik", newDostavljac);
//        korisnikService.save(newDostavljac);
//        return ResponseEntity.ok("Uspesno kreiran nalog za menadzera!");
//    }
//
    @PostMapping("api/logout")
    public ResponseEntity Logout(HttpSession session){
        Korisnik loggedKorisnik = (Korisnik) session.getAttribute("korisnik");

        if (loggedKorisnik == null)
            return new ResponseEntity("Forbidden", HttpStatus.FORBIDDEN);

        session.invalidate();
        return new ResponseEntity("Uspesno ste izlogovani!", HttpStatus.OK);
    }
}
