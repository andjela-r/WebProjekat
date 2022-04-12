package com.example.demo.entity;

import org.springframework.data.web.config.EnableSpringDataWebSupport;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class TipKupca implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String ime;

    @Column
    private double popust;

    @Column
    private double trazeni_broj_bodova;

    //TODO VEZA


    public TipKupca() {
    }

    public TipKupca(Long id, String ime, double popust, double trazeni_broj_bodova) {
        this.id = id;
        this.ime = ime;
        this.popust = popust;
        this.trazeni_broj_bodova = trazeni_broj_bodova;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public double getPopust() {
        return popust;
    }

    public void setPopust(double popust) {
        this.popust = popust;
    }

    public double getTrazeni_broj_bodova() {
        return trazeni_broj_bodova;
    }

    public void setTrazeni_broj_bodova(double trazeni_broj_bodova) {
        this.trazeni_broj_bodova = trazeni_broj_bodova;
    }
}
