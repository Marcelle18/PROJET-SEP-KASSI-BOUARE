package com.tp.interfaces;

/**
 * Interface Subject, observé par les observateurs
 * @see IObservateur
 *
 */
public interface ISujetObserver {

	/**
	 * Méthode pour ajouter un observateur à sa liste d'observateurs
	 * @param obs
	 */
	void attach(IObservateur obs);
	
	/**
	 * Méthode pour supprimer un observateur de sa liste
	 * @param obs
	 */
	void detach(IObservateur obs);
}
