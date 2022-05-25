package com.example.demo.service;

import com.example.demo.repository.RestoranRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RestoranService {

    @Autowired
    private RestoranRepository restoranRepository;

    /*public String findByIme(String restoran){
        restoran;
    }*/
}
