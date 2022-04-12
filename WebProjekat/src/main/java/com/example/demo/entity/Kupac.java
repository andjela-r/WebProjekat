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

    @OneToOne
    @JoinColumn(name = "komentar_id")
    private Komentar komentar;

    @Column
    private int broj_bodova;

    @ManyToOne
    @JoinColumn(name = "tip_kupca_id")
    private TipKupca tip_kupca;

    //TODO VEZA

    public Kupac() {
    }

    public Kupac(Long id, String korisnicko_ime, String lozinka, String ime, String prezime, Date datum_rodjenja, String pol, Uloga uloga, Set<Porudzbina> porudzbina, Komentar komentar, int broj_bodova, TipKupca tip_kupca) {
        super(id, korisnicko_ime, lozinka, ime, prezime, datum_rodjenja, pol, uloga);
        this.porudzbina = porudzbina;
        this.komentar = komentar;
        this.broj_bodova = broj_bodova;
        this.tip_kupca = tip_kupca;
    }

    public int getBroj_bodova() {
        return broj_bodova;
    }

    public void setBroj_bodova(int broj_bodova) {
        this.broj_bodova = broj_bodova;
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

    public void setTip_kupca(TipKupca tip_kupca) {
        this.tip_kupca = tip_kupca;
    }

    public TipKupca getTip_kupca() {
        return tip_kupca;
    }

    public Komentar getKomentar() {
        return komentar;
    }

    @Override
    public String toString() {
        return "Kupac{" +
                "porudzbina=" + porudzbina +
                ", komentar=" + komentar +
                ", broj_bodova=" + broj_bodova +
                ", tip_kupca=" + tip_kupca +
                '}';
    }
}
