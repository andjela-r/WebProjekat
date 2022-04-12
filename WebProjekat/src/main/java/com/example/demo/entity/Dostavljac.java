package com.example.demo.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Set;

@Entity
public class Dostavljac extends Korisnik implements Serializable {

    @OneToMany(fetch = FetchType.LAZY) //Unidirekciona veza, Dostavljac "vidi" Porudzbina, Porudzbina "ne vidi" Dostavljac
    private Set<Porudzbina> porudzbina_dostavljac;


    public Dostavljac() {
    }

    public Dostavljac(Long id, String korisnicko_ime, String lozinka, String ime, String prezime, Date datum_rodjenja, String pol, Uloga uloga, Set<Porudzbina> porudzbina_dostavljac) {
        super(id, korisnicko_ime, lozinka, ime, prezime, datum_rodjenja, pol, uloga);
        this.porudzbina_dostavljac = porudzbina_dostavljac;
    }

    public Set<Porudzbina> getPorudzbina_dostavljac() {
        return porudzbina_dostavljac;
    }

    public void setPorudzbina_dostavljac(Set<Porudzbina> porudzbina_dostavljac) {
        this.porudzbina_dostavljac = porudzbina_dostavljac;
    }
}
