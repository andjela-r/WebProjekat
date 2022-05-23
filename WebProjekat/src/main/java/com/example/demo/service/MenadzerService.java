package com.example.demo.service;

import com.example.demo.dto.MenadzerDto;
import com.example.demo.entity.*;
import com.example.demo.repository.MenadzerRepository;
import com.example.demo.repository.RestoranRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class MenadzerService {

    @Autowired
    private MenadzerRepository menadzerRepository;
    @Autowired
    private RestoranRepository restoranRepository;

    public Menadzer createMenadzer(MenadzerDto menadzerDto){
        Restoran restoran = restoranRepository.getById(menadzerDto.getIdRestoran());
        if(restoran == null){
            return null;
        }
        Menadzer menadzer = new Menadzer(menadzerDto.getUsername(),
                                        menadzerDto.getPassword(),
                                        menadzerDto.getIme(),
                                        menadzerDto.getPrezime(),
                                        menadzerDto.getDatumRodjenja(),
                                        menadzerDto.getPol(),
                                        Uloga.MENADZER,
                                        restoran);
        if(menadzerRepository.existsByKorisnickoIme(menadzer.getKorisnickoIme())){
            return null; //menadzer postoji
        }
        save(menadzer);
        return menadzer;
    }

    public Menadzer save(Menadzer newMenadzer){
        return menadzerRepository.save(newMenadzer);

    }

}
