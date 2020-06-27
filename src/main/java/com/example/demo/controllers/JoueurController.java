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
import com.example.demo.model.Joueur;
import com.example.demo.repository.JoueurRepository;

@RestController
@RequestMapping("/api")
public class JoueurController {
	@Autowired
	JoueurRepository repo;
	
	@GetMapping("/joueurs")
	public List<Joueur> getAllJoueurs() {
	    return repo.findAll();
	}
	@PostMapping("/joueur")
	public Joueur createJoueur(@Valid @RequestBody Joueur joueur) {
	    return repo.save(joueur);
	}

	@PutMapping("/joueur")
	public Joueur updateJoueur(@Valid @RequestBody Joueur joueur) {
	    if(repo.existsById(joueur.getId())) {
	    	return repo.save(joueur);
	    }

	    return null;
	}
	

	@DeleteMapping("/joueur/{id}")
	public boolean deleteJoueur(@PathVariable Long id) {
	    if(repo.existsById(id)) {
	    	repo.deleteById(id);
	    	return true;
	    }

	    return false;
	}
	
	@GetMapping("/joueur/{id}")
	public Joueur getJoueur(@PathVariable Long id) {
		return repo.findById(id).orElseThrow(JoueurNotFoundException::new);
	}
}
