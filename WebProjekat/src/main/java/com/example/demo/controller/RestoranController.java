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

    @RequestMapping(value = "/api/restorani", method = RequestMethod.GET)
    public List<Restoran> getAllRestoran(){
        return restoranService.getAllRestoran();
    }

    @GetMapping("/api/restorani/pretraga-naziv/{naziv}")
    public List<Restoran> pretragaPoNazivu(@PathVariable String naziv){
        return restoranService.findByNaziv(naziv);
    }

    @GetMapping("/api/restorani/pretraga-tip/{tip}")
    public List<Restoran> pretragaPoTipu(@PathVariable String tip){
        return restoranService.findByTip(tip);
    }

    @GetMapping("/api/restorani/pretraga-lokacija/{lokacija}")
    public List<Restoran> pretragaPoLokaciji(@PathVariable Long id){
        return restoranService.getByLokacija(id);
    }

  /*  @RequestMapping(value = "/api/restoran/{restoran}" , method = RequestMethod.GET)
    public @ResponseBody
    List<Restoran> getUser(@PathVariable("restoran") String restoran) {
        return RestoranService.findByIme(restoran);
    }*/
}
