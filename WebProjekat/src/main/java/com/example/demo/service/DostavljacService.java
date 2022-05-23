package com.example.demo.service;

import com.example.demo.dto.DostavljacDto;
import com.example.demo.entity.Dostavljac;
import com.example.demo.entity.Pol;
import com.example.demo.entity.Uloga;
import com.example.demo.repository.DostavljacRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class DostavljacService {

    @Autowired
    private DostavljacRepository dostavljacRepository;


}
