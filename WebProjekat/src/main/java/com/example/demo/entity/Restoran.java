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

    @ManyToMany
    @JoinTable(name = "imaArtikle",
            joinColumns = @JoinColumn(name = "restoran_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "artikli_id", referencedColumnName = "id"))
    private Set<Restoran> restoran = new HashSet<>();

    @ManyToMany
    @JoinTable(name = "pripadaPorudzbini",
            joinColumns = @JoinColumn(name = "restoran_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "porudzbina_id", referencedColumnName = "id"))
    private Set<Porudzbina> porudzbina = new HashSet<>();


    public Lokacija getLokacija() {
        return lokacija;
    }

    public Restoran() {
    }

    public Restoran(Long id, String naziv, String tip, Lokacija lokacija, Set<Restoran> restoran) {
        this.id = id;
        this.naziv = naziv;
        this.tip = tip;
        this.lokacija = lokacija;
        this.restoran = restoran;
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

    public Set<Restoran> getRestoran() {
        return restoran;
    }

    public void setRestoran(Set<Restoran> restoran) {
        this.restoran = restoran;
    }

    @Override
    public String toString() {
        return "Restoran{" +
                "id=" + id +
                ", naziv='" + naziv + '\'' +
                ", tip='" + tip + '\'' +
                ", lokacija=" + lokacija +
                ", restoran=" + restoran +
                ", porudzbina=" + porudzbina +
                '}';
    }
}

