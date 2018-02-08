package com.tp.interfaces;

import java.util.ArrayList;

import com.tp.controleurs.Capteur;

/**
 * Interface pour le capteur
 * @see ISujetObserver
 *
 */
public interface ICapteur extends ISujetObserver{

	/**
	 * Méthode retournant la liste des observateurs du capteur 
	 * @return La liste des canaux
	 */
	ArrayList<IObservateur> getObservateur();
	
	/**
	 * Méthode permettant de récupérer la valeur diffusée par le capteur
	 * @return la valeur du capteur
	 */
	int getValue();
	
	/**
	 * Méthode permettant d'incrémenter la valeur du capteur suivant le tempo
	 */
	void tick();
	
	/**
	 * Méthode retournant le capteur
	 * @return le capteur
	 */
	Capteur getCapteur();
}
