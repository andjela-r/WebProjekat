package com.example.demo.entity;

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
    @JoinColumn(name = "restoran_id")
    private Lokacija restoran;

    @OneToOne
    @JoinColumn(name = "artikli_id")
    private Artikli artikli;

    public Restoran() {
    }

    public Restoran(Long id, String naziv, String tip, Lokacija restoran) {
        this.id = id;
        this.naziv = naziv;
        this.tip = tip;
        this.restoran = restoran;
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

    public Lokacija getRestoran() {
        return restoran;
    }

    public void setRestoran(Lokacija restoran) {
        this.restoran = restoran;
    }

}

