package com.example.demo.entity;

import org.hibernate.annotations.GenericGenerator;
import vezbe.demo.model.Artikli;
import vezbe.demo.model.Restoran;
import vezbe.demo.model.Kupac;

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
    private vezbe.demo.model.Artikli artikli;

    public Artikli getArtikli() {
        return artikli;
    }

    @ManyToMany
    @JoinColumn(name = "restoran_id")
    private vezbe.demo.model.Restoran restoran;

    public Restoran getRestoran() {
        return restoran;
    }

    @ManyToOne
    @JoinColumn(name = "dostavljac_id")
    private Dostavljac dostavljac;

    @Column
    private Date datum;

    @Column
    private double cena;

    @Column
    private STATUS status;

    @OneToOne
    @JoinColumn(name = "kupac_id")
    private Kupac kupac;

    public Dostavljac getDostavljac() {
        return dostavljac;
    }

    public Kupac getKupac() {
        return kupac;
    }

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

    public void setArtikli(Artikli artikli) {
        this.artikli = artikli;
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

}
