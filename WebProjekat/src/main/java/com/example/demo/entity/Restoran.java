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
    @JoinColumn(name = "lokacija_id")
    private Lokacija lokacija;


    @OneToMany // DONE one to many
    private Set<Artikli> artikliRestoran = new HashSet<>(); //artikli treba da budu

//    @OneToMany //DONE one to many
//    private Set<Porudzbina> porudzbine = new HashSet<>();


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

