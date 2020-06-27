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
import com.example.demo.model.Stade;
import com.example.demo.repository.StadeRepository;

@RestController
@RequestMapping("/api")
public class StadeController {
	@Autowired
	StadeRepository repo;
	
	@GetMapping("/stades")
	public List<Stade> getAllStades() {
	    return repo.findAll();
	}
	@PostMapping("/stade")
	public Stade createStade(@Valid @RequestBody Stade stade) {
	    return repo.save(stade);
	}
	
	@PutMapping("/stade")
	public Stade updateJoueur(@Valid @RequestBody Stade stade) {
	    if(repo.existsById(stade.getId())) {
	    	return repo.save(stade);
	    }

	    return null;
	}
	
	@DeleteMapping("/stade/{id}")
	public boolean deleteJoueur(@PathVariable Long id) {
		if(repo.existsById(id)) {
	    	repo.deleteById(id);
	    	return true;
	    }
	    return false;
	}

	@GetMapping("/stade/{id}")
	public Stade getStade(@PathVariable Long id) {
		return repo.findById(id).orElseThrow(JoueurNotFoundException::new);
	}

	
}