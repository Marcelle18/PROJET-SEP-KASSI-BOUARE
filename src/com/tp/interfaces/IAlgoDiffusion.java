package com.tp.interfaces;

/**
 * Interface pour les algorithmes de diffusion.
 * @see ICapteur
 *
 */
public interface IAlgoDiffusion {

	/**
	 * M�thode pour configurer l'algorithme de diffusion
	 * @param capteur
	 */
	void configure(ICapteur capteur);
	
	/**
	 * M�thode pour ex�cuter l'algorithme de diffusion s�lectionn�
	 */
	void execute();
	
	/**
	 * M�thode retournant la valeur � diffuser
	 * @return La valeur � diffuser
	 */
	int retournerValeur();
}
