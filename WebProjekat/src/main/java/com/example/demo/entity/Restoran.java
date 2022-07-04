package com.example.demo.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Restoran implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String naziv;

    @Column
    private String tip;

    @OneToOne
    @JoinColumn(name = "lokacija_id")
    private Lokacija lokacija;


    //@JsonIgnore
    @OneToMany (fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)// DONE one to many
    private Set<Artikli> artikliRestoran = new HashSet<>(); //artikli treba da budu

    @Column
    private boolean radi;

    @Column
    private double ocena;


    public Lokacija getLokacija() {
        return lokacija;
    }

    public Restoran() {
    }

    public Restoran(String naziv, String tip, Lokacija lokacija, Set<Artikli> artikliRestoran) {
        this.naziv = naziv;
        this.tip = tip;
        this.lokacija = lokacija;
        this.artikliRestoran = artikliRestoran;
    }

    public Restoran(String naziv, String tip, Lokacija lokacija) {
        this.naziv = naziv;
        this.tip = tip;
        this.lokacija = lokacija;
    }

    public boolean isRadi() {
        return radi;
    }

    public void setRadi(boolean radi) {
        this.radi = radi;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public String getTip() {
        return tip;
    }

    public void setTip(String tip) {
        this.tip = tip;
    }

    public double getOcena() {
        return ocena;
    }

    public void setOcena(double ocena) {
        this.ocena = ocena;
    }

    public void setLokacija(com.example.demo.entity.Lokacija lokacija) {
        this.lokacija = lokacija;
    }

    public Set<Artikli> getArtikliRestoran() {
        return artikliRestoran;
    }

    public void setArtikliRestoran(Set<Artikli> artikliRestoran) {
        this.artikliRestoran = artikliRestoran;
    }

    @Override
    public String toString() {
        return "Restoran{" +
                "id=" + id +
                ", naziv='" + naziv + '\'' +
                ", tip='" + tip + '\'' +
                ", lokacija=" + lokacija +
                ", restoran=" + artikliRestoran +
                ", porudzbina=" +                           // porudzbine +
                '}';
    }
}

