package com.tp.interfaces;

/**
 * Interface Subject, observ� par les observateurs
 * @see IObservateur
 *
 */
public interface ISujetObserver {

	/**
	 * M�thode pour ajouter un observateur � sa liste d'observateurs
	 * @param obs
	 */
	void attach(IObservateur obs);
	
	/**
	 * M�thode pour supprimer un observateur de sa liste
	 * @param obs
	 */
	void detach(IObservateur obs);
}
