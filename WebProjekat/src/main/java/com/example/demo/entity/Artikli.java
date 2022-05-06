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
    private TIP tip; //DONE enum

    @Column
    private double kolicina; //DONE double

    @Column
    private String opis;

//    @ManyToMany //ne treba ova relacija
//    @JoinTable(name = "imaRestoran",
//            joinColumns = @JoinColumn(name = "artikli_id", referencedColumnName = "id"),
//            inverseJoinColumns = @JoinColumn(name = "restoran_id", referencedColumnName = "id"))
//    private Set<Restoran> restoran = new HashSet<>();
//
//    @ManyToMany(mappedBy = "artikli") //klasa
//    private Set<Porudzbina> porudzbina = new HashSet<>();

    public Artikli(Long id, String naziv, double cena, TIP tip, double kolicina, String opis) {
        this.id = id;
        this.naziv = naziv;
        this.cena = cena;
        this.tip = tip;
        this.kolicina = kolicina;
        this.opis = opis;
    }

    public Artikli() {
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

    public TIP getTip() { return tip; }

    public void setTip(TIP tip) { this.tip = tip; }

    public double getKolicina() { return kolicina; }

    public void setKolicina(double kolicina) { this.kolicina = kolicina; }

    public String getOpis() {
        return opis;
    }

    public void setOpis(String opis) {
        this.opis = opis;
    }

    @Override
    public String toString() {
        return "Artikli{" +
                "id=" + id +
                ", naziv='" + naziv + '\'' +
                ", cena=" + cena +
                ", tip='" + tip + '\'' +
                ", kolicina=" + kolicina +
                ", opis='" + opis + '\'' +
                '}';
    }
}