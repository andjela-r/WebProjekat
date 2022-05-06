package com.example.demo.entity;

import org.hibernate.annotations.GenericGenerator;
import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
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

    /*@ManyToMany(mappedBy = "porudzbina")
    private Set<Artikli> artikli = new HashSet<>();*/

    @OneToMany (cascade = CascadeType.ALL)
    @JoinColumn(name = "stavka_id")
    private Set<StavkaPorudzbine> stavka = new HashSet<>();

    @ManyToOne //Done many to one
    private Restoran restoran;

    @ManyToOne
    @JoinColumn(name = "dostavljac_id")
    private Dostavljac dostavljac;

    @Column
    private Date datum;

    @Column
    private double cena;

    @Column
    private STATUS status;

    @ManyToOne
    private Kupac kupac;

    public Dostavljac getDostavljac() {
        return dostavljac;
    }

    public Kupac getKupac() {
        return kupac;
    }

    public Porudzbina() {
    }

    public Porudzbina(UUID id, Set<StavkaPorudzbine> stavka, Restoran restoran, Dostavljac dostavljac, Date datum, double cena, STATUS status, Kupac kupac) {
        this.id = id;
        this.stavka = stavka;
        this.restoran = restoran;
        this.dostavljac = dostavljac;
        this.datum = datum;
        this.cena = cena;
        this.status = status;
        this.kupac = kupac;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public Set<StavkaPorudzbine> getStavka() {
        return stavka;
    }

    public void setStavka(Set<StavkaPorudzbine> stavka) {
        this.stavka = stavka;
    }

    public Restoran getRestoran() {
        return restoran;
    }

    public void setRestoran(Restoran restoran) {
        this.restoran = restoran;
    }

    public void setDostavljac(Dostavljac dostavljac) {
        this.dostavljac = dostavljac;
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

    public void setKupac(Kupac kupac) {
        this.kupac = kupac;
    }

    @Override
    public String toString() {
        return "Porudzbina{" +
                "id=" + id +
                ", stavka=" + stavka +
                ", restoran=" + restoran +
                ", dostavljac=" + dostavljac +
                ", datum=" + datum +
                ", cena=" + cena +
                ", status=" + status +
                ", kupac=" + kupac +
                '}';
    }
}

