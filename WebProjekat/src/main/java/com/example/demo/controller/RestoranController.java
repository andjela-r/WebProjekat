package com.example.demo.controller;

import com.example.demo.entity.Restoran;
import com.example.demo.service.KupacService;
import com.example.demo.service.RestoranService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class RestoranController {

    @Autowired
    private RestoranService restoranService;

  /*  @RequestMapping(value = "/api/restoran/{restoran}" , method = RequestMethod.GET)
    public @ResponseBody
    List<Restoran> getUser(@PathVariable("restoran") String restoran) {
        return RestoranService.findByIme(restoran);
    }*/
}
