package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Joueur;


@Repository
public interface JoueurRepository extends JpaRepository<Joueur, Long> {

}
