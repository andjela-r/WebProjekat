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
    private Komentar komentar;

    @Column
    private int brojBodova;

    @ManyToOne(cascade = CascadeType.ALL)
    private TipKupca tipKupca;

    //TODO VEZA

    public Kupac() {
    }

    public Kupac(Long id, String korisnicko_ime, String lozinka, String ime, String prezime, Date datumRodjenja, Pol pol, Uloga uloga, Set<Porudzbina> porudzbina, Komentar komentar, int brojBodova, TipKupca tipKupca) {
        super(id, korisnicko_ime, lozinka, ime, prezime, datumRodjenja, pol, uloga);
        this.porudzbina = porudzbina;
        this.komentar = komentar;
        this.brojBodova = brojBodova;
        this.tipKupca = tipKupca;
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

    public void setKomentar(Komentar komentar) {
        this.komentar = komentar;
    }

    public void setTipKupca(TipKupca tipKupca) {
        this.tipKupca = tipKupca;
    }

    public TipKupca getTipKupca() {
        return tipKupca;
    }

    public Komentar getKomentar() {
        return komentar;
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
