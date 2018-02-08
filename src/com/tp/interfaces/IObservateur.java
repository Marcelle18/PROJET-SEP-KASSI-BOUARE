package com.tp.interfaces;

/**
 * Interface Observer 
 * @see ICapteur
 *
 */
public interface IObservateur {

	/**
	 * Méthode permettant d'actualiser la valeur diffusée par le capteur
	 * @param capteur
	 */
	void actualiser(ICapteur capteur);
}
