package com.example.demo.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.exceptions.JoueurNotFoundException;
import com.example.demo.model.Match;
import com.example.demo.repository.MatchRepository;

@RestController
@RequestMapping("/api")
public class MatchController {
	@Autowired
	MatchRepository repo;
	
	@GetMapping("/matchs")
	public List<Match> getAllMatchs() {
	    return repo.findAll();
	}
	@PostMapping("/match")
	public Match createMatch(@Valid @RequestBody Match match) {
	    return repo.save(match);
	}
	
	@PutMapping("/match")
	public Match updateJoueur(@Valid @RequestBody Match match) {
	    if(repo.existsById(match.getId())) {
	    	return repo.save(match);
	    }

	    return null;
	}
	

	
	@DeleteMapping("/match/{id}")
	public boolean deleteJoueur(@PathVariable Long id) {
	    if(repo.existsById(id)) {
	    	repo.deleteById(id);
	    	return true;
	    }

	    return false;
	}

	@GetMapping("/match/{id}")
	public Match getMatch(@PathVariable Long id) {
		return repo.findById(id).orElseThrow(JoueurNotFoundException::new);
	}
}