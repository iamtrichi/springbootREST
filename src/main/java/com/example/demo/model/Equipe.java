package com.example.demo.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "Equipe")
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value = {"createdAt", "updatedAt"}, 
        allowGetters = true)
public class Equipe implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(unique = true)
	private String nomEquipe;
	
	private String urlLogo;
	
	@OneToMany
	@JoinColumn(name = "equipe_id")
	private List<Joueur> joueurs;
	
	@OneToMany
	@JoinColumn(name = "equipe_id")
	private List<Staff> staffs;

	
	
	public Equipe() {
		super();
	}

	public Equipe(String nomEquipe, List<Joueur> joueurs, List<Staff> staffs, String urlLogo) {
		super();
		this.nomEquipe = nomEquipe;
		this.joueurs = joueurs;
		this.staffs = staffs;
		this.urlLogo = urlLogo;
	}
	
	public Equipe(String nomEquipe, List<Joueur> joueurs, List<Staff> staffs) {
		super();
		this.nomEquipe = nomEquipe;
		this.joueurs = joueurs;
		this.staffs = staffs;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNomEquipe() {
		return nomEquipe;
	}

	public void setNomEquipe(String nomEquipe) {
		this.nomEquipe = nomEquipe;
	}

	public List<Joueur> getJoueurs() {
		return joueurs;
	}

	public void setJoueurs(List<Joueur> joueurs) {
		this.joueurs = joueurs;
	}

	public List<Staff> getStaffs() {
		return staffs;
	}

	public void setStaffs(List<Staff> staffs) {
		this.staffs = staffs;
	}

	public String getUrlLogo() {
		return urlLogo;
	}

	public void setUrlLogo(String urlLogo) {
		this.urlLogo = urlLogo;
	}
	
}
