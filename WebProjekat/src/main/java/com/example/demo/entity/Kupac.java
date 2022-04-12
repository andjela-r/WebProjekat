package com.example.demo.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Set;

@Entity
public class Kupac extends Korisnik implements Serializable {

    @OneToMany
    @JoinColumn(name = "porudzbine_kupac_id")
    private Set<Porudzbina> porudzbine_kupac;

    /*@ManyToMany
    @JoinColumn(name = "p_id")
    private Porudzbina p;*/

    @OneToOne
    @JoinColumn(name = "komentar_id")
    private Komentar komentar;

    @Column
    private int broj_bodova;

    @ManyToOne
    @JoinColumn(name = "tip_kupca_id")

    @Column
    private TipKupca tip_kupca;

    //TODO VEZA

    public Kupac() {
    }

    public Kupac(Long id, String korisnicko_ime, String lozinka, String ime, String prezime, Date datum_rodjenja, String pol, Uloga uloga, Set<Porudzbina> porudzbine_kupac, int broj_bodova, TipKupca tip_kupca) {
        super(id, korisnicko_ime, lozinka, ime, prezime, datum_rodjenja, pol, uloga);
        this.porudzbine_kupac = porudzbine_kupac;
        this.broj_bodova = broj_bodova;
        this.tip_kupca = tip_kupca;
    }

    public int getBroj_bodova() {
        return broj_bodova;
    }

    public void setBroj_bodova(int broj_bodova) {
        this.broj_bodova = broj_bodova;
    }

    public Set<Porudzbina> getPorudzbine_kupac() {
        return porudzbine_kupac;
    }

    public void setPorudzbine_kupac(Set<Porudzbina> porudzbine_kupac) {
        this.porudzbine_kupac = porudzbine_kupac;
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

    //public Porudzbina getP() {
    //    return p;
    //}
}
