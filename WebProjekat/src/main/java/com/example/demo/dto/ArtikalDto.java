package com.example.demo.dto;

import com.example.demo.entity.TIP;

public class ArtikalDto {
    private String naziv;
    private double cena;
    private TIP tip;
    private double kolicina;
    private String opis;

    public ArtikalDto(String naziv, double cena, TIP tip, double kolicina, String opis) {
        this.naziv = naziv;
        this.cena = cena;
        this.tip = tip;
        this.kolicina = kolicina;
        this.opis = opis;
    }

    public ArtikalDto() {
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public double getCena() {
        return cena;
    }

    public void setCena(double cena) {
        this.cena = cena;
    }

    public TIP getTip() {
        return tip;
    }

    public void setTip(TIP tip) {
        this.tip = tip;
    }



    public double getKolicina() {
        return kolicina;
    }

    public void setKolicina(double kolicina) {
        this.kolicina = kolicina;
    }

    public String getOpis() {
        return opis;
    }

    public void setOpis(String opis) {
        this.opis = opis;
    }
}
