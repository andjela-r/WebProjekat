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

    @ManyToMany //TODO stavka porudbine(klasa) one to many, kolicina i artikal (many to one)
    @JoinTable(name = "imaArtikle",
            joinColumns = @JoinColumn(name = "porudzbina_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "artikli_id", referencedColumnName = "id"))
    private Set<Artikli> artikli = new HashSet<>();

    @ManyToMany //TODO many to one
    private Set<Restoran> restoran = new HashSet<>();

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

    public Porudzbina(UUID id, Set<Artikli> artikli, Set<Restoran> restoran, Dostavljac dostavljac, Date datum, double cena, STATUS status, Kupac kupac) {
        this.id = id;
        this.artikli = artikli;
        this.restoran = restoran;
        this.dostavljac = dostavljac;
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

    public Set<Artikli> getArtikli() {
        return artikli;
    }

    public void setArtikli(Set<Artikli> artikli) {
        this.artikli = artikli;
    }

    public Set<Restoran> getRestoran() {
        return restoran;
    }

    public void setRestoran(Set<Restoran> restoran) {
        this.restoran = restoran;
    }

    public void setDostavljac(Dostavljac dostavljac) {
        this.dostavljac = dostavljac;
    }

    public void setKupac(Kupac kupac) {
        this.kupac = kupac;
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

    @Override
    public String toString() {
        return "Porudzbina{" +
                "id=" + id +
                ", artikli=" + artikli +
                ", restoran=" + restoran +
                ", dostavljac=" + dostavljac +
                ", datum=" + datum +
                ", cena=" + cena +
                ", status=" + status +
                ", kupac=" + kupac +
                '}';
    }
}

