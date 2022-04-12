package com.example.demo.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.UUID;

enum STATUS{
    OBRADA,
    PRIPREMA,
    CEKA_DOSTAVLJACA,
    TRANSPORT,
    DOSTAVLJENO,
    OTKAZANO
}

@Entity
public class Porudzbina implements Serializable {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator (
        name = "UUID",
        strategy = "org.hibernate.id.UUIDGenerator"
    )
    private UUID id;

    @ManyToMany
    @JoinColumn(name = "artikli_id")
    private Artikli artikli;

    @ManyToMany
    @JoinColumn(name = "restoran_id")
    private Restoran restoran;

    @Column
    private Date datum;

    @Column
    private double cena;

    @Column
    private STATUS status;

    @ManyToOne
    @JoinColumn(name = "kupac_id")
    private Kupac kupac;

    public Porudzbina(UUID id, Artikli artikli, Restoran restoran, Date datum, double cena, STATUS status, Kupac kupac) {
        this.id = id;
        this.artikli = artikli;
        this.restoran = restoran;
        this.datum = datum;
        this.cena = cena;
        this.status = status;
        this.kupac = kupac;
    }

    public Porudzbina() {
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public Artikli getArtikli() {
        return artikli;
    }

    public void setArtikli(Artikli artikli) {
        this.artikli = artikli;
    }

    public Restoran getRestoran() {
        return restoran;
    }

    public void setRestoran(Restoran restoran) {
        this.restoran = restoran;
    }

    public Date getDatum() {
        return datum;
    }

    public void setDatum(Date datum) {
        this.datum = datum;
    }

    public double getCena() {
        return cena;
    }

    public void setCena(double cena) {
        this.cena = cena;
    }

    public STATUS getStatus() {
        return status;
    }

    public void setStatus(STATUS status) {
        this.status = status;
    }

    public Kupac getKupac() {
        return kupac;
    }

    public void setKupac(Kupac kupac) {
        this.kupac = kupac;
    }
}
