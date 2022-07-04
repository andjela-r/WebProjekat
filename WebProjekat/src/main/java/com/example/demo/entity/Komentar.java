package com.example.demo.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Komentar implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne //DONE many to one
    private Kupac kupac;

    @ManyToOne //DONE many to one
    private Restoran restoran;

    @Column
    private String tekst;

    @Column
    private int ocena;

    public Komentar(String tekst, int ocena) {
    }

    public com.example.demo.entity.Kupac getK() {
        return kupac;
    }

    public Komentar() {
    }

    public Komentar(Kupac kupac, Restoran restoran, String tekst, int ocena) {
        this.kupac = kupac;
        this.restoran = restoran;
        this.tekst = tekst;
        this.ocena = ocena;
    }

    public void setK(Kupac k) {
        this.kupac = kupac;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Kupac getKupac() {
        return kupac;
    }
    public void setKupac(Kupac kupac) {
        this.kupac = kupac;
    }

    public Restoran getRestoran() {
        return restoran;
    }

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

    @Override
    public String toString() {
        return "Komentar{" +
                "id=" + id +
                ", k=" + kupac +
                ", restoran=" + restoran +
                ", tekst='" + tekst + '\'' +
                ", ocena=" + ocena +
                '}';
    }
}
