package com.tp.controleurs;

import java.util.ArrayList;
import com.tp.interfaces.IAlgoDiffusion;
import com.tp.interfaces.ICapteur;
import com.tp.interfaces.IObservateur;

public class Canal implements IObservateur, ICapteur{

	int valeur;
	int numeroCanal;
	static int nombreCanal;
	IAlgoDiffusion algoDiffusion;
	Afficheur afficheur;
	
	public Canal(){
		nombreCanal++;
		numeroCanal = nombreCanal;
		afficheur = new Afficheur(numeroCanal);
	}
	
	
	@Override
	public void attach(IObservateur obs) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void detach(IObservateur obs) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ArrayList<IObservateur> getObservateur() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getValue() {
		// TODO Auto-generated method stub
		valeur = this.algoDiffusion.retournerValeur();
		System.out.println("Canal "+numeroCanal+" getValue : "+valeur);
		return valeur;
	}

	@Override
	public void tick() {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public Capteur getCapteur() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void actualiser(ICapteur capteur) {
		// TODO Auto-generated method stub
		//implementer réception des infos du capteur
		
	}


}
