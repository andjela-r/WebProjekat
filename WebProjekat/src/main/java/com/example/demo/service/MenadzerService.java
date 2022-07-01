package com.example.demo.service;

import com.example.demo.entity.*;
import com.example.demo.repository.MenadzerRepository;
import com.example.demo.repository.RestoranRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MenadzerService {

    @Autowired
    private MenadzerRepository menadzerRepository;
    @Autowired
    private RestoranRepository restoranRepository;


    public Optional<Menadzer> findById(Long id) {
        return menadzerRepository.findById(id);
    }
}
