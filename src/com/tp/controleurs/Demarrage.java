package com.tp.controleurs;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

import com.tp.vues.Accueil;

/**
 *<b>Classe gérant l'interface de démarrage de l'application et lançant l'application
 *avec les paramètres fournis. C'est le point d'entrée de l'application</b> 
 *@see Capteur
 *@see Canal
 */
public class Demarrage {
	
	static Capteur capteur;

	/**
	 *<b>Constructeur de la classe./b>
	 *<p>
	 *Permet de :
	 *<ul>
	 *<li>Créer un capteur implémentant l'algorithme de diffusion indiqué par l'utilisateur</li>
	 *<li>Créer des canaux avec le nombre d'afficheurs fourni et les attacher au capteur</li>
	 *<li>Créer une tâche qui incrémentera la valeur du capteur suivant le tempo défini</li>
	 *</ul>
	 *</p>
	 *@see Capteur
	 *@see Canal
	 *
	 * @param tempo
	 * @param typeDiffusion
	 * @param nombreAfficheurs
	 */
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
	
	/**
	 * Méthode principale de l'application
	 * @param args
	 */
	public static void main(String[] args) {
		Accueil accueil = new Accueil();	
	}
}
