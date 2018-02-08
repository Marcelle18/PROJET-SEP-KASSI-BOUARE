package com.tp.controleurs;

import java.util.ArrayList;

import com.tp.interfaces.IAlgoDiffusion;
import com.tp.interfaces.ICapteur;
import com.tp.interfaces.IObservateur;

/**
 *<b>Classe Capteur, observ�e par un afficheur et impl�mentant un algorithme de diffusion pour diffuser
 *sa valeur.</b> 
 *<p>
 *Cette classe est compos�e de :
 *<ul>
 *<li>sa valeur</li>
 *<li>la liste de ses observateurs</li>
 *<li>l'algorithme de diffusion qu'elle impl�mente</li>
 *</ul>
 *</p>
 *
 */
public class Capteur implements ICapteur{

	/**
	 * la liste d'observateurs du capteur
	 * @see com.tp.interfaces.IObservateur
	 */
	ArrayList<IObservateur> observateur;
	
	/**
	 * la valeur du capteur
	 */
	int valeur;
	
	/**
	 * l'algorithme de diffusion utilis� par le capteur
	 * @see com.tp.interfaces.IAlgoDiffusion
	 */
	IAlgoDiffusion algoDiffusion;
	
	/**
	 * Constructeur du capteur. D�finit l'algorithme de diffusion � impl�menter
	 * @param typeDiffusion
	 */
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
				System.out.println("Aucun type de diffusion s�lectionn�");
				break;
		}
		algoDiffusion.configure(this);
	}
	
	/**
	 * @see com.tp.interfaces.ICapteur#attach(IObservateur)
	 */
	@Override
	public void attach(IObservateur obs) {
		// TODO Auto-generated method stub
		
		observateur.add(obs);  //ajouter un observateur � l'arraylist
		algoDiffusion.configure(this); //mettre � jour le capteur
		
	}

	/**
	 * @see com.tp.interfaces.ICapteur#detach(IObservateur)
	 */
	@Override
	public void detach(IObservateur obs) {
		// TODO Auto-generated method stub
		observateur.remove(obs); //retirer un observateur � l'arraylist
		algoDiffusion.configure(this); // mettre � jour le capteur
		
	}

	/**
	 * @see com.tp.interfaces.ICapteur#getObservateur()
	 */
	@Override
	public ArrayList<IObservateur> getObservateur() {
		// TODO Auto-generated method stub
		return observateur; // retourner la liste des observateurs
	}

	/**
	 * @see com.tp.interfaces.ICapteur#getValue()
	 */
	@Override
	public int getValue() {
		// TODO Auto-generated method stub
		return valeur; // retourner la valeur � diffuser
	}

	/**
	 * @see com.tp.interfaces.ICapteur#tick()
	 */
	@Override
	public void tick() {
		// TODO Auto-generated method stub
		valeur++; // incr�menter la valeur
		algoDiffusion.execute();//diffuser sur tous les canaux
		
	}

	/**
	 * @see com.tp.interfaces.ICapteur#getCapteur()
	 */
	@Override
	public Capteur getCapteur() {
		// TODO Auto-generated method stub
		return this;
		
	}

}
