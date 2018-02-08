package com.tp.controleurs;

import com.tp.interfaces.ICapteur;
import com.tp.interfaces.IObservateur;
import com.tp.vues.FenetreAfficheur;

public class Afficheur implements IObservateur{

	int numeroAfficheur;
	int valeur;
	FenetreAfficheur fenetre;
	
	public Afficheur(int numero){
		numeroAfficheur = numero;
		fenetre = new FenetreAfficheur(this);
		fenetre.setNumAfficheur(numero);
	}
	
	@Override
	public void actualiser(ICapteur capteur) {
		// TODO Auto-generated method stub
		valeur = capteur.getValue(); // prendre la valeur donnée par le capteur
		fenetre.setValeur(valeur); // afficher la valeur reçue
	}

}
