package com.example.demo.dto;

import com.example.demo.entity.Artikli;
import com.example.demo.entity.Kupac;

public class KorpaDto {
    private Kupac kupac;
    private Artikli artikli;
    private double kolicina;

    public KorpaDto(Kupac kupac, Artikli artikli, double kolicina) {
        this.kupac = kupac;
        this.artikli = artikli;
        this.kolicina = kolicina;
    }

    public KorpaDto() {
    }

    public Kupac getKupac() {
        return kupac;
    }

    public void setKupac(Kupac kupac) {
        this.kupac = kupac;
    }

    public Artikli getArtikli() {
        return artikli;
    }

    public void setArtikli(Artikli artikli) {
        this.artikli = artikli;
    }

    public double getKolicina() {
        return kolicina;
    }

    public void setKolicina(double kolicina) {
        this.kolicina = kolicina;
    }

    @Override
    public String toString() {
        return "KorpaDto{" +
                "kupac=" + kupac +
                ", artikli=" + artikli +
                ", kolicina=" + kolicina +
                '}';
    }
}
