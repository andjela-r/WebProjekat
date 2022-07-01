package com.example.demo.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
public class Menadzer extends Korisnik implements Serializable {


    @OneToOne
    private Restoran restoran;

    public Menadzer(){}

    public Menadzer(String jole, String s, String jovan, String jovic, Date date, Pol muski, Uloga menadzer) {
        super(jole,s,jovan,jovic,date,muski,menadzer);
    }

    public Menadzer(String korisnickoIme, String lozinka, String ime, String prezime, Date datumRodjenja, Pol pol, Uloga uloga, Restoran restoran) {
        super(korisnickoIme, lozinka, ime, prezime, datumRodjenja, pol, uloga);
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
