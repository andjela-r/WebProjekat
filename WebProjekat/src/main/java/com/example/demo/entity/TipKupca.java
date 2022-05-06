package com.example.demo.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.*;

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
    private double trazeniBrojBodova;

//    @OneToMany(mappedBy = "tipKupca", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
//    private Set<Kupac> kupac = new HashSet<>();

    public TipKupca() {
    }

    public TipKupca(Long id, String ime, double popust, double trazeniBrojBodova) {
        this.id = id;
        this.ime = ime;
        this.popust = popust;
        this.trazeniBrojBodova = trazeniBrojBodova;
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

    public double getTrazeniBrojBodova() {
        return trazeniBrojBodova;
    }

    public void setTrazeniBrojBodova(double trazeniBrojBodova) {
        this.trazeniBrojBodova = trazeniBrojBodova;
    }

    @Override
    public String toString() {
        return "TipKupca{" +
                "id=" + id +
                ", ime='" + ime + '\'' +
                ", popust=" + popust +
                ", trazeni_broj_bodova=" + trazeniBrojBodova +
                '}';
    }
}
