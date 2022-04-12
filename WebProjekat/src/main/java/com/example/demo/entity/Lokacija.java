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
    private Long duzina;

    @Column
    private Long sirina;

    @Column
    private String adresa;

    @OneToOne
    @JoinColumn(name = "restoran_id")
    private Restoran restoran;

    public Restoran getRestoran() {
        return restoran;
    }

    public Lokacija(Long id, Long duzina, Long sirina, String adresa) {
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

    public Long getDuzina() {
        return duzina;
    }

    public void setDuzina(Long duzina) {
        this.duzina = duzina;
    }

    public Long getSirina() {
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
}
