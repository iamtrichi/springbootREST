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
import com.example.demo.model.Staff;
import com.example.demo.repository.StaffRepository;

@RestController
@RequestMapping("/api")
public class StaffController {
	@Autowired
	StaffRepository repo;
	
	@GetMapping("/staffs")
	public List<Staff> getAllStaffs() {
	    return repo.findAll();
	}
	@PostMapping("/staff")
	public Staff createStaff(@Valid @RequestBody Staff staff) {
	    return repo.save(staff);
	}
	
	@PutMapping("/staff")
	public Staff updateJoueur(@Valid @RequestBody Staff staff) {
	    if(repo.existsById(staff.getId())) {
	    	return repo.save(staff);
	    }

	    return null;
	}
	

	@DeleteMapping("/staff/{id}")
	public boolean deleteJoueur(@PathVariable Long id) {
	    if(repo.existsById(id)) {
	    	repo.deleteById(id);
	    	return true;
	    }

	    return false;
	}

	@GetMapping("/staff/{id}")
	public Staff getStaff(@PathVariable Long id) {
		return repo.findById(id).orElseThrow(JoueurNotFoundException::new);
	}
}
