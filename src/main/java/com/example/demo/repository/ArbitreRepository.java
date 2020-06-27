package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Arbitre;

@Repository
public interface ArbitreRepository extends JpaRepository<Arbitre, Long> {

}
