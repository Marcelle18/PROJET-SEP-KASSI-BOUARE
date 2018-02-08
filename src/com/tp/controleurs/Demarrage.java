package com.tp.controleurs;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

import com.tp.vues.Accueil;

/**
 *<b>Classe g�rant l'interface de d�marrage de l'application et lan�ant l'application
 *avec les param�tres fournis. C'est le point d'entr�e de l'application</b> 
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
	 *<li>Cr�er un capteur impl�mentant l'algorithme de diffusion indiqu� par l'utilisateur</li>
	 *<li>Cr�er des canaux avec le nombre d'afficheurs fourni et les attacher au capteur</li>
	 *<li>Cr�er une t�che qui incr�mentera la valeur du capteur suivant le tempo d�fini</li>
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
	 * M�thode principale de l'application
	 * @param args
	 */
	public static void main(String[] args) {
		Accueil accueil = new Accueil();	
	}
}
