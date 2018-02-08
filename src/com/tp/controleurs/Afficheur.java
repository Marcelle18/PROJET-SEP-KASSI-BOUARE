package com.tp.controleurs;

import com.tp.interfaces.ICapteur;
import com.tp.interfaces.IObservateur;
import com.tp.vues.FenetreAfficheur;

/**
 *<b>Classe permettant d'obtenir le numéro de l'afficheur et la valeur du capteur
 *afin de les afficher dans la fenêtre de l'afficheur</b>
 *<p>Un afficheur est caractérisé par :
 *<ul>
 *<li>un numéro d'afficheur</li>
 *<li>une valeur (celle du capteur)</li>
 *<li>une fenêtre</li>
 *</ul>
 *</p>
 * 
 *@see com.tp.interfaces.IObservateur
 */
public class Afficheur implements IObservateur{

	/**
	 * Le numéro de l'afficheur
	 * @sse Afficheur#Afficheur(int)
	 */
	int numeroAfficheur;
	/**
	 * La valeur du capteur
	 * @see Afficheur#actualiser(ICapteur)
	 */
	int valeur;
	
	/**
	 * La fenêtre de l'afficheur
	 * @see FenetreAfficheur
	 */
	FenetreAfficheur fenetre;
	
	/**
	 * Constructeur de la classe, initialise le numéro de l'afficheur et l'envoie à la fenêtre pour affichage 
	 * @param numero
	 * @see FenetreAfficheur
	 */
	public Afficheur(int numero){
		numeroAfficheur = numero;
		fenetre = new FenetreAfficheur(this);
		fenetre.setNumAfficheur(numero);
	}
	
	/**
	 * Méthode permettant d'actualiser la valeur du capteur
	 * @see com.tp.interfaces.IObservateur#actualiser(ICapteur)
	 */
	@Override
	public void actualiser(ICapteur capteur) {
		// TODO Auto-generated method stub
		valeur = capteur.getValue(); // prendre la valeur donnée par le capteur
		fenetre.setValeur(valeur); // afficher la valeur reçue
	}

}
