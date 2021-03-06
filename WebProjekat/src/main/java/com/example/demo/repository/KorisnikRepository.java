package com.example.demo.repository;

import com.example.demo.entity.Korisnik;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface KorisnikRepository extends JpaRepository<Korisnik, Long> {
    List<Korisnik> findAll();
    Korisnik getById(Long aLong);
    Korisnik getByKorisnickoIme(String username);
    boolean existsByKorisnickoIme(String username);

    List<Korisnik> findByIme(String ime);
    List<Korisnik> findByPrezime(String prezime);
    List<Korisnik> findByKorisnickoIme(String korisnickoIme);


    //    boolean updateKorisnik(
//            Long id,
//            String korisnickoIme,
//            String lozinka,
//            String ime,
//            String prezime,
//            Date datumRodjenja,
//            Pol pol,
//            Uloga uloga);
//    boolean deleteKorisnik(Long id);

}



