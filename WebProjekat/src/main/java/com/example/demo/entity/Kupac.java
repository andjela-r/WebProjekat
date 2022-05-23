package com.example.demo.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Kupac extends Korisnik implements Serializable {


    @OneToMany(mappedBy = "kupac", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Porudzbina> porudzbina = new HashSet<>();

    @OneToMany (cascade = CascadeType.ALL) //DONE relation = one to many
    @JoinColumn(name = "komentar_id")
    private Set<Komentar> komentar = new HashSet<>();

    @Column
    private int brojBodova;

    @ManyToOne(cascade = CascadeType.ALL)
    private TipKupca tipKupca;

    //TODO VEZA

    public Kupac() {
    }

    public Kupac(String korisnickoIme, String lozinka, String ime, String prezime, Date datumRodjenja, Pol pol, Uloga uloga) {
        super(korisnickoIme, lozinka, ime, prezime, datumRodjenja, pol, uloga);
    }

    public int getBrojBodova() {
        return brojBodova;
    }

    public void setBrojBodova(int brojBodova) {
        this.brojBodova = brojBodova;
    }

    public Set<Porudzbina> getPorudzbina() {
        return porudzbina;
    }

    public void setPorudzbina(Set<Porudzbina> porudzbina) {
        this.porudzbina = porudzbina;
    }

    public void setTipKupca(TipKupca tipKupca) {
        this.tipKupca = tipKupca;
    }

    public TipKupca getTipKupca() {
        return tipKupca;
    }

    public Set<Komentar> getKomentar() {
        return komentar;
    }

    public void setKomentar(Set<Komentar> komentar) {
        this.komentar = komentar;
    }

    @Override
    public String toString() {
        return "Kupac{" + super.toString() +
                "porudzbina=" + porudzbina +
                ", komentar=" + komentar +
                ", broj_bodova=" + brojBodova +
                ", tip_kupca=" + tipKupca +
                '}';
    }
}
