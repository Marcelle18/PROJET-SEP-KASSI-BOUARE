package com.tp.controleurs;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

import com.tp.vues.Accueil;

public class Demarrage {
	
	static Capteur capteur;

	public Demarrage(int tempo, int typeDiffusion, int nombreAfficheurs){
			
		ArrayList<Canal> listeCanal = new ArrayList<>();
			
		capteur = new Capteur(typeDiffusion);
			
		for(int i = 1; i <= nombreAfficheurs; i++){
			Canal canal = new Canal();
			listeCanal.add(canal);
			capteur.attach(canal);
		}
				
		TimerTask tacheMiseAJourCapteur = new TimerTask() {
			@Override
			public void run() {
				capteur.tick();
			}
		};
			
		Timer horloge = new Timer();
		horloge.schedule(tacheMiseAJourCapteur, 0 ,tempo);
	}	
	
	public static void main(String[] args) {
		Accueil accueil = new Accueil();	
	}
}
