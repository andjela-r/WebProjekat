package com.example.demo.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
public class Dostavljac extends Korisnik implements Serializable {

    //FIXME @Column
    // private Set<Porudzbina> porudzbine_dostavljac;

    //TODO VEZA

    public Dostavljac() {
    }

    //FIXME dodati polje porudzbine_dostavljac
    public Dostavljac(Long id, String korisnicko_ime, String lozinka, String ime, String prezime, Date datum_rodjenja, String pol, Uloga uloga) {
        super(id, korisnicko_ime, lozinka, ime, prezime, datum_rodjenja, pol, uloga);
    }

    //TODO geteri i seteri
}
