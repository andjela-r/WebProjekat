package com.example.demo.repository;

import com.example.demo.entity.StavkaPorudzbine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.awt.*;

@Repository
public interface StavkaPorudzbineRepository extends JpaRepository<StavkaPorudzbine, Long>{

 //   List<StavkaPorudzbine> findAllByUserIdOrderByCreatedDateDesc(Integer userId);
}
