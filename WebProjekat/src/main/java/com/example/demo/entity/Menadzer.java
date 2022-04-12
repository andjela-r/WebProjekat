package com.example.demo.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class Menadzer extends Korisnik implements Serializable {

    //FIXME @Column
    // private Restoran restoran;

    //TODO VEZA

    //FIXME
    // - ubaciti polje restoran

    public Menadzer() {
    }

    public Menadzer(Long id, String korisnicko_ime, String lozinka, String ime, String prezime, Date datum_rodjenja, String pol, Uloga uloga) {
        super(id, korisnicko_ime, lozinka, ime, prezime, datum_rodjenja, pol, uloga);
    }

    //TODO geteri i seteri
}
