package com.example.demo.dto;

import com.example.demo.entity.Korisnik;
import com.example.demo.entity.Pol;
import com.example.demo.entity.Uloga;

import java.sql.Date;
import java.time.Instant;

public class RegisterDto {

    private String ime;
    private String prezime;
    private String username;
    private String password;

    public RegisterDto() {
    }

    public RegisterDto(String ime, String prezime, String username, String password) {
        this.ime = ime;
        this.prezime = prezime;
        this.username = username;
        this.password = password;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

//    public Korisnik toKorisnik(){
//        Korisnik korisnik = new Korisnik(
//                0L,
//                this.username,
//                this.password,
//                this.ime,
//                this.prezime,
//                Date.from(Instant.now()),
//                Pol.Muski,
//                Uloga.KUPAC
//        );
//        return korisnik;
//    }
}
