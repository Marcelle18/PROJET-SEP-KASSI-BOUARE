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
	 * M�thode retournant la liste des observateurs du capteur 
	 * @return La liste des canaux
	 */
	ArrayList<IObservateur> getObservateur();
	
	/**
	 * M�thode permettant de r�cup�rer la valeur diffus�e par le capteur
	 * @return la valeur du capteur
	 */
	int getValue();
	
	/**
	 * M�thode permettant d'incr�menter la valeur du capteur suivant le tempo
	 */
	void tick();
	
	/**
	 * M�thode retournant le capteur
	 * @return le capteur
	 */
	Capteur getCapteur();
}
