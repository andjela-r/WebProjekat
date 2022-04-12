package com.example.demo.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
public class Kupac extends Korisnik implements Serializable {

    @ManyToMany
    @JoinColumn(name = "p_id")
    private Porudzbina p;

    @OneToOne
    @JoinColumn(name = "komentar_id")
    private Komentar komentar;

    @Column
    private int broj_bodova;


    @Column
    private TipKupca tip_kupca;

    public Komentar getKomentar() {
        return komentar;
    }

    public Porudzbina getP() {
        return p;
    }

    //TODO VEZA

    public Kupac() {
    }

    public Kupac(Long id, String korisnicko_ime, String lozinka, String ime, String prezime, Date datum_rodjenja, String pol, Uloga uloga, int broj_bodova, TipKupca tip_kupca) {
        super(id, korisnicko_ime, lozinka, ime, prezime, datum_rodjenja, pol, uloga);
        this.broj_bodova = broj_bodova;
        this.tip_kupca = tip_kupca;
    }

    public int getBroj_bodova() {
        return broj_bodova;
    }

    public void setBroj_bodova(int broj_bodova) {
        this.broj_bodova = broj_bodova;
    }

    //TODO geteri i seteri
}
