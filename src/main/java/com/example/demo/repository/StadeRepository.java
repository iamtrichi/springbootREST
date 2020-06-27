package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Match;
import com.example.demo.model.Stade;

@Repository
public interface StadeRepository extends JpaRepository<Stade, Long> {

}