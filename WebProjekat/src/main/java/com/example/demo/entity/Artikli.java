package com.example.demo.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Artikli implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String naziv;

    @Column
    private double cena;

    @Column
    private String tip;

    @Column
    private int kolicina;

    @Column
    private String opis;

    @ManyToMany
    @JoinTable(name = "imaRestoran",
            joinColumns = @JoinColumn(name = "artikli_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "restoran_id", referencedColumnName = "id"))
    private Set<Restoran> restoran = new HashSet<>();

    @ManyToMany(mappedBy = "artikli")
    private Set<Porudzbina> porudzbina = new HashSet<>();

    public Artikli(Long id, String naziv, double cena, String tip, int kolicina, String opis, Set<Restoran> restoran) {
        this.id = id;
        this.naziv = naziv;
        this.cena = cena;
        this.tip = tip;
        this.kolicina = kolicina;
        this.opis = opis;
        this.restoran = restoran;
    }

    public Artikli() {
    }

    public Set<Restoran> getRestoran() {
        return restoran;
    }

    public void setRestoran(Set<Restoran> restoran) {
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

    public double getCena() {
        return cena;
    }

    public void setCena(double cena) {
        this.cena = cena;
    }

    public String getTip() {
        return tip;
    }

    public void setTip(String tip) {
        this.tip = tip;
    }

    public int getKolicina() {
        return kolicina;
    }

    public void setKolicina(int kolicina) {
        this.kolicina = kolicina;
    }

    public String getOpis() {
        return opis;
    }

    public void setOpis(String opis) {
        this.opis = opis;
    }

}