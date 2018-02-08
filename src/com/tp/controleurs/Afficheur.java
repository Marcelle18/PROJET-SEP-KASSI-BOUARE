package com.tp.controleurs;

import com.tp.interfaces.ICapteur;
import com.tp.interfaces.IObservateur;
import com.tp.vues.FenetreAfficheur;

/**
 *<b>Classe permettant d'obtenir le num�ro de l'afficheur et la valeur du capteur
 *afin de les afficher dans la fen�tre de l'afficheur</b>
 *<p>Un afficheur est caract�ris� par :
 *<ul>
 *<li>un num�ro d'afficheur</li>
 *<li>une valeur (celle du capteur)</li>
 *<li>une fen�tre</li>
 *</ul>
 *</p>
 * 
 *@see com.tp.interfaces.IObservateur
 */
public class Afficheur implements IObservateur{

	/**
	 * Le num�ro de l'afficheur
	 * @sse Afficheur#Afficheur(int)
	 */
	int numeroAfficheur;
	/**
	 * La valeur du capteur
	 * @see Afficheur#actualiser(ICapteur)
	 */
	int valeur;
	
	/**
	 * La fen�tre de l'afficheur
	 * @see FenetreAfficheur
	 */
	FenetreAfficheur fenetre;
	
	/**
	 * Constructeur de la classe, initialise le num�ro de l'afficheur et l'envoie � la fen�tre pour affichage 
	 * @param numero
	 * @see FenetreAfficheur
	 */
	public Afficheur(int numero){
		numeroAfficheur = numero;
		fenetre = new FenetreAfficheur(this);
		fenetre.setNumAfficheur(numero);
	}
	
	/**
	 * M�thode permettant d'actualiser la valeur du capteur
	 * @see com.tp.interfaces.IObservateur#actualiser(ICapteur)
	 */
	@Override
	public void actualiser(ICapteur capteur) {
		// TODO Auto-generated method stub
		valeur = capteur.getValue(); // prendre la valeur donn�e par le capteur
		fenetre.setValeur(valeur); // afficher la valeur re�ue
	}

}
