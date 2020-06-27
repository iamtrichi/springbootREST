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
import com.example.demo.model.Equipe;
import com.example.demo.model.Joueur;
import com.example.demo.repository.EquipeRepository;
import com.example.demo.repository.JoueurRepository;


@RestController
@RequestMapping("/api")
public class EquipeController {
	@Autowired
	EquipeRepository repo;
	
	@GetMapping("/equipes")
	public List<Equipe> getAllEquipes() {
	    return repo.findAll();
	}
	@PostMapping("/equipe")
	public Equipe createEquipe(@Valid @RequestBody Equipe equipe) {
	    return repo.save(equipe);
	}
	
	@PutMapping("/equipe")
	public Equipe updateJoueur(@Valid @RequestBody Equipe equipe) {
	    if(repo.existsById(equipe.getId())) {
	    	return repo.save(equipe);
	    }

	    return null;
	}
	

	@DeleteMapping("/equipe/{id}")
	public boolean deleteJoueur(@PathVariable Long id) {
		if(repo.existsById(id)) {
	    	repo.deleteById(id);
	    	return true;
	    }
	    return false;
	}


	
	@GetMapping("/equipe/{id}")
	public Equipe getEquipe(@PathVariable Long id) {
		return repo.findById(id).orElseThrow(JoueurNotFoundException::new);
	}
}
