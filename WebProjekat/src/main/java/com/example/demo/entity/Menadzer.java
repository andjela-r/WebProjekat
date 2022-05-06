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

    public Menadzer(Long id, String korisnickoIme, String lozinka, String ime, String prezime, Date datumRodjenja, Pol pol, Uloga uloga, Restoran restoran) {
        super(id, korisnickoIme, lozinka, ime, prezime, datumRodjenja, pol, uloga);
        this.restoran = restoran;
    }

    public Restoran getRestoran() {
        return restoran;
    }

    public void setRestoran(Restoran restoran) {
        this.restoran = restoran;
    }

    @Override
    public String toString() {
        return "Menadzer{" + super.toString()+
                "restoran=" + restoran +
                '}';
    }
}
