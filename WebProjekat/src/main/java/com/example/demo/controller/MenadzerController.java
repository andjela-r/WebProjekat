package com.example.demo.controller;

import com.example.demo.dto.MenadzerDto;
import com.example.demo.entity.Menadzer;
import com.example.demo.service.MenadzerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

@RestController
public class MenadzerController {
    @Autowired
    private MenadzerService menadzerService;


}
