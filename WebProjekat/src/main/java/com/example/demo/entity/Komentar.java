package com.example.demo.entity;

import vezbe.demo.model.Restoran;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Komentar implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

   //FIXME private Kupac kupac;

    @OneToOne
    @JoinColumn(name = "restoran_id")
    private vezbe.demo.model.Restoran restoran;

    public Restoran getRestoran() {
        return restoran;
    }

    private String tekst;

    private int ocena;

    public Long getId() {
        return id;
    }

    public Komentar() {
    }

    public Komentar(Long id, Restoran restoran, String tekst, int ocena) {
        this.id = id;
        this.restoran = restoran;
        this.tekst = tekst;
        this.ocena = ocena;
    }

    public void setId(Long id) {
        this.id = id;
    }
    //FIXME
    // - public Kupac getKupac() {
    //    return kupac;
    // }
    // - public void setKupac(Kupac kupac) {
   //     this.kupac = kupac; }

    public void setRestoran(Restoran restoran) {
        this.restoran = restoran;
    }

    public String getTekst() {
        return tekst;
    }

    public void setTekst(String tekst) {
        this.tekst = tekst;
    }

    public int getOcena() {
        return ocena;
    }

    public void setOcena(int ocena) {
        this.ocena = ocena;
    }
}
