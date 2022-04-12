package com.example.demo.repository;

import com.example.demo.entity.Korisnik;
import org.springframework.data.jpa.repository.JpaRepository;

public interface KorisnikRepository extends JpaRepository<Korisnik, Long> {
    //OVDE UPITI

    /*
        Spring na osnovu imena metode kreira upit za bazu.

        Traži sve zaposlene (employee) koji imaju poziciju koja se prosledjuje ovoj metodi kao string (String position).
        Sortira sve koje je pronašao po imenu i vraća kolekciju zaposlenih.

    List<Employee> findAllByPositionOrderByFirstName(String position);

        Traži sve zaposlene po imenu ili prezimenu.

    List<Employee> findByFirstNameOrLastName(String firstName, String lastName);


        Traži sve zaposlene po imenu, ignorišu se mala i velika slova.

    List<Employee> findByFirstNameIgnoreCase(String firstName);


        Traži sve zaposlene po nazivu departmana.

    List<Employee> findByDepartmentName(String departmentName); */
}



