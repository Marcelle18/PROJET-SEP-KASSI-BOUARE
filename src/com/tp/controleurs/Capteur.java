package com.tp.controleurs;

import java.util.ArrayList;

import com.tp.interfaces.IAlgoDiffusion;
import com.tp.interfaces.ICapteur;
import com.tp.interfaces.IObservateur;

public class Capteur implements ICapteur{

	ArrayList<IObservateur> observateur;
	int valeur;
	IAlgoDiffusion algoDiffusion;
	
	public Capteur(int typeDiffusion){
		observateur = new ArrayList<IObservateur>();
		valeur = 0;
		switch(typeDiffusion){
			case 0:
				algoDiffusion = new DiffusionAtomique();
				break;
			case 1:
				algoDiffusion = new DiffusionSequentielle();
				break;
			case 2:
				algoDiffusion = new DiffusionEpoque();
			default:
				System.out.println("Aucun type de diffusion sélectionné");
				break;
		}
		algoDiffusion.configure(this);
	}
	
	@Override
	public void attach(IObservateur obs) {
		// TODO Auto-generated method stub
		
		observateur.add(obs);  //ajouter un observateur à l'arraylist
		algoDiffusion.configure(this); //mettre à jour le capteur
		
	}

	@Override
	public void detach(IObservateur obs) {
		// TODO Auto-generated method stub
		observateur.remove(obs); //retirer un observateur à l'arraylist
		algoDiffusion.configure(this); // mettre à jour le capteur
		
	}

	@Override
	public ArrayList<IObservateur> getObservateur() {
		// TODO Auto-generated method stub
		return observateur; // retourner la liste des observateurs
	}

	@Override
	public int getValue() {
		// TODO Auto-generated method stub
		return valeur; // retourner la valeur à diffuser
	}

	@Override
	public void tick() {
		// TODO Auto-generated method stub
		valeur++; // incrémenter la valeur
		algoDiffusion.execute();//diffuser sur tous les canaux
		
	}

	@Override
	public Capteur getCapteur() {
		// TODO Auto-generated method stub
		return this;
		
	}

}
