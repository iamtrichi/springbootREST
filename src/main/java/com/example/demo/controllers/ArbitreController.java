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
import com.example.demo.model.Arbitre;
import com.example.demo.repository.ArbitreRepository;

@RestController
@RequestMapping("/api")
public class ArbitreController {
	@Autowired
	ArbitreRepository repo;
	
	@GetMapping("/arbitres")
	public List<Arbitre> getAllArbitres() {
	    return repo.findAll();
	}
	
	@PostMapping("/arbitre")
	public Arbitre createArbitre(@RequestBody Arbitre arbitre) {
	    return repo.save(arbitre);
	}
	
	@PutMapping("/arbitre")
	public Arbitre updateJoueur(@Valid @RequestBody Arbitre arbitre) {
	    if(repo.existsById(arbitre.getId())) {
	    	return repo.save(arbitre);
	    }

	    return null;
	}
	

	@DeleteMapping("/arbitre/{id}")
	public boolean deleteJoueur(@PathVariable Long id) {
	    if(repo.existsById(id)) {
	    	repo.deleteById(id);
	    	return true;
	    }

	    return false;
	}
	
	@GetMapping("/arbitre/{id}")
	public Arbitre getArbitre(@PathVariable Long id) {
		return repo.findById(id).orElseThrow(JoueurNotFoundException::new);
	}
}
