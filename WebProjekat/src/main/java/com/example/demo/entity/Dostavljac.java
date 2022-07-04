package com.example.demo.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Dostavljac extends Korisnik implements Serializable {

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.MERGE) //Unidirekciona veza, Dostavljac "vidi" Porudzbina, Porudzbina "ne vidi" Dostavljac
    private Set<Porudzbina> porudzbinaDostavljac = new HashSet<>();


    public Dostavljac() {
    }


    public Dostavljac(String korisnickoIme, String lozinka, String ime, String prezime, Date datumRodjenja, Pol pol, Uloga uloga) {
        super(korisnickoIme, lozinka, ime, prezime, datumRodjenja, pol, uloga);
        //this.porudzbinaDostavljac = porudzbinaDostavljac;
    }

    public Set<Porudzbina> getPorudzbinaDostavljac() {
        return porudzbinaDostavljac;
    }

    public void setPorudzbinaDostavljac(Set<Porudzbina> porudzbina_dostavljac) {
        this.porudzbinaDostavljac = porudzbina_dostavljac;
    }

    @Override
    public String toString() {
        return "Dostavljac{" + super.toString() +
                "porudzbina_dostavljac=" + porudzbinaDostavljac +
                '}';
    }
}
