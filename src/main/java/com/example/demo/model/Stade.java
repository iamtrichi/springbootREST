package com.example.demo.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "Stade")
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value = {"createdAt", "updatedAt"}, 
        allowGetters = true)
public class Stade {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private String nom;
	private String urlImage;
	private String adresse;
	private int nbrSpectateursMax;
	
	@OneToMany
	@JoinColumn(name = "stade_id")
	@JsonIgnore
	private List<Match> matches;
	
	public Stade() {
		// TODO Auto-generated constructor stub
	}

	public Stade(String nom, String adresse, int nbrSpectateursMax) {
		super();
		this.nom = nom;
		this.adresse = adresse;
		this.nbrSpectateursMax = nbrSpectateursMax;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getAdresse() {
		return adresse;
	}

	public String getNom() {
		return this.nom;
	}

	public String getUrlImage() {
		return this.urlImage;
	}

	public void setUrlImage(String nom) {
		this.urlImage = nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public int getNbrSpectateursMax() {
		return nbrSpectateursMax;
	}

	public void setNbrSpectateursMax(int nbrSpectateursMax) {
		this.nbrSpectateursMax = nbrSpectateursMax;
	}

}
