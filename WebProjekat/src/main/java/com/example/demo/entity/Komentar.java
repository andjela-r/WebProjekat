package com.example.demo.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Komentar implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "porudzbine_kupac_id")
    private Kupac k;

    @OneToOne
    @JoinColumn(name = "restoran_id")
    private Restoran restoran;

    @Column
    private String tekst;

    @Column
    private int ocena;

    public com.example.demo.entity.Kupac getK() {
        return k;
    }

    public Komentar() {
    }

    public Komentar(Long id, Kupac k, Restoran restoran, String tekst, int ocena) {
        this.id = id;
        this.k = k;
        this.restoran = restoran;
        this.tekst = tekst;
        this.ocena = ocena;
    }

    public void setK(Kupac k) {
        this.k = k;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Kupac getKupac() {
        return k;
    }
    public void setKupac(Kupac kupac) {
        this.k = kupac;
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
                ", k=" + k +
                ", restoran=" + restoran +
                ", tekst='" + tekst + '\'' +
                ", ocena=" + ocena +
                '}';
    }
}
