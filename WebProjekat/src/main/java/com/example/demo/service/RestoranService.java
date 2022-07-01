package com.example.demo.service;

import com.example.demo.entity.Korisnik;
import com.example.demo.entity.Restoran;
import com.example.demo.repository.RestoranRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RestoranService {

    @Autowired
    private RestoranRepository restoranRepository;

    public Restoran getById(Long id) {
        return restoranRepository.getOne(id);
    }

    /*public String findByIme(String restoran){
        restoran;
    }*/
}
