package com.example.demo.service;

import com.example.demo.entity.Artikli;
import com.example.demo.repository.ArtikliRepository;
import org.springframework.stereotype.Service;

@Service
public class ArtikliService {

    private ArtikliRepository artikliRepository;

    public ArtikliService(ArtikliRepository artikliRepository) {
        this.artikliRepository = artikliRepository;
    }

    public Artikli getById(Long id) {

        return artikliRepository.getOne(id);
    }
    public void updateArtikli(Artikli a){
        artikliRepository.save(a);
    }

    /*public void brisanjeArtikla(Artikli a) {
       artikliRepository.deleteById(a.getId());
    }*/

  /*  public Artikli nadjiArtikal(Long id) {
       return artikliRepository.findById(id);
    }*/
}
