package com.tp.controleurs;

import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

import com.tp.interfaces.IAlgoDiffusion;
import com.tp.interfaces.ICapteur;
import com.tp.interfaces.IObservateur;

/**
 * Classe permettant d'actualiser la valeur diffusée par le capteur observé en implémentant 
 * le patron ActiveObject et de l'envoyer à l'afficheur.
 * <p>Elle est composée de :
 * <ul>
 * <li>l'algorithme de diffusion utilisé</li>
 * <li>son numéro qui équivaut au numéro de l'afficheur</li>
 * <li>l'afficheur auquel elle envoie la valeur du capteur</li>
 * </ul>
 * </p>
 * @see com.tp.interfaces.IObservateur
 * @see com.tp.interfaces ICapteur
 * @see Afficheur
 *
 */
public class Canal implements IObservateur, ICapteur{

	/**
	 * Valeur diffusée par le capteur observé
	 * @see Canal#getValue()
	 */
	int valeur;
	
	/**
	 * Numéro du canal
	 * @see Canal#Canal()
	 */
	int numeroCanal;
	static int nombreCanal;
	
	/**
	 * Algorithme de diffusion utilisé par le capteur
	 * @see Canal#getValue()
	 * @see Canal#actualiser(ICapteur)
	 */
	IAlgoDiffusion algoDiffusion;
	
	/**
	 * Afficheur du canal
	 * @see Canal#Canal()
	 */
	Afficheur afficheur;
	
	/**
	 * Constructeur du canal. Définit le numéro du canal et instancie l'afficheur avec son numéro
	 * @see Afficheur#Afficheur(int)
	 */
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

	/**
	 * Méthiode pour récupérer la valeur diffusée par le capteur
	 * @return La valeur diffusée par le capteur
	 */
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

	/**
	 * Méthode permettant d'actualiser la valeur diffusée par le capteur en interalles de temps aléatoires avec Activeobject.
	 * @see Afficheur#actualiser(ICapteur)
	 */
	@Override
	public void actualiser(ICapteur capteur) {
		// TODO Auto-generated method stub
		//implementer réception des infos du capteur
		algoDiffusion = capteur.getCapteur().algoDiffusion;
		System.out.println("Mise à jour du canal : "+numeroCanal);
		
		Random r = new Random();
		int intervalle = 500 + r.nextInt(1000 - 500);
		ScheduledExecutorService execution = Executors.newScheduledThreadPool(nombreCanal);

		ScheduledFuture<Object> execFuture = execution.schedule(new Callable<Object>() {
		        public Object call() throws Exception {
		        			        	
		        	afficheur.actualiser(Canal.this);

		            return null;
		        }
		    }, intervalle, TimeUnit.MILLISECONDS);
		
		
		try {
			execFuture.get();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (ExecutionException e) {
			e.printStackTrace();
		}
		
		System.out.println("Mise à jour du canal - Tempo : " + numeroCanal);
		
	}


}
