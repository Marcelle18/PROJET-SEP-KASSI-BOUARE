package com.tp.interfaces;

/**
 * Interface pour les algorithmes de diffusion.
 * @see ICapteur
 *
 */
public interface IAlgoDiffusion {

	/**
	 * Méthode pour configurer l'algorithme de diffusion
	 * @param capteur
	 */
	void configure(ICapteur capteur);
	
	/**
	 * Méthode pour exécuter l'algorithme de diffusion sélectionné
	 */
	void execute();
	
	/**
	 * Méthode retournant la valeur à diffuser
	 * @return La valeur à diffuser
	 */
	int retournerValeur();
}
