package com.example.demo.entity;

import javax.persistence.*;

@Entity
public class StavkaPorudzbine {

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name="artikli", nullable=false)
    private Artikli artikli;

    @Column
    private double narucenaKolicina;

    public StavkaPorudzbine() {
    }

    public StavkaPorudzbine(Artikli artikli, double narucenaKolicina) {
        this.artikli = artikli;
        this.narucenaKolicina = narucenaKolicina;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Artikli getArtikli() {
        return artikli;
    }

    public void setArtikli(Artikli artikli) {
        this.artikli = artikli;
    }

    public double getNarucenaKolicina() {
        return narucenaKolicina;
    }

    public void setNarucenaKolicina(double narucenaKolicina) {
        this.narucenaKolicina = narucenaKolicina;
    }
}
