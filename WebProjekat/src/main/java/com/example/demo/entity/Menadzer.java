package com.example.demo.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
public class Menadzer extends Korisnik implements Serializable {


    @OneToOne
    private Restoran restoran;

    public Menadzer() {
    }

    public Menadzer(Long id, String korisnicko_ime, String lozinka, String ime, String prezime, Date datum_rodjenja, String pol, Uloga uloga, Restoran restoran) {
        super(id, korisnicko_ime, lozinka, ime, prezime, datum_rodjenja, pol, uloga);
        this.restoran = restoran;
    }

    public Restoran getRestoran() {
        return restoran;
    }

    public void setRestoran(Restoran restoran) {
        this.restoran = restoran;
    }
}
