package com.tp.interfaces;

/**
 * Interface Observer 
 * @see ICapteur
 *
 */
public interface IObservateur {

	/**
	 * M�thode permettant d'actualiser la valeur diffus�e par le capteur
	 * @param capteur
	 */
	void actualiser(ICapteur capteur);
}
