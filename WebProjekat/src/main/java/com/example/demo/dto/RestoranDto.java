package com.example.demo.dto;

import com.example.demo.entity.Lokacija;

public class RestoranDto {
        private String naziv;
        private String tip;
        private Long id_lokacija;
        private Long id_menadzera;


    public RestoranDto() {
    }

    public RestoranDto(String naziv, String tip, Long id_lokacija, Long id_menadzera) {
        this.naziv = naziv;
        this.tip = tip;
        this.id_lokacija = id_lokacija;
        this.id_menadzera = id_menadzera;
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

    public Long getId_lokacija() {
        return id_lokacija;
    }

    public void setId_lokacija(Long id_lokacija) {
        this.id_lokacija = id_lokacija;
    }

    public Long getId_menadzera() {
        return id_menadzera;
    }

    public void setId_menadzera(Long id_menadzera) {
        this.id_menadzera = id_menadzera;
    }
}
