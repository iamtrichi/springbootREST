package com.example.demo.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "Matche")
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value = {"createdAt", "updatedAt"}, 
        allowGetters = true)
public class Match {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private java.util.Date date;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JsonIgnore
	private Stade stade;
	
	private int nbrSpectateurs;
	
	@ManyToMany
	@JoinTable(
			name = "match_arbitre",
			joinColumns = @JoinColumn(name = "arbitre_id"),
			inverseJoinColumns = @JoinColumn(name = "match_id")
			)
	private List<Arbitre> arbitres;
	
	@OneToOne
	private Equipe equipeA;
	
	@OneToOne
	private Equipe equipeB;

	private Integer scoreA;
	private Integer scoreB;
	public Match() {
		// TODO Auto-generated constructor stub
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public java.util.Date getDate() {
		return date;
	}

	public void setDate(java.util.Date date) {
		this.date = date;
	}

	public Stade getStade() {
		return stade;
	}

	public void setStade(Stade stade) {
		this.stade = stade;
	}

	public int getNbrSpectateurs() {
		return nbrSpectateurs;
	}

	public void setNbrSpectateurs(int nbrSpectateurs) {
		this.nbrSpectateurs = nbrSpectateurs;
	}
	
	public void ajouterSpectateur(int nbrSpectateur) {
		if(this.stade.getNbrSpectateursMax()<= this.nbrSpectateurs+nbrSpectateur)
			this.nbrSpectateurs += nbrSpectateur;
	}

	public Equipe getEquipeA() {
		return equipeA;
	}

	public void setEquipeA(Equipe equipeA) {
		this.equipeA = equipeA;
	}

	public Equipe getEquipeB() {
		return equipeB;
	}

	public void setEquipeB(Equipe equipeB) {
		this.equipeB = equipeB;
	}

	public Integer getScoreA() {
		return scoreA;
	}

	public void setScoreA(Integer scoreA) {
		this.scoreA = scoreA;
	}

	public Integer getScoreB() {
		return scoreB;
	}

	public void setScoreB(Integer scoreB) {
		this.scoreB = scoreB;
	}

	
	
}
