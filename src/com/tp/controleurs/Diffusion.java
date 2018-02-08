package com.tp.controleurs;

import com.tp.interfaces.*;

/**
 * <b>Classe Diffusion d�finissant les trois algorithmes de diffusion � savoir :
 * <p>
 * <ul>
 * <li>la diffusion atomique</li>
 * <li>la diffusion s�quentielle</li>
 * <li>la diffusion par �poque</li>
 * </ul>
 * </p>
 *</b>
 *<p>Cette classe est compos�e de : 
 *<ul>
 *<li>le capteur impl�mentant l'algorithme de diffusion</li>
 *<li>le nombre d'observateurs du capteur</li>
 *</ul>
 *</p>
 *@see com.tp.interfaces.IAlgoDiffusion
 *@see DiffusionAtomique
 *@see DiffusionSequentielle
 *@see DiffusionEpoque
 */
public abstract class Diffusion implements IAlgoDiffusion{
	/**
	 * le capteur impl�mentant l'algorithme de diffusion
	 * @see com.tp.interfaces.ICapteur
	 */
	ICapteur capteur;
	/**
	 * le nombre d'observateurs du capteur
	 */
	int nombreObservateurs;
	
	/**
	 * @see com.tp.interfaces.IAlgoDiffusion#configure(ICapteur)
	 */
	public void configure(ICapteur cap){
		this.capteur = cap;
		this.nombreObservateurs = cap.getObservateur().size();
	}
	
	/**
	 * @see com.tp.interfaces.IAlgoDiffusion#execute() 
	 */
	abstract public void execute();
	
	/**
	 * @see com.tp.interfaces.IAlgoDiffusion#retournerValeur()
	 */
	abstract public int retournerValeur();
}
