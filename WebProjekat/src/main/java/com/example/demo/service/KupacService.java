package com.example.demo.service;

import com.example.demo.dto.RegisterDto;
import com.example.demo.entity.Kupac;
import com.example.demo.entity.Pol;
import com.example.demo.entity.Uloga;
import com.example.demo.repository.KupacRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Date;
import java.util.List;

@Service
public class KupacService {

    @Autowired
    private KupacRepository kupacRepository;

    public Kupac getById(Long id) {

        return kupacRepository.getOne(id);
    }

    public List<Kupac> findAll() {

        return kupacRepository.findAll();
    }

    public Kupac register (RegisterDto kupacDto){
        Kupac kupac = new Kupac(kupacDto.getUsername(),
                                kupacDto.getPassword(),
                                kupacDto.getIme(),
                                kupacDto.getPrezime(),
                                kupacDto.getDatumRodjenja(),
                                kupacDto.getPol(),
                                Uloga.KUPAC);
        if(kupacRepository.existsByKorisnickoIme(kupac.getKorisnickoIme())){
            return null; //kupac postoji
        }
        kupacRepository.save(kupac);
        return kupac;
    }

    public void updateKupac(Kupac kupac){
        kupacRepository.save(kupac);
    }

}
