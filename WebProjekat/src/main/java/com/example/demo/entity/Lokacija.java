package com.example.demo.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Lokacija implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private double duzina; //DONE double

    @Column
    private double sirina; //DONE double

    @Column
    private String adresa;

    /*@OneToOne
    @JoinColumn(name = "restoran_id")
    private Restoran restoran;

    public Restoran getArtikliRestoran() {
        return restoran;
    }*/

    public Lokacija(Long id, double duzina, double sirina, String adresa) {
        this.id = id;
        this.duzina = duzina;
        this.sirina = sirina;
        this.adresa = adresa;
    }

    public Lokacija() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public double getDuzina() {
        return duzina;
    }

    public void setDuzina(Long duzina) {
        this.duzina = duzina;
    }

    public double getSirina() {
        return sirina;
    }

    public void setSirina(Long sirina) {
        this.sirina = sirina;
    }

    public String getAdresa() {
        return adresa;
    }

    public void setAdresa(String adresa) {
        this.adresa = adresa;
    }

    @Override
    public String toString() {
        return "Lokacija{" +
                "id=" + id +
                ", duzina=" + duzina +
                ", sirina=" + sirina +
                ", adresa='" + adresa + '\'' +
                '}';
    }
}

