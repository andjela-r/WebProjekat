package com.example.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class StavkaPorudzbine {

    @Id
    @Column(name = "id", nullable = false)
    private Long id;

//    @ManyToOne
//    private Porudzbina porudzbina;

    @ManyToOne
    private Artikli artikli;

    private double narucenaKolicina;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

}
