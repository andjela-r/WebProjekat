package com.example.demo.controller;

import com.example.demo.dto.DostavljacDto;
import com.example.demo.entity.Dostavljac;
import com.example.demo.service.DostavljacService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

@RestController
public class DostavljacController {
    @Autowired
    private DostavljacService dostavljacService;



}
