package com.example.demo.dto;

import com.example.demo.entity.Pol;
import com.example.demo.entity.Restoran;

import java.sql.Date;

public class MenadzerDto {
    private String ime;
    private String prezime;
    private String username;
    private String password;
    private Date datumRodjenja;
    private Pol pol;
    private Restoran restoran;

    public MenadzerDto(String ime, String prezime, String username, String password, Date datumRodjenja, Pol pol, Restoran restoran) {
        this.ime = ime;
        this.prezime = prezime;
        this.username = username;
        this.password = password;
        this.datumRodjenja = datumRodjenja;
        this.pol = pol;
        this.restoran = restoran;
    }

    public MenadzerDto() {
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

    public Date getDatumRodjenja() {
        return datumRodjenja;
    }

    public void setDatumRodjenja(Date datumRodjenja) {
        this.datumRodjenja = datumRodjenja;
    }

    public Pol getPol() {
        return pol;
    }

    public void setPol(Pol pol) {
        this.pol = pol;
    }

    public Restoran getRestoran() {
        return restoran;
    }

    public void setRestoran(Restoran restoran) {
        this.restoran = restoran;
    }
}

