package com.tp.controleurs;

import com.tp.interfaces.ICapteur;
import com.tp.interfaces.IObservateur;

public class Afficheur implements IObservateur{

	int numeroAfficheur;
	int valeur;
	
	public Afficheur(int numero){
		numeroAfficheur = numero;
	}
	
	@Override
	public void actualiser(ICapteur capteur) {
		// TODO Auto-generated method stub
		valeur = capteur.getValue(); // prendre la valeur donnée par le capteur
		
	}

}
