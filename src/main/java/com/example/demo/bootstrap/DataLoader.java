package com.example.demo.bootstrap;

import java.sql.Date;
import java.util.ArrayList;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import com.example.demo.model.Equipe;
import com.example.demo.model.Joueur;
import com.example.demo.repository.EquipeRepository;
import com.example.demo.repository.JoueurRepository;


@Component
public class DataLoader implements ApplicationListener<ContextRefreshedEvent> {

	
	private JoueurRepository repository;
	private EquipeRepository rep;
	
	public DataLoader(JoueurRepository repository, EquipeRepository rep) {
		this.repository=repository;
		this.rep=rep;
	}
	
	@Override
	public void onApplicationEvent(ContextRefreshedEvent arg0) {
		// TODO Auto-generated method stub
		//Equipe team1 = new Equipe("Tunisie",new ArrayList<Joueur>(0), null);
		// Joueur j1 = new Joueur("Darragi", "Oussema", new Date(96,11,22), "MO");
		// Joueur j2 = new Joueur("Sallami", "Oussema", new Date(96,11,22), "MO");
		// Joueur j3 = new Joueur("Ali", "maaloul", new Date(96,11,22), "MO");
		// Joueur j4 = new Joueur("Hamza", "ben moulehom", new Date(96,11,22), "MO");
		// repository.save(j1);
		// repository.save(j2);
		// repository.save(j3);
		// repository.save(j4);
		// team1.getJoueurs().add(j1);
		// team1.getJoueurs().add(j2);
		// team1.getJoueurs().add(j3);
		// team1.getJoueurs().add(j4);
		// rep.save(team1);
		
		// team1 = new Equipe("Algérie",new ArrayList<Joueur>(0), null);
		// j1 = new Joueur("Mokhbi", "youssef", new Date(96,11,22), "MO");
		// j2 = new Joueur("Rhibi", "Hamdi", new Date(96,11,22), "MO");
		// j3 = new Joueur("Oussema", "Trichi", new Date(96,11,22), "MO");
		// j4 = new Joueur("Hamdi", "Ben ghdhehom", new Date(96,11,22), "MO");
		// repository.save(j1);
		// repository.save(j2);
		// repository.save(j3);
		// repository.save(j4);
		// team1.getJoueurs().add(j1);
		// team1.getJoueurs().add(j2);
		// team1.getJoueurs().add(j3);
		// team1.getJoueurs().add(j4);
		// rep.save(team1);
	}

}
